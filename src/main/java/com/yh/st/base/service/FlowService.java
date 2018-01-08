package com.yh.st.base.service;

import java.util.List;
import java.util.Map;

import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

import com.yh.st.base.domain.WorkFlow;

public interface FlowService extends BaseService<WorkFlow> {
	/**
	 * 部署流程
	 * 
	 * @param name
	 * @param source
	 * @param sourceImg
	 *            void
	 */
	void processDeployWorkFlow(long resourceId);

	/**
	 * 启动实例
	 * 
	 * @param key
	 * @param authUser
	 * @param variables
	 * @return ProcessInstance
	 */
	ProcessInstance processStartInstance(String key, long authUser, Map<String, Object> variables);

	/**
	 * 取任务
	 * 
	 * @param userId
	 * @return List<Task>
	 */
	List<Task> getTask(long userId);

	/**
	 * 更新任务
	 * 
	 * @param taskId
	 *            void
	 */
	void updateTask(String taskId);

	/**
	 * 
	 * @return WorkFlow
	 */
	WorkFlow getWorkFlow(long flowId);

}
