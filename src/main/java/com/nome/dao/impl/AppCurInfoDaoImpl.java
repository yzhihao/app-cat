package com.nome.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.nome.dao.AppCurInfoMapper;
import com.nome.dao.base.impl.BaseDaoImpl;
import com.nome.po.AppCurInfo;
import com.nome.util.NameSpaceUtil;

@Repository
public class AppCurInfoDaoImpl extends BaseDaoImpl<AppCurInfo> implements AppCurInfoMapper {

	@Override
	public List<AppCurInfo> queryAll(Map<String,Object> map) {
		getclass();
		return sqlSession.selectList(NameSpaceUtil.getNameSpace(clazz.getName()) + ".queryAll",map);
	}

	@Override
	public int count() {
		getclass();
		return sqlSession.selectOne(NameSpaceUtil.getNameSpace(clazz.getName()) + ".count");
	}

}
