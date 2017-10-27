package com.yh.st.base.mapper;

import java.util.List;

import com.github.abel533.mapper.Mapper;
import com.yh.st.base.domain.Role;

public interface RoleMapper extends Mapper<Role> {

	
	List<Role> findAll();
}
