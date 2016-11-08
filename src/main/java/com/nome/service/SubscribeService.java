package com.nome.service;

import java.util.List;
import java.util.Map;

import com.nome.po.Subscribe;
import com.nome.service.base.BaseService;

public interface SubscribeService extends BaseService<Subscribe> {
	
	public List<Subscribe> queryByUser(int userId);
	
	public List<Subscribe> queryByApp(int appId);
		
	public int changePrice(int id,String price);
	
	public boolean cancel(int id,int userId);
	
	public int addSubscribe(int userId,String url,String price);
}
