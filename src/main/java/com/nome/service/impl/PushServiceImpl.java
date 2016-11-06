package com.nome.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nome.dao.PushMapper;
import com.nome.po.Push;
import com.nome.service.PushService;
import com.nome.service.base.impl.BaseServiceImpl;

@Service
public class PushServiceImpl extends BaseServiceImpl<Push> implements PushService {

	@Resource
	private PushMapper pushMapper;

	@Resource
	public void setPushMapper(PushMapper pushMapper) {
		this.pushMapper = pushMapper;
	}
	
	
	
}
