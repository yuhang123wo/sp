package com.yh.st.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yh.st.base.service.UserinfoService;

/**
 * 
 * @author yh
 * @Date 2017年10月13日
 * @desc
 */
@Controller
@RequestMapping(value = "user", method = { RequestMethod.POST,
		RequestMethod.GET })
public class UserController {

	@Resource
	private UserinfoService userinfoService;

	@RequestMapping("testUU")
	public String testUU() {
		userinfoService.queryUserinfo(1, 1).getList().get(0).getId();
		return "dfdsfdfs";
	}
}
