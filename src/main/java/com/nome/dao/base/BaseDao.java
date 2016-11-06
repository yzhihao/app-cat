package com.nome.dao.base;

import java.util.List;

public interface BaseDao<T> {
	
	public int deleteByPrimaryKey(int id);

	public int insert(T t);
	
	public T selectByPrimaryKey(int id);
	
	public int updateByPrimaryKey(T t);
    
	public List<T> queryList();
    
    public T  queryOne(Object t);

    public List<T> queryListPram(Object t);
}
