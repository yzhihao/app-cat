package com.nome.Controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nome.po.User;
import com.nome.service.UserService;
import com.nome.util.JSONUTIL;

@Controller
public class UserController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping("user")
	@ResponseBody
	public String user() {
		User user = userService.queryOne(1);
		return JSONUTIL.toObject(user).toString();
	}
	
}
