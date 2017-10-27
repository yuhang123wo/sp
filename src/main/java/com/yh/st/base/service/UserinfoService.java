package com.yh.st.base.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.yh.st.base.domain.Auth;
import com.yh.st.base.domain.Role;
import com.yh.st.base.domain.Userinfo;

public interface UserinfoService {

	/**
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	PageInfo<Userinfo> queryUserinfo(int pageNo, int pageSize);

	/**
	 * 
	 * @return
	 */
	List<Role> findRoleAll();

	/**
	 * 
	 * @return
	 */
	List<Auth> findAuthAll();
}
