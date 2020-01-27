package com.w2a.APITestingFrameWork.TestCases;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.w2a.APITestingFrameWork.APIs.CreateCustomerAPI;
import com.w2a.APITestingFrameWork.APIs.DeleteCustomerAPI;
import com.w2a.APITestingFrameWork.Utilities.DataUtil;
import com.w2a.APITestingFrameWork.Utilities.TestUtil;
import com.w2a.APITestingFrameWork.listeners.ExtentListeners;
import com.w2a.APITestingFrameWork.setUp.BaseTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.Hashtable;


public class DeleteCustomerTest extends BaseTest{
	
	
	@Test(dataProviderClass = DataUtil.class, dataProvider = "data")
	public void deleteCustomer(Hashtable<String, String> data) {
		
		Response response= DeleteCustomerAPI.sendDeleteRequestToDeleteCustomerAPIwithValidID(data);
		ExtentListeners.testReport.get().info(data.toString());
		response.prettyPrint();
		ExtentListeners.testReport.get().info(data.toString());
		
		System.out.println("Presence Check of ID Key : " + TestUtil.jsonHasKey(response.asString(), "id"));
		System.out.println("Presence Check of Object Key : " + TestUtil.jsonHasKey(response.asString(), "object"));
		System.out.println("Presence Check of Deleted Key : " + TestUtil.jsonHasKey(response.asString(), "deleted"));
		
		Assert.assertTrue(TestUtil.jsonHasKey(response.asString(), "id"),"ID key is not present in JSON Response");
		String actual_id=TestUtil.getJsonKeyValue(response.asString(), "id");
		String expected_id=data.get("id");
		
		Assert.assertEquals(actual_id, expected_id, "ID Not Matching");
		
		System.out.println("ID Key Value is : " + TestUtil.getJsonKeyValue(response.asString(), "id"));
		System.out.println("Object Key Value is : " + TestUtil.getJsonKeyValue(response.asString(), "object"));
		System.out.println("Deleted Key Value is : " + TestUtil.getJsonKeyValue(response.asString(), "deleted"));
	}
	
		
}
