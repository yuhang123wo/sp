package com.yh.st.base.service;

import java.util.Map;

import com.github.abel533.mapper.Mapper;
import com.github.pagehelper.PageInfo;
import com.yh.st.base.domain.Entity;

public interface BaseService<T extends Entity> {

	/**
	 * 保存业务对象
	 * 
	 * @param model
	 * @throws Exception
	 */
	void save(T model);

	/**
	 * 分页查询
	 * 
	 * @param map
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	PageInfo<T> queryPageByParmas(Map<String, Object> map, int pageNo, int pageSize);

}
