package com.w2a.APITestingFrameWork.TestCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.w2a.APITestingFrameWork.APIs.CreateCustomerAPI;
import com.w2a.APITestingFrameWork.Utilities.DataUtil;
import com.w2a.APITestingFrameWork.listeners.ExtentListeners;
import com.w2a.APITestingFrameWork.setUp.BaseTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.Hashtable;


public class CreateCustomerTest extends BaseTest{
	
	
	@Test(dataProviderClass = DataUtil.class, dataProvider = "data")
	//validateCreateCustValidKey
	public void validateCreateCustomerAPIWithValidSecretKey(Hashtable<String, String> data) {
		
		Response response= CreateCustomerAPI.sendPostRequestToCreateCustomerAPIwithValidAuthKey(data);
		ExtentListeners.testReport.get().info(data.toString());
		response.prettyPrint();
		System.out.println(response.statusCode());
	}
	
	
	
//	  @Test(dataProviderClass = DataUtil.class, dataProvider = "data")
//	  //validateCreateCustInvalidKey 
//	  public void validateCreateCustomerAPIWithInValidSecretKey(Hashtable<String , String> data) {
//	  
//	  Response response=CreateCustomerAPI.sendPostRequestToCreateCustomerAPIwithInValidAuthKey(data);
//	  ExtentListeners.testReport.get().info(data.toString());
//	  response.prettyPrint();
//	  System.out.println(response.statusCode());
//	  
//	  Assert.assertEquals(response.getStatusCode(), 200);
//	  }
//	 
	 
	
	
}
