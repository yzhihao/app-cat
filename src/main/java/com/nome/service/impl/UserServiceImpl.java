package com.nome.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nome.dao.UserMapper;
import com.nome.po.User;
import com.nome.po.Validate;
import com.nome.service.UserService;
import com.nome.service.ValidateService;
import com.nome.service.base.impl.BaseServiceImpl;
import com.nome.util.MD5Util;
import com.nome.util.SendEmail;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
	
	@Resource
	private UserMapper userMapper;
	
	@Resource
	private ValidateService validateService;

	@Resource
	public void setUserMapper(UserMapper userMapper) {
		super.setBaseDao(userMapper);
	}

	@Override
	public boolean register(String name, String password, String email) {
		
		String MD5Password = MD5Util.toMD5(password);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("name", name);
		map.put("password", MD5Password);
		User temp = userMapper.queryByNameAndPassword(map);
		
		if(temp != null) return false;
		
		User user = new User();
		user.setAllSub(10);
		user.setCurSub(0);
		user.setEmail(email);
		user.setPassword(MD5Password);
		user.setStatus(0);
		user.setName(name);
		
		if(userMapper.insert(user) == 1) {
			String content = "为了激活你的账户，请点击以下链接：";
			
			try {
				SendEmail.send(email, content, MD5Password, name);
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("邮件发送失败");
			}
		}
		return true;
	}

	@Override
	public User login(String name, String password) {
		String MD5Password = MD5Util.toMD5(password);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("name", name);
		map.put("password", MD5Password);
		
		User user = userMapper.queryByNameAndPassword(map);
		if(user != null) return user;
		else return null;
	}

	@Override
	public boolean validate(String email, String password) {

		User user = userMapper.queryByEmail(email);
		
		if(user == null) return false;
		
		if(password.equals(user.getPassword())) {
			userMapper.passValidate(email);
		}
		
		return true;
	}

	@Override
	public String validatePassword(String name, String password) {
		String MD5Password = MD5Util.toMD5(password);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("name", name);
		map.put("password", MD5Password);
		User user = userMapper.queryByNameAndPassword(map);
		if(user == null) return null;
		String validate = validateService.addValidate(user.getId(), 1);  //对于验证密码的类型是1
		return validate;
	}

	@Transactional
	@Override
	public int motifyPassword(String name, String newpassword, String validate,int type) {
		//先验证验证码的准确性
		String MD5Password = MD5Util.toMD5(newpassword);
		Map<String,Object> map = new HashMap<String,Object>();
		List<User> userList = userMapper.queryByName(name);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date = new Date();
		if(userList.isEmpty()) return 0;
		User user = userList.get(0);
		map.put("id", user.getId());
		map.put("password", MD5Password);
		List<Validate> tempList = validateService.queryValidate(user.getId(), type);
		if(!tempList.isEmpty()) {
			Calendar calendar = Calendar.getInstance();
			try {
				calendar.setTime(sdf.parse(tempList.get(0).getTime()));
				calendar.add(calendar.DATE, 2);
				if(date.before(calendar.getTime()) && validate.equals(tempList.get(0).getValidate())) {				
					userMapper.updatePassword(map);
				} else return 0;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return 0;
			}
			for(int i=0;i<tempList.size();i++) {				
				validateService.deleteValidate(tempList.get(i).getId());
			}
			return 1;
		} 
		return 0;
	}

	@Override
	public boolean updateAllNum(int id, int add) {
		if(add > 0) {
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("id", id);
			map.put("add", add);
			if(userMapper.updateAllNum(map) == 1) return true;
			else return false;
		} else return false;
	}

	@Override
	public String forgetPassword(String email) {
		User user = userMapper.queryByEmail(email);
		if(user == null ) return null;
		String validate = validateService.addValidate(user.getId(), 2);  //对于忘记密码的类型是2
		SendEmail.sendFindPassword(email, validate);
		return validate;
	}
	
	
	
}
