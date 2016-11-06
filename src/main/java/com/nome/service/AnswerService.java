package com.nome.service;

import java.util.List;

import com.nome.po.Answer;
import com.nome.service.base.BaseService;

public interface AnswerService extends BaseService<Answer> {

	public List<Answer> queryListPram1(int user_id);

}
