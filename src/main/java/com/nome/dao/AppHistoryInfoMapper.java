package com.nome.dao;

import java.util.List;

import com.nome.dao.base.BaseDao;
import com.nome.po.AppHistoryInfo;

public interface AppHistoryInfoMapper extends BaseDao<AppHistoryInfo> {
	public List<AppHistoryInfo> queryByAppId(int appId);
}