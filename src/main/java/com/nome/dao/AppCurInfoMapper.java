package com.nome.dao;

import java.util.List;

import com.nome.dao.base.BaseDao;
import com.nome.po.AppCurInfo;

public interface AppCurInfoMapper extends BaseDao<AppCurInfo> {
	public List<AppCurInfo> queryAll();
}