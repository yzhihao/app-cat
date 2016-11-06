package com.nome.dao.impl;

import org.springframework.stereotype.Repository;

import com.nome.dao.UserMapper;
import com.nome.dao.base.impl.BaseDaoImpl;
import com.nome.po.User;


@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserMapper {

}
