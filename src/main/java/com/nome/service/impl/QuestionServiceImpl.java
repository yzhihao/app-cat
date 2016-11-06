package com.nome.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nome.dao.QuestionMapper;
import com.nome.po.Question;
import com.nome.service.QuestionService;
import com.nome.service.base.impl.BaseServiceImpl;

@Service
public class QuestionServiceImpl extends BaseServiceImpl<Question> implements QuestionService {

	@Resource
	private QuestionMapper questionMapper;

	@Resource
	public void setQuestionMapper(QuestionMapper questionMapper) {
		super.setBaseDao(questionMapper);
	}
	
	
	
}
