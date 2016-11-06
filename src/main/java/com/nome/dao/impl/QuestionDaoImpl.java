package com.nome.dao.impl;

import org.springframework.stereotype.Repository;

import com.nome.dao.QuestionMapper;
import com.nome.dao.base.impl.BaseDaoImpl;
import com.nome.po.Question;

@Repository
public class QuestionDaoImpl extends BaseDaoImpl<Question> implements QuestionMapper {

}
