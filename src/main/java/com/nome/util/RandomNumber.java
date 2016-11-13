package com.nome.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class RandomNumber {
	public static String createNumber() {
  
        Random random = new Random();  
  
        int rannum = (int) (random.nextDouble() * (99999 - 10000 + 1)) + 10000;// 获取5位随机数  
        
        return String.valueOf(rannum);
	}
}
