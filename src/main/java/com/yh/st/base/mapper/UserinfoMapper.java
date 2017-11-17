package com.yh.st.base.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.github.abel533.mapper.Mapper;
import com.yh.st.base.domain.Userinfo;

public interface UserinfoMapper extends Mapper<Userinfo> {

	List<Userinfo> findUserinfoByParams(Map<String, Object> params);
	
	Userinfo findUserinfoByName(@Param("username") String username);
}
