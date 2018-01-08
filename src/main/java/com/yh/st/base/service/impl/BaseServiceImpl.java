package com.yh.st.base.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.util.Assert;

import com.github.abel533.entity.Example;
import com.github.abel533.mapper.Mapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yh.st.base.domain.Entity;
import com.yh.st.base.service.BaseService;
import com.yh.st.common.util.StringUtil;
import com.yh.st.common.util.poi.ReflectionHelper;

public abstract class BaseServiceImpl<T extends Entity> implements BaseService<T> {
	protected Class<T> clazz;

	public BaseServiceImpl() {
		clazz = ReflectionHelper.getClassGenricType(getClass());
	}

	/**
	 * dao 层实现类
	 */
	public abstract Mapper<T> getDao();

	@Override
	public void save(T t) {
		Assert.isTrue(StringUtil.objIsNull(t), "model为空");
		this.getDao().insert(t);
	}

	@Override
	public PageInfo<T> queryPageByParmas(Map<String, Object> map, int pageNo, int pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		Example example = new Example(clazz.getClass());
		List<T> list = this.getDao().selectByExample(example);
		return new PageInfo<T>(list);
	}
}
