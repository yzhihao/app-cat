package com.nome.dao;

import java.util.List;
import java.util.Map;

import com.nome.dao.base.BaseDao;
import com.nome.po.Subscribe;

public interface SubscribeMapper extends BaseDao<Subscribe> {
	
	public List<Subscribe> queryByUser(int userId);
	
	public List<Subscribe> queryByApp(int appId);
	
	public List<Subscribe> checkRepeat(Map<String,Object> map);
	
	public int changePrice(Map<String,Object> map);
	
	public int cancel(int id);

	public int recall(int id);
}