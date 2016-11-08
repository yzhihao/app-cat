package com.nome.service;

import java.util.List;

import com.nome.po.AppHistoryInfo;
import com.nome.service.base.BaseService;

public interface AppHistoryInfoService extends BaseService<AppHistoryInfo> {
	public List<AppHistoryInfo> queryHistoryPriceByAppId(int appId);
}
