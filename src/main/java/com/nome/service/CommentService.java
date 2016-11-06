package com.nome.service;

import java.util.List;

import com.nome.po.Comment;
import com.nome.service.base.BaseService;

public interface CommentService extends BaseService<Comment> {
	
	public List<Comment> queryListPram1(Object t);
}
