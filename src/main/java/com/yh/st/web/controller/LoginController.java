package com.yh.st.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author yh
 * @Date 2017年10月27日
 * @desc
 */
@Controller
public class LoginController {
	/**
	 * 
	 * @return
	 */
	@RequestMapping("login")
	public String login() {
		return "login";
	}

	/**
	 * index
	 */
	@RequestMapping("index")
	public String home() {
		return "index";
	}
}
