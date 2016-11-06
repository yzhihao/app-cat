package com.nome.dao.impl;

import org.springframework.stereotype.Repository;

import com.nome.dao.CommentMapper;
import com.nome.dao.base.impl.BaseDaoImpl;
import com.nome.po.Comment;

@Repository
public class CommentDaoImpl extends BaseDaoImpl<Comment> implements CommentMapper {

}
