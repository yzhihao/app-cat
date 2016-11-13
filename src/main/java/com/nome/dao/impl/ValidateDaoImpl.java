package com.nome.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.nome.dao.ValidateMapper;
import com.nome.dao.base.impl.BaseDaoImpl;
import com.nome.po.Validate;
import com.nome.util.NameSpaceUtil;


@Repository
public class ValidateDaoImpl extends BaseDaoImpl<Validate> implements ValidateMapper {

	@Override
	public List<Validate> queryValidates(Map<String, Object> map) {
		getclass();
		return sqlSession.selectList(NameSpaceUtil.getNameSpace(clazz.getName()) + ".queryValidates" , map);
	}
	
}
