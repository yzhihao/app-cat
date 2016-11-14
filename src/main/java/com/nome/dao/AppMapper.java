package com.nome.dao;

import java.util.List;
import java.util.Map;

import com.nome.dao.base.BaseDao;
import com.nome.po.App;

public interface AppMapper extends BaseDao<App> {
	public List<App> queryByTag(Map<String,Object> map);
	
	public List<App> findLike(Map<String,Object> map);
	
	public int countApps(int tag);
	
	public int countFindLike(String keyword);
	
	
}