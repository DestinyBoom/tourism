package com.xawl.tourism.utils;

import net.sf.json.JSONObject;

public class JsonUtil {
	private static JSONObject object;
	
	public static JSONObject createJson(int status) {
		object = new JSONObject();
		object.element("status", status);
		return object;
	}
}
