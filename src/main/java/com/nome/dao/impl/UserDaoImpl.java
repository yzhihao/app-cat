package com.nome.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.nome.dao.UserMapper;
import com.nome.dao.base.impl.BaseDaoImpl;
import com.nome.po.User;
import com.nome.util.NameSpaceUtil;


@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserMapper {

	@Override
	public List<User> queryByName(String name) {
		getclass();
		return sqlSession.selectList(NameSpaceUtil.getNameSpace(clazz.getName()) + ".queryByName", name);
	}

	@Override
	public User queryByNameAndPassword(Map<String, Object> map) {
		getclass();
		System.out.println("name = "+map.get("name"));
		return sqlSession.selectOne(NameSpaceUtil.getNameSpace(clazz.getName()) + ".queryByNameAndPassword" ,map);
	}

	@Override
	public User queryNum(int id) {
		getclass ();
		return sqlSession.selectOne(NameSpaceUtil.getNameSpace(clazz.getName()) + ".queryNum", id);
	}

	@Override
	public User queryByEmail(String email) {
		getclass();
		return sqlSession.selectOne(NameSpaceUtil.getNameSpace(clazz.getName()) + ".queryByEmail", email);
	}

	@Override
	public int updatePassword(Map<String, Object> map) {
		getclass();
		return sqlSession.update(NameSpaceUtil.getNameSpace(clazz.getName()) + ".updatePassword" , map);
	}

	@Override
	public int updateCurNum(int userId) {
		getclass();
		return sqlSession.update(NameSpaceUtil.getNameSpace(clazz.getName()) + ".updateCurNum",userId);
	}

	@Override
	public int updateAllNum(Map<String, Object> map) {
		getclass();
		return sqlSession.update(NameSpaceUtil.getNameSpace(clazz.getName()) + ".updateAllNum" , map);
	}

	@Override
	public int passValidate(String email) {
		getclass();
		return sqlSession.update(NameSpaceUtil.getNameSpace(clazz.getName()) + ".passValidate" , email);
	}

	@Override
	public int desCurNum(int id) {
		getclass();
		return sqlSession.update(NameSpaceUtil.getNameSpace(clazz.getName()) + ".desCurNum" , id);
	}

	@Override
	public int motifyUserName(Map<String, Object> map) {
		getclass();
		return sqlSession.update(NameSpaceUtil.getNameSpace(clazz.getName()) + ".motifyUserName" , map);
	}

}
