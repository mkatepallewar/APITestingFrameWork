package com.w2a.APITestingFrameWork.Utilities;

import org.json.JSONObject;
import org.testng.Assert;

import com.w2a.APITestingFrameWork.listeners.ExtentListeners;
import com.w2a.APITestingFrameWork.setUp.BaseTest;

public class TestUtil  {
	public static boolean jsonHasKey(String json, String key) {
		JSONObject jsonObject=new JSONObject(json);
		ExtentListeners.testReport.get().info("Validating the presence of key : " + key );
		return jsonObject.has(key);
		
	}
	
	public static String getJsonKeyValue(String json, String key) {
		JSONObject jsonObject=new JSONObject(json);
		ExtentListeners.testReport.get().info("Validating value of the key : " + key );
		return jsonObject.get(key).toString();
	}	
}
