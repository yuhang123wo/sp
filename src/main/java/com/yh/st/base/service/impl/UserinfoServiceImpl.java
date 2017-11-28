package com.yh.st.base.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.abel533.entity.Example;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yh.st.base.domain.Auth;
import com.yh.st.base.domain.Role;
import com.yh.st.base.domain.RoleAuth;
import com.yh.st.base.domain.Userinfo;
import com.yh.st.base.exception.ErrorException;
import com.yh.st.base.mapper.AuthMapper;
import com.yh.st.base.mapper.RoleMapper;
import com.yh.st.base.mapper.UserinfoMapper;
import com.yh.st.base.service.UserinfoService;
import com.yh.st.base.vo.MenuVo;
import com.yh.st.common.util.MenuTool;
import com.yh.st.common.util.StringUtil;

@Service("userinfoService")
public class UserinfoServiceImpl implements UserinfoService {

	@Resource
	private UserinfoMapper userinfoMapper;
	@Resource
	private RoleMapper roleMapper;
	@Resource
	private AuthMapper authMapper;

	@Override
	public PageInfo<Userinfo> queryUserinfo(Map<String, Object> params, int pageNo, int pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		List<Userinfo> list = userinfoMapper.findUserinfoByParams(params);
		return new PageInfo<Userinfo>(list);
	}

	@Override
	public List<Role> findRoleAll() {
		return roleMapper.select(null);
	}

	@Override
	public List<Auth> findAuthAll() {
		return authMapper.select(null);
	}

	@Override
	public List<MenuVo> findMenuByUserId(long userId) {
		List<MenuVo> list = MenuTool.getMenu(authMapper.findAuthByUserId(userId));
		return list;
	}

	@Override
	public List<Role> listRoleByUserId(long userId, int pageNo, int pageSize) {
		return roleMapper.listRoleByUserId(userId);
	}

	@Override
	public PageInfo<Role> queryRole(Map<String, Object> params, int pageNo, int pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		Example example = new Example(Role.class);
		if (StringUtil.objIsNotNull(params.get("name"))) {
			example.createCriteria().andLike("name", params.get("name").toString());
		}
		List<Role> list = roleMapper.selectByExample(example);
		return new PageInfo<Role>(list);
	}

	@Override
	public List<Long> listAuthByRoleId(long roleId) {
		return authMapper.listAuthByRoleId(roleId);
	}

	@Override
	public Userinfo findUserByUserName(String userName) {
		return userinfoMapper.findUserinfoByName(userName);
	}

	@Override
	public List<Auth> findAuthByUserId(long userId) {
		return authMapper.findAuthByUserId(userId);
	}

	@Override
	public void addOrUpdateAuthByRole(long roleId, String auths) {
		Role role = roleMapper.selectByPrimaryKey(roleId);
		if (role == null) {
			throw new ErrorException("角色不存在");
		}
		if (StringUtil.isNull(auths)) {
			return;
		}
		
		//先删除权限
		authMapper.delRoleAuthByRoleId(roleId);
		List<RoleAuth> list = new ArrayList<RoleAuth>();
		String[] arrayAuth = auths.split("\\,");
		for (int i = 0; i < arrayAuth.length; i++) {
			list.add(new RoleAuth((int)roleId,Integer.parseInt(arrayAuth[i])));
		}
		authMapper.insetRoleAuth(list);
	}
}
