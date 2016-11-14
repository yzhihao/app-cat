package com.nome.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nome.po.User;
import com.nome.service.UserService;
import com.nome.util.JSONUTIL;
import com.nome.util.MD5Util;
import com.nome.util.StringUtil;
import com.nome.vo.UserVo;
import com.nome.vo.result.Result;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private static final Logger logger = Logger.getLogger(UserController.class);
	
	@Resource
	private UserService userService;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
	/**
	 * 测试框架
	 * @return
	 */
	@RequestMapping("user")
	@ResponseBody
	public String user() {
		User user = userService.queryOne(1);
		return JSONUTIL.toObject(user).toString();
	}
	
	/**
	 * 注册用户 需要进行邮箱验证
	 * @param session
	 * @param userName			用户名
	 * @param password			密码
	 * @param email
	 * @return
	 */
	@RequestMapping("/register")
	@ResponseBody
	public Result register(HttpSession session,String userName,String password,String email) {
		Result result = new Result();
		if(!StringUtil.isUserName(userName)) {
			result.setResult(false);
			result.setInformation("用户名格式不正确 或 邮箱格式不正确");
		}
		else {
			boolean register = userService.register(userName, password, email);
			
			if(register) {
				result.setResult(true);
			} else {
				result.setResult(false);
				result.setInformation("用户已经注册了");
			}
		}
		
		return result;
	}
	
	/**
	 * 登录
	 * @param session
	 * @param userName			用户名	
	 * @param password			密码
	 * @return
	 */
	@RequestMapping("/login")
	@ResponseBody
	public Result login(HttpSession session,String userName,String password) {
		Result result = new Result();
		if(!StringUtil.isUserName(userName)) {
			result.setResult(false);
			result.setInformation("用户名格式不正确");
		}
		else {
			User user = null;
			user = userService.login(userName, password);
			
			if(user != null) {
				
				session.setAttribute("curUser", user);
				session.setAttribute("loginStatus", "success");
				result.setResult(true);
				result.setData(UserVo.changeToVo(user));
				logger.info("login: " + userName + " " + sdf.format(new Date()) );
			}
			else {
				result.setResult(false);
				result.setInformation("密码错误或未激活邮箱");
			}
		}
		
		return result;
	}
	
	
	/**
	 * 当用户接收到邮箱时，并点开相应的连接时，注册成功
	 * @param session
	 * @param email						接收邮箱的地址
	 * @param valivate					验证码
	 * @return
	 */
	@RequestMapping("/validateRegister")
	@ResponseBody
	public Result validateRegister(HttpSession session,String email,String validate) {
		Result result = new Result();
		result.setResult(userService.validate(email, validate));
		return result;
	}
	
	
	/**
	 * 用于已经知道密码要修改密码的用户进行密码验证
	 * @param session
	 * @param userName			用户名
	 * @param password			密码
	 * @return
	 */
	@RequestMapping("/validatePassword")
	@ResponseBody
	public Result validatePassword(HttpSession session,String userName,String password) {
		Result result = new Result();
		String validate = userService.validatePassword(userName, password);
		if(validate == null) result.setResult(false);
		else {
			result.setData(String.valueOf(validate));
			result.setResult(true);
		}
		return result;
	}
	
	/**
	 * 修改密码，需要验证码
	 * @param session
	 * @param userName			用户名
	 * @param newpassword	新的密码
	 * @param validate	验证码
	 * @param type	1代表知道之前的密码的用户进行密码的修改     2代表忘记密码的用户进行密码的修改
	 * @return
	 */
	@RequestMapping("/motifyPassword")
	@ResponseBody
	public Result motifyPassword(HttpSession session,String userName,String newpassword,String validate,int type) {
		Result result = new Result();
		if(userService.motifyPassword(userName, newpassword, validate,type) == 1) result.setResult(true);
		else result.setResult(false);
		return result;
	}
	
	/**
	 * 向忘记密码的用户发送邮箱验证码
	 * @param session
	 * @param email			邮箱地址
	 * @return
	 */
	@RequestMapping("/forgetPassword")
	@ResponseBody
	public Result forgetPassword(HttpSession session,String email) {
		Result result = new Result();
		
		String validate = userService.forgetPassword(email);
		if(validate == null) {
			result.setResult(false);
		} else {
			result.setData(validate);
			result.setResult(true);
		}
		return result;
	}
	
	
	/**
	 * 退出登录
	 * @param session
	 * @return
	 */
	@RequestMapping("/logout")
	@ResponseBody
	public Result logout(HttpSession session) {
		Result result = new Result();
		User user = (User)session.getAttribute("curUser");
		String userName =  user.getName();
		session.invalidate();
//		session.removeAttribute("curUser");
//		session.setAttribute("loginStatus", "unsuccess");
		result.setResult(true);
		logger.info("logout: " + userName + " " + sdf.format(new Date()));
		return result;
	}
	
	
	/**
	 * 增加用户的总订阅数
	 * @param session
	 * @param type		增加类型    0表示到15,1表示增加到20,
	 * @param userId	用户id
	 * @return
	 */
	@RequestMapping("/addSubscribeNum")
	@ResponseBody
	public Result addSubscribeNum(HttpSession session , int type, int userId) {
		Result result = new Result();
		boolean statement = userService.updateAllNum(userId, type);
		result.setResult(statement);
		return result;
	}
	
	
	/**
	 * 修改用户名			16-11-14
	 * @param session
	 * @param newUserName	新的用户名
	 * @param userId		用户的id
	 * @return
	 */
	@RequestMapping("/motifyUserName")
	@ResponseBody
	public Result motifyUserName(HttpSession session , String newUserName, int userId) {
		Result result = new Result();
		boolean statement = userService.motifyUserName(newUserName, userId);
		if(statement) {
			result.setResult(true);
		} else {
			result.setResult(false);
			result.setInformation("该用户名已被占用了");
		}
		
		return result;
	}
	
	
}
