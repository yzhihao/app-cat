package com.nome.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nome.dao.AnswerMapper;
import com.nome.po.Answer;
import com.nome.service.AnswerService;
import com.nome.service.base.impl.BaseServiceImpl;

@Service
public class AnswerServiceImpl extends BaseServiceImpl<Answer> implements AnswerService {

	@Resource
	private AnswerMapper answerMapper;

	@Resource
	public void setAnswerMapper(AnswerMapper answerMapper) {
		super.setBaseDao(answerMapper);
	}
	
	
	
}
