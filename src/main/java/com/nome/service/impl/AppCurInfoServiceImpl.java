package com.nome.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nome.dao.AppCurInfoMapper;
import com.nome.po.AppCurInfo;
import com.nome.service.AppCurInfoService;
import com.nome.service.base.impl.BaseServiceImpl;

@Service
public class AppCurInfoServiceImpl extends BaseServiceImpl<AppCurInfo> implements AppCurInfoService {

	@Resource
	private AppCurInfoMapper appCurInfoMapper;

	@Resource
	public void setAppCurInfoMapper(AppCurInfoMapper appCurInfoMapper) {
		super.setBaseDao(appCurInfoMapper);
	}

	@Override
	public List<AppCurInfo> queryCurAllApps() {
		return appCurInfoMapper.queryAll();
	}
	
	
	
}
