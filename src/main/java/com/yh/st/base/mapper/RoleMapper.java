package com.yh.st.base.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.github.abel533.mapper.Mapper;
import com.yh.st.base.domain.Role;

public interface RoleMapper extends Mapper<Role> {

  @Select("select r.id,r.name from role r where exists(select id from user_role ur where r.id=ur.role_id and ur.user_id=#{userId})")
  List<Role> listRoleByUserId(long userId);
}
