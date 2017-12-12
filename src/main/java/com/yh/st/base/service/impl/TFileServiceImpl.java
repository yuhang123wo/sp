package com.yh.st.base.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.abel533.entity.Example;
import com.yh.st.base.domain.TFile;
import com.yh.st.base.mapper.TFileMapper;
import com.yh.st.base.service.TFileService;

@Service
public class TFileServiceImpl implements TFileService {

	@Resource
	private TFileMapper tFileMapper;

	@Override
	public void insertTFile(TFile tfile) {
		tFileMapper.insert(tfile);
	}

	@Override
	public List<TFile> listTFile() {
		Example example = new Example(TFile.class);
		return tFileMapper.selectByExample(example);
	}

}
