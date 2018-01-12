package com.yh.st.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yh.st.base.controller.BaseController;
import com.yh.st.base.domain.SysDept;
import com.yh.st.base.service.BaseService;
import com.yh.st.base.service.SysDeptService;

@Controller
@RequestMapping("dept")
public class SysDeptController extends BaseController<SysDept> {
	@Resource
	private SysDeptService sysDeptService;

	@Override
	protected String getPrefix() {
		return "sys/dept-";
	}

	@Override
	protected BaseService<SysDept> getService() {
		return sysDeptService;
	}

}
