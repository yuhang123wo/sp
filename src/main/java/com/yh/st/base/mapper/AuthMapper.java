package com.yh.st.base.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.github.abel533.mapper.Mapper;
import com.yh.st.base.domain.Auth;

public interface AuthMapper extends Mapper<Auth> {

	@Select("select * from  auth  a WHERE EXISTS(select 1 from role_auth ra where EXISTS (select ur.role_id from user_role ur where ur.user_id=#{userId} and ur.role_id=ra.role_id) and ra.auth_id=a.id)")
	List<Auth> findAuthByUserId(@Param("userId") long userId);
	
	@Select("select auth_id from role_auth where role_id=#{roleId}")
	List<Long> listAuthByRoleId(@Param("roleId") long roleId);
}
