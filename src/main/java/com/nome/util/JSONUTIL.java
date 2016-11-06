package com.nome.util;

import net.sf.json.JSONObject;

public class JSONUTIL {

	public static JSONObject toObject(Object object) {
		return JSONObject.fromObject(object);
	}
	
	
}
