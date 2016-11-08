package com.nome.dao;

import java.util.List;
import java.util.Map;

import com.nome.dao.base.BaseDao;
import com.nome.po.Validate;

public interface ValidateMapper extends BaseDao<Validate> {
	public List<Validate> queryValidates(Map<String,Object> map);
}