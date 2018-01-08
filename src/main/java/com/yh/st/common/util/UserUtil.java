package com.yh.st.common.util;

import org.apache.shiro.SecurityUtils;

import com.yh.st.base.domain.Userinfo;

public class UserUtil {

	public static Userinfo getUser() {
		Userinfo u = (Userinfo) SecurityUtils.getSubject().getPrincipal();
		return u;
	}
}
