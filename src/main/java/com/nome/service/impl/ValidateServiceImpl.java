package com.nome.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nome.dao.ValidateMapper;
import com.nome.po.Validate;
import com.nome.service.ValidateService;
import com.nome.service.base.impl.BaseServiceImpl;
import com.nome.util.RandomNumber;

@Service
public class ValidateServiceImpl extends BaseServiceImpl<Validate> implements ValidateService {
	
	@Resource
	private ValidateMapper validateMapper;

	@Resource
	public void setValidateMapper(ValidateMapper validateMapper) {
		super.setBaseDao(validateMapper);
	}

	@Override
	public String addValidate(int userId,int type) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = sdf.format(new Date());
		Validate validate = new Validate();
		validate.setTime(time);
		validate.setType(type);
		validate.setUserId(userId);
		validate.setValidate(RandomNumber.createNumber());
		validateMapper.insert(validate);
		return validate.getValidate();
	}

	@Override
	public int deleteValidate(int id) {
		return validateMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<Validate> queryValidate(int userId, int type) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userId", userId);
		map.put("type", type);
		List<Validate> list = validateMapper.queryValidates(map);
		if(list == null) return null;
		
		return list;
	}
	
}
