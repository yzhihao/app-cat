package com.nome.service;

import java.util.List;
import java.util.Map;

import com.nome.po.App;
import com.nome.service.base.BaseService;

public interface AppService extends BaseService<App> {
	
	public List<App> queryByTag(int tag,int offset,int limit);
	
	public List<App> findLike(String keyword,int offset,int limit);
	
}
