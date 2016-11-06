package com.nome.dao.impl;

import org.springframework.stereotype.Repository;

import com.nome.dao.AppMapper;
import com.nome.dao.base.impl.BaseDaoImpl;
import com.nome.po.App;

@Repository
public class AppDaoImpl extends BaseDaoImpl<App> implements AppMapper {

}
