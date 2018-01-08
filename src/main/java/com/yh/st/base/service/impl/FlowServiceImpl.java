package com.yh.st.base.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.stereotype.Service;

import com.github.abel533.entity.Example;
import com.github.abel533.mapper.Mapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yh.st.base.Constant;
import com.yh.st.base.domain.WorkFlow;
import com.yh.st.base.exception.ErrorException;
import com.yh.st.base.mapper.WorkFlowMapper;
import com.yh.st.base.service.FlowService;

@Service
public class FlowServiceImpl extends BaseServiceImpl<WorkFlow> implements FlowService {

	@Resource
	private RepositoryService repositoryService;
	@Resource
	private RuntimeService runtimeService;
	@Resource
	private TaskService taskService;
	@Resource
	private HistoryService historyService;
	@Resource
	private IdentityService identityService;
	@Resource
	private ProcessEngine processEngine;
	@Resource
	private WorkFlowMapper workFlowMapper;

	@Override
	public void processDeployWorkFlow(long resourceId) {
		WorkFlow f = workFlowMapper.selectByPrimaryKey(resourceId);
		if (f == null)
			throw new ErrorException("流程不存在");
		repositoryService.createDeployment().name(f.getName())
				.addClasspathResource(Constant.DEPLOY_PATH + f.getSource())
				.addClasspathResource(Constant.DEPLOY_PATH + f.getSourceImg()).deploy();
	}

	@Override
	public ProcessInstance processStartInstance(String key, long authUser,
			Map<String, Object> variables) {
		ProcessInstance processInstance = null;
		try {
			// 用来设置启动流程的人员ID，引擎会自动把用户ID保存到activiti:initiator中
			identityService.setAuthenticatedUserId(String.valueOf(authUser));
			processInstance = runtimeService.startProcessInstanceByKey(key, variables);
		} finally {
			identityService.setAuthenticatedUserId(null);
		}
		return processInstance;
	}

	@Override
	public List<Task> getTask(long userId) {
		List<Task> tasks = taskService.createTaskQuery()// 创建一个任务查询对象
				.taskCandidateOrAssigned(String.valueOf(userId)).list();
		return tasks;
	}

	@Override
	public void updateTask(String taskId) {
		taskService.complete(taskId);
	}

	@Override
	public Mapper<WorkFlow> getDao() {
		return workFlowMapper;
	}

	
	@Override
	public PageInfo<WorkFlow> queryPageByParmas(Map<String, Object> map, int pageNo, int pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		Example example = new Example(WorkFlow.class);
		example.createCriteria().andEqualTo("state",WorkFlow.STATE_ON);
		List<WorkFlow> list = this.getDao().selectByExample(example);
		return new PageInfo<WorkFlow>(list);
	}
}
