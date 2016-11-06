package com.nome.dao;

import java.util.List;

import com.nome.dao.base.BaseDao;
import com.nome.po.Answer;

public interface AnswerMapper extends BaseDao<Answer> {

	public List<Answer> queryListPram1(int question_id);
    
}