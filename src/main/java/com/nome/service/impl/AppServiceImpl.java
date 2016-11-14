package com.nome.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nome.dao.AppMapper;
import com.nome.po.App;
import com.nome.service.AppService;
import com.nome.service.base.impl.BaseServiceImpl;
import com.nome.util.PageUtil;

@Service
public class AppServiceImpl extends BaseServiceImpl<App> implements AppService {

	@Resource
	private AppMapper appMapper;

	@Resource
	public void setAppMapper(AppMapper appMapper) {
		super.setBaseDao(appMapper);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public PageUtil queryByTag(int tag, PageUtil page) {
		Map<String,Object> map = new HashMap<String,Object>();
		page.setRecordCount(appMapper.countApps(tag));
		map.put("tag", tag);
		map.put("page", page);
		page.setObjectLists(appMapper.queryByTag(map));
		return page;
		
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public PageUtil findLike(String keyword,PageUtil page) {
		Map<String,Object> map = new HashMap<String,Object>();
		page.setRecordCount(appMapper.countFindLike(keyword));
		map.put("keyword", keyword);
		map.put("page", page);
		page.setObjectLists(appMapper.findLike(map));
		return page;
	}
	
	
	
}
