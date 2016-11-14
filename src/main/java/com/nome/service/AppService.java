package com.nome.service;

import java.util.List;

import com.nome.po.App;
import com.nome.service.base.BaseService;
import com.nome.util.PageUtil;

public interface AppService extends BaseService<App> {
	
	public PageUtil queryByTag(int tag,PageUtil page);
	
	public PageUtil findLike(String keyword,PageUtil page);
	
}
