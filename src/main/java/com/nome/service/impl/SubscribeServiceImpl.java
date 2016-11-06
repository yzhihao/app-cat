package com.nome.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nome.dao.SubscribeMapper;
import com.nome.po.Subscribe;
import com.nome.service.SubscribeService;
import com.nome.service.base.impl.BaseServiceImpl;

@Service
public class SubscribeServiceImpl extends BaseServiceImpl<Subscribe> implements SubscribeService {

	@Resource
	private SubscribeMapper subscribeMapper;

	@Resource
	public void setSubscribeMapper(SubscribeMapper subscribeMapper) {
		super.setBaseDao(subscribeMapper);
	}
	
	
	
}
