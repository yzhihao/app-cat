package com.nome.service;

import java.util.List;

import com.nome.po.Push;
import com.nome.service.base.BaseService;

public interface PushService extends BaseService<Push> {
	
	public void push();
	public List<Push> queryPushApp();
}
