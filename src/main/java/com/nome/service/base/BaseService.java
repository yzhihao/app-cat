package com.nome.service.base;

/**
 * @author yzh
 *
 * @param <T>
 */
public interface BaseService<T> {
		
		public  int delete(int id);
			
		public int  insert(T t);
		
	    public int update(T t);
	    
	    public T queryOne(int id);
	
}
