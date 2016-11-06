package com.nome.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nome.dao.CommentMapper;
import com.nome.po.Comment;
import com.nome.service.CommentService;
import com.nome.service.base.impl.BaseServiceImpl;

@Service
public class CommentServiceImpl extends BaseServiceImpl<Comment> implements CommentService {

	@Resource
	private CommentMapper commentMapper;

	@Resource
	public void setCommentMapper(CommentMapper commentMapper) {
		super.setBaseDao(commentMapper);
	}
	
	
	
}
