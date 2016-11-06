package com.nome.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nome.dao.UserDefinedAppMapper;
import com.nome.po.UserDefinedApp;
import com.nome.service.UserDefinedAppService;
import com.nome.service.base.impl.BaseServiceImpl;

@Service
public class UserDefinedAppServiceImpl extends BaseServiceImpl<UserDefinedApp> implements UserDefinedAppService {
	
	@Resource
	private UserDefinedAppMapper userDefinedAppMapper;

	@Resource
	public void setUserDefinedAppMapper(UserDefinedAppMapper userDefinedAppMapper) {
		super.setBaseDao(userDefinedAppMapper);
	}
	
	
	
}
