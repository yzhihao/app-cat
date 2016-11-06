package com.nome.dao.base;

public interface BaseDao<T> {
	
	public int deleteByPrimaryKey(int id);

	public int insert(T t);
	
	public T selectByPrimaryKey(int id);
	
	public int updateByPrimaryKey(T t);
    
}
