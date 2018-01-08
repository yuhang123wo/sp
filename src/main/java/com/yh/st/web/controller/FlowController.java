package com.yh.st.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yh.st.base.controller.BaseController;
import com.yh.st.base.domain.WorkFlow;
import com.yh.st.base.service.FlowService;
import com.yh.st.base.service.UserinfoService;
import com.yh.st.common.result.ResultData;
import com.yh.st.common.result.ResultMsg;
import com.yh.st.common.util.UserUtil;

@Controller
@RequestMapping("flow")
public class FlowController extends BaseController<WorkFlow> {

	@Autowired
	private FlowService flowService;
	@Autowired
	private UserinfoService userinfoService;

	@Override
	protected String getPrefix() {
		return "flow/flow-";
	}

	@RequestMapping(value = "work/list", method = RequestMethod.GET)
	public String workList(HttpServletRequest request) {
		return "flow/work-list";
	}

	/**
	 * 启用流程
	 * 
	 * @param userId
	 * @param flowId
	 * @return ResultData
	 */
	@RequestMapping(value = "enablingFlow")
	@ResponseBody
	public ResultData enablingFlow(long flowId) {
		WorkFlow flow = flowService.getWorkFlow(flowId);
		if (flow == null) {
			return new ResultData(ResultMsg.FAILCODE, "流程不存在");
		}
		flowService.processDeployWorkFlow(flowId);
		return new ResultData("");
	}

	@RequestMapping(value = "work/listData", method = RequestMethod.POST)
	@ResponseBody
	public ResultData workListData(HttpServletRequest request) {
		return new ResultData(flowService.getTask(UserUtil.getUser().getId()));
	}
}
