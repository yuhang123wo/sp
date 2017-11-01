package com.yh.st.base.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.yh.st.base.domain.Auth;
import com.yh.st.base.domain.Role;
import com.yh.st.base.domain.Userinfo;
import com.yh.st.base.vo.MenuVo;

public interface UserinfoService {

	/**
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	PageInfo<Userinfo> queryUserinfo(Map<String, Object> params,int pageNo, int pageSize);

	/**
	 * 取所有角色
	 * 
	 * @return
	 */
	List<Role> findRoleAll();

	/**
	 * 取所有权限
	 * 
	 * @return
	 */
	List<Auth> findAuthAll();

	/**
	 * 查询用户菜单
	 * 
	 * @param userId
	 * @return
	 */
	List<MenuVo> findMenuByUserId(long userId);
}
