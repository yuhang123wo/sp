package com.yh.st.base.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.abel533.mapper.Mapper;
import com.yh.st.base.domain.SysDept;
import com.yh.st.base.mapper.SysDeptMapper;
import com.yh.st.base.service.SysDeptService;

@Service
public class SysDeptServiceImpl extends BaseServiceImpl<SysDept> implements SysDeptService {

	@Resource
	private SysDeptMapper sysDeptMapper;

	@Override
	public Mapper<SysDept> getDao() {
		return sysDeptMapper;
	}

}
