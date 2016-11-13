package com.nome.dao;

import java.util.List;
import java.util.Map;

import com.nome.dao.base.BaseDao;
import com.nome.po.User;

public interface UserMapper extends BaseDao<User> {
	
	public List<User> queryByName(String name);
	
	public User queryByNameAndPassword(Map<String,Object> map);
	
	public User queryNum(int id);
	
	public User queryByEmail(String email);
	
	public int updatePassword(Map<String,Object> map);
	
	public int updateCurNum(int id);
	
	public int updateAllNum(Map<String,Object> map);
	
	public int passValidate(String email);
	
	public int desCurNum(int id);
	
}