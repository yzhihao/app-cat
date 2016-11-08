package com.nome.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.nome.dao.SubscribeMapper;
import com.nome.dao.base.impl.BaseDaoImpl;
import com.nome.po.Subscribe;
import com.nome.util.NameSpaceUtil;

@Repository
public class SubscribeDaoImpl extends BaseDaoImpl<Subscribe> implements SubscribeMapper {

	@Override
	public List<Subscribe> queryByUser(int userId) {
		getclass ();
		return sqlSession.selectList(NameSpaceUtil.getNameSpace(clazz.getName()) + ".queryByUser", userId);
	}

	@Override
	public List<Subscribe> queryByApp(int appId) {
		getclass ();
		return sqlSession.selectList(NameSpaceUtil.getNameSpace(clazz.getName()) + ".queryByApp", appId);
	}

	@Override
	public List<Subscribe> checkRepeat(Map<String, Object> map) {
		getclass ();
		return sqlSession.selectList(NameSpaceUtil.getNameSpace(clazz.getName()) + ".checkRepeat", map);
	}

	@Override
	public int changePrice(Map<String,Object> map) {
		getclass ();
		return sqlSession.update(NameSpaceUtil.getNameSpace(clazz.getName()) + ".changePrice", map);
	}

	@Override
	public int cancel(int id) {
		getclass ();
		return sqlSession.update(NameSpaceUtil.getNameSpace(clazz.getName()) + ".cancel", id);
	}

	@Override
	public int recall(int id) {
		getclass ();
		return sqlSession.update(NameSpaceUtil.getNameSpace(clazz.getName()) + ".recall", id);
	}
	
}
