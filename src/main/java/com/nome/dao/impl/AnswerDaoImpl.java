package com.nome.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.nome.dao.AnswerMapper;
import com.nome.dao.base.impl.BaseDaoImpl;
import com.nome.po.Answer;
import com.nome.util.NameSpaceUtil;

@Repository
public class AnswerDaoImpl extends BaseDaoImpl<Answer> implements AnswerMapper {

	//得到单个问题的所有回答
	@Override
	public List<Answer> queryListPram1(int question_id) {
		 getclass ();
		 return  sqlSession.selectList(NameSpaceUtil.getNameSpace(clazz.getName())+".queryListPram1",question_id);
	}

}
