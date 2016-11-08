package com.nome.util;

public class StringUtil {

	/**
	 * 判断字符串或数字是否为空
	 * @param str
	 * @return
	 */
	public static boolean isNull(String str)
	{
		if(str==null || "0".equals(str))
			return true;
		else
			return false;
	}
	
	 /**
	  * 注册时判断用户名是否合法
	  * @param str
	  * @return
	  */
	public static boolean isUserName(String str)
	{
		return str.matches("(^[\u4E00-\u9FA5]{2,8}$)|(^[A-Za-z0-9]{6,16}$)");
	}
	
	/**
	* 判断是不是都是整数
	* @param str  文本域数据
	* @return
	*/
	public static boolean isInteger(String str) 
	{    
		return (str.length()<=9 && str.matches("(\\d*)")) ? true : false;
	}
	 
	 /**
	  * 判断是不是邮箱
	  * @param str 文本数据（如果有）
	  * @return
	  */
	 public static boolean isEmail(String str)
	 {
		 return str.matches("^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$" );
	 }
	 
	 /**
		* 判断是不是appId
		* @param str  文本域数据
		* @return
		*/
		public static boolean isAppId(String str) 
		{    
			return (str.matches("(\\d*)")) ? true : false;
		}
	
}
