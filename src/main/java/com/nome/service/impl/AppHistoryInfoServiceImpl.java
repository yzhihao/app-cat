package com.nome.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nome.dao.AppHistoryInfoMapper;
import com.nome.po.AppHistoryInfo;
import com.nome.service.AppHistoryInfoService;
import com.nome.service.base.impl.BaseServiceImpl;

@Service
public class AppHistoryInfoServiceImpl extends BaseServiceImpl<AppHistoryInfo> implements AppHistoryInfoService {

	@Resource
	private AppHistoryInfoMapper appHistoryInfoMapper;

	@Resource
	public void setAppHistoryInfoMapper(AppHistoryInfoMapper appHistoryInfoMapper) {
		super.setBaseDao(appHistoryInfoMapper);
	}
	
	
	
}
