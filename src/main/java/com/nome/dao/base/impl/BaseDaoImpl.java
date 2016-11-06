package com.nome.dao.base.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;

import com.nome.dao.base.BaseDao;
import com.nome.util.NameSpaceUtil;

/**
 * @author yzh
 *
 * @param <T>
 */
public class BaseDaoImpl<T> implements BaseDao<T> {
		
	@Resource
	protected SqlSessionTemplate sqlSession;

	private Class<T> clazz;
	   
	@SuppressWarnings("unchecked")
	public void getclass () {
		ParameterizedType pt =(ParameterizedType) this.getClass().getGenericSuperclass();
		this.clazz = (Class<T>) pt.getActualTypeArguments()[0];
		/*	判断类字段是不是空
			打印所有的class字段
		Type[] types = pt.getActualTypeArguments();
	 	System.out.println(types == null);
		for(Type type : types) {
			System.out.println("sys"+(Class<T>)type);
		}*/
	}
	
	@Override
	public int insert(T t) {
		getclass ();
		return  sqlSession.insert(NameSpaceUtil.getNameSpace(clazz.getName())+".insert",t);
	}

	@Override
	public int deleteByPrimaryKey(int id) {
		getclass ();
		return  sqlSession.delete(NameSpaceUtil.getNameSpace(clazz.getName())+".deleteByPrimaryKey",id);
	}

	@Override
	public T selectByPrimaryKey(int id) {
		getclass ();
		return sqlSession.selectOne(NameSpaceUtil.getNameSpace(clazz.getName())+".selectByPrimaryKey", id);
	}

	@Override
	public int updateByPrimaryKey(T t) {
		getclass ();
		return  sqlSession.update(NameSpaceUtil.getNameSpace(clazz.getName())+".updateByPrimaryKey",t);
	}
}
