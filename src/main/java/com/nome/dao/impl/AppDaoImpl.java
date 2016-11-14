package com.nome.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.nome.dao.AppMapper;
import com.nome.dao.base.impl.BaseDaoImpl;
import com.nome.po.App;
import com.nome.util.NameSpaceUtil;

@Repository
public class AppDaoImpl extends BaseDaoImpl<App> implements AppMapper {

	@Override
	public List<App> queryByTag(Map<String, Object> map) {
		getclass();
		return sqlSession.selectList(NameSpaceUtil.getNameSpace(clazz.getName()) + ".queryByTag" , map);
	}

	@Override
	public List<App> findLike(Map<String,Object> map) {
		getclass();
		return sqlSession.selectList(NameSpaceUtil.getNameSpace(clazz.getName()) + ".findLike" , map);
	}

	@Override
	public int countApps(int tag) {
		getclass();
		return sqlSession.selectOne(NameSpaceUtil.getNameSpace(clazz.getName()) + ".countApps" , tag);
	}

	@Override
	public int countFindLike(String keyword) {
		getclass();
		return sqlSession.selectOne(NameSpaceUtil.getNameSpace(clazz.getName()) + ".countFindLike" , keyword);
	}

}
