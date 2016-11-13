package com.nome.dao;

import java.util.List;

import com.nome.dao.base.BaseDao;
import com.nome.po.Push;

public interface PushMapper extends BaseDao<Push> {
	public List<Push> queryPushApp();
	
	public int deletePushs(List<Integer> list);
}