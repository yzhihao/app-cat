package com.nome.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nome.dao.UserMapper;
import com.nome.po.User;
import com.nome.service.UserService;
import com.nome.service.base.impl.BaseServiceImpl;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
	
	@Resource
	private UserMapper userMapper;

	@Resource
	public void setUserMapper(UserMapper userMapper) {
		super.setBaseDao(userMapper);
	}
}
