package com.nome.util;

public class NameSpaceUtil {
	
	private static final String FIRSTNAME = "com.nome.dao.";
	
	public static String getNameSpace(String name) {
		return FIRSTNAME + name.substring(name.lastIndexOf(".") + 1) + "Mapper";
	}
	
}
