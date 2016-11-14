package com.nome.service;

import com.nome.po.AppCurInfo;
import com.nome.service.base.BaseService;
import com.nome.util.PageUtil;

public interface AppCurInfoService extends BaseService<AppCurInfo> {
	public PageUtil queryCurAllApps(PageUtil page);
}
