package com.nome.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.nome.dao.PushMapper;
import com.nome.dao.base.impl.BaseDaoImpl;
import com.nome.po.Push;
import com.nome.util.NameSpaceUtil;

@Repository
public class PushDaoImpl extends BaseDaoImpl<Push> implements PushMapper {

	@Override
	public List<Push> queryPushApp() {
		getclass();
		return sqlSession.selectList(NameSpaceUtil.getNameSpace(clazz.getName()) + ".queryPushApp");
	}

	@Override
	public int deletePushs(List<Integer> list) {
		getclass();
		return sqlSession.delete(NameSpaceUtil.getNameSpace(clazz.getName()) + ".deletePushs",list);
	}

}
