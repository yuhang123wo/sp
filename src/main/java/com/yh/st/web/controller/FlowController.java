package com.yh.st.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yh.st.base.controller.BaseController;
import com.yh.st.base.domain.WorkFlow;

@Controller
@RequestMapping("flow")
public class FlowController extends BaseController<WorkFlow> {

	@Override
	protected String getPrefix() {
		return "flow/leave-";
	}

}
