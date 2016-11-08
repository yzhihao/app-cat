package com.nome.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.nome.dao.AppHistoryInfoMapper;
import com.nome.dao.base.impl.BaseDaoImpl;
import com.nome.po.AppHistoryInfo;
import com.nome.util.NameSpaceUtil;

@Repository
public class AppHistoryInfoDaoImpl extends BaseDaoImpl<AppHistoryInfo> implements AppHistoryInfoMapper {

	@Override
	public List<AppHistoryInfo> queryByAppId(int appId) {
		getclass();
		return sqlSession.selectList(NameSpaceUtil.getNameSpace(clazz.getName()) + ".queryByAppId" , appId);
	}

}
