package com.nome.util;

public class ErrorUtil {

	public static String nullParameter(String... args) {
		String information = null;
		for (String temp : args) {
			System.out.println(temp);
			if (temp.equals("")) {
				information = "含有空参数";
				return information;
			}
		}
		return "";
	}
	public static String dbError(int a) {
		String information = null;
			if (a!=1) {
				information = "数据库操作报告，影响数据库行数："+a;
				return information;
		}
		return "";
	}
}
