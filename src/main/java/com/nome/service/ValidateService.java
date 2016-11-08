package com.nome.service;

import java.util.List;

import com.nome.po.Validate;
import com.nome.service.base.BaseService;

public interface ValidateService extends BaseService<Validate>{
	public String addValidate(int userId,int type);
	
	public int deleteValidate(int id);
	
	public List<Validate> queryValidate(int userId,int type);
}
