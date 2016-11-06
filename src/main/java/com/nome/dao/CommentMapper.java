package com.nome.dao;

import java.util.List;

import com.nome.dao.base.BaseDao;
import com.nome.po.Comment;

public interface CommentMapper extends BaseDao<Comment> {
	public List<Comment> queryListPram1(Object t);
}