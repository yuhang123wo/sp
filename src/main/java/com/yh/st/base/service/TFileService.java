package com.yh.st.base.service;

import java.util.List;

import com.yh.st.base.domain.TFile;

public interface TFileService {

	void insertTFile(TFile tfile);

	List<TFile> listTFile();
}
