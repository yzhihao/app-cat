package com.nome.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nome.dao.AppMapper;
import com.nome.po.App;
import com.nome.service.AppService;
import com.nome.service.base.impl.BaseServiceImpl;

@Service
public class AppServiceImpl extends BaseServiceImpl<App> implements AppService {

	@Resource
	private AppMapper appMapper;

	@Resource
	public void setAppMapper(AppMapper appMapper) {
		super.setBaseDao(appMapper);
	}
	
	
	
}
