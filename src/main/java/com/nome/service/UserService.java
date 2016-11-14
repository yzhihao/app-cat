package com.nome.service;

import com.nome.po.User;
import com.nome.service.base.BaseService;

public interface UserService extends BaseService<User> {
	public boolean register(String name , String password , String email);
	
	public boolean updateAllNum(int id , int type);
	
	public User login(String name ,String password);
	
	public boolean validate(String email,String password);
	
	public String validatePassword(String name,String password);
	
	public int motifyPassword(String name,String newpassword,String validate,int type);
	
	public String forgetPassword(String email);
	
	public boolean motifyUserName(String newUserName , int userId);
}
