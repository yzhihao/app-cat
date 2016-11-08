package com.nome.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {

	public static String toMD5(String password) {
		
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes());
			byte[] b = md.digest();
			StringBuffer buf = new StringBuffer("");
			int temp;
			for(int i=0;i<b.length;i++) {
				temp = b[i];
				temp = temp < 0 ? temp+256 : temp;
				if(temp <16) {
					buf.append("0");
				}
				buf.append(Integer.toString(temp, 16));
			}
			return buf.toString();
		} catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	
}
