package com.nome.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.nome.dao.CommentMapper;
import com.nome.dao.base.impl.BaseDaoImpl;
import com.nome.po.Comment;
import com.nome.util.NameSpaceUtil;


@Repository
public class CommentDaoImpl extends BaseDaoImpl<Comment> implements CommentMapper {

	
	//得到单个问题的所以回答
	@Override
	public List<Comment> queryListPram1(Object t) {
		getclass ();
		return  sqlSession.selectList(NameSpaceUtil.getNameSpace(clazz.getName())+".queryListPram1",t);		
	}

}
