package com.yh.st.base.vo;

import java.util.List;

import com.yh.st.base.domain.Auth;

public class MenuVo {

	private Auth auth;

	private List<Auth> child;

	/**
	 * @return the auth
	 */
	public Auth getAuth() {
		return auth;
	}

	/**
	 * @param auth
	 *            the auth to set
	 */
	public void setAuth(Auth auth) {
		this.auth = auth;
	}

	/**
	 * @return the child
	 */
	public List<Auth> getChild() {
		return child;
	}

	/**
	 * @param child
	 *            the child to set
	 */
	public void setChild(List<Auth> child) {
		this.child = child;
	}

}
