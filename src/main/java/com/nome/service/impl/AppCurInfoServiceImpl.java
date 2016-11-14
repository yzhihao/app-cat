package com.nome.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nome.dao.AppCurInfoMapper;
import com.nome.po.AppCurInfo;
import com.nome.service.AppCurInfoService;
import com.nome.service.base.impl.BaseServiceImpl;
import com.nome.util.PageUtil;

@Service
public class AppCurInfoServiceImpl extends BaseServiceImpl<AppCurInfo> implements AppCurInfoService {

	@Resource
	private AppCurInfoMapper appCurInfoMapper;

	@Resource
	public void setAppCurInfoMapper(AppCurInfoMapper appCurInfoMapper) {
		super.setBaseDao(appCurInfoMapper);
	}

	@Override
	public PageUtil queryCurAllApps(PageUtil page) {
		
		Map<String,Object> map = new HashMap<String,Object>();
		page.setRecordCount(appCurInfoMapper.count());
		map.put("page", page);
		page.setObjectLists(appCurInfoMapper.queryAll(map));
		return page;
	}
	
	
	
}
