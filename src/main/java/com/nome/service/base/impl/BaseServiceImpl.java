package com.nome.service.base.impl;

import com.nome.dao.base.BaseDao;
import com.nome.service.base.BaseService;

/**
 * @author yzh
 *
 * @param <T>
 */
public class BaseServiceImpl<T> implements BaseService<T> {

	private BaseDao<T> baseDao;

	protected void setBaseDao(BaseDao<T> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public int delete(int id) {
		return baseDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(T t) {
		return baseDao.insert(t);
	}

	@Override
	public int update(T t) {
		return baseDao.updateByPrimaryKey(t);
	}

	@Override
	public T queryOne(int id) {
		return baseDao.selectByPrimaryKey(id);
	}

}
