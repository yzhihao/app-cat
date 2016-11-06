package com.nome.service.base;

import java.util.List;

/**
 * @author yzh
 *
 * @param <T>
 */
public interface BaseService<T> {
		
		public  int delete(int id);
			
		public int  insert(T t);
		
	    public int update(T t);
	    
	    public T queryOneById(int id);
	    
	    public List<T> queryListPram(Object t);
	    
	    public List<T> queryList();
	    
	    public T  queryOne(Object t);
	
}
