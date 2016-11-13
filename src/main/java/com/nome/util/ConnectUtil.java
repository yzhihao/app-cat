package com.nome.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConnectUtil {

	//private String httpUrl = "https://itunes.apple.com/cn/app/ling-sheng-she-zhi-zhu-shou/id1101099907";
	
	/**
	 * @param urlAll
	 *            :请求接口
	 * @param httpArg
	 *            :参数
	 * @return 返回结果
	 */
	public static boolean request(String httpUrl) {
	    BufferedReader reader = null;
	    String result = null;
	    StringBuffer sbf = new StringBuffer();

	    try {
	        URL url = new URL(httpUrl);
	        HttpURLConnection connection = (HttpURLConnection) url
	                .openConnection();
	        connection.setRequestMethod("GET");
	        connection.connect();
	        InputStream is = connection.getInputStream();
	        reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
	        String strRead = null;
	        while ((strRead = reader.readLine()) != null) {
	            sbf.append(strRead);
	            sbf.append("\r\n");
	        }
	        reader.close();
	        result = sbf.toString();
	        
	        if(result.contains("正在连接到")) {
	        	return false;
	        }
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return true;
	}
	
	
	public static boolean judge(String url) {
		
	    try {  
	    	 URL url2 = new URL(url);  
	         InputStream in = url2.openStream();  
	         System.out.println("连接可用");  
	    } catch (Exception e1) {  
	         System.out.println("连接打不开!");  
	         return false;  
	    }  
		return true;
	}
	
	
}
