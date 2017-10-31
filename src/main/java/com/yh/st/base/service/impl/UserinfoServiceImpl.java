package com.yh.st.base.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.abel533.entity.Example;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yh.st.base.domain.Auth;
import com.yh.st.base.domain.Role;
import com.yh.st.base.domain.Userinfo;
import com.yh.st.base.mapper.AuthMapper;
import com.yh.st.base.mapper.RoleMapper;
import com.yh.st.base.mapper.UserinfoMapper;
import com.yh.st.base.service.UserinfoService;
import com.yh.st.base.vo.MenuVo;
import com.yh.st.common.util.MenuTool;

@Service("userinfoService")
public class UserinfoServiceImpl implements UserinfoService {

	@Resource
	private UserinfoMapper userinfoMapper;
	@Resource
	private RoleMapper roleMapper;
	@Resource
	private AuthMapper authMapper;

	@Override
	public PageInfo<Userinfo> queryUserinfo(int pageNo, int pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		Example example = new Example(Userinfo.class);
		example.createCriteria().andEqualTo("sex", 1);
		List<Userinfo> list = userinfoMapper.selectByExample(example);
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
		return MenuTool.getMenu(authMapper.findAuthByUserId(userId));
	}
}
