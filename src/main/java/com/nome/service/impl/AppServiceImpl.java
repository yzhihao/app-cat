package com.nome.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@Override
	public List<App> queryByTag(int tag, int offset, int limit) {
		Map<String,Object> map = new HashMap<String,Object>();
		
		map.put("tag", tag);
		map.put("offset", offset);
		map.put("limit", limit);
		
		return appMapper.queryByTag(map);
		
	}

	@Override
	public List<App> findLike(String keyword,int offset,int limit) {
		Map<String,Object> map = new HashMap<String,Object>();
		
		map.put("keyword", keyword);
		map.put("offset", offset);
		map.put("limit", limit);
		
		
		return appMapper.findLike(map);
	}
	
	
	
}
