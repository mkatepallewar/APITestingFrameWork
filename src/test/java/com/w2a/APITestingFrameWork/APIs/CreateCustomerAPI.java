package com.w2a.APITestingFrameWork.APIs;

import static io.restassured.RestAssured.given;

import java.util.Hashtable;

import com.w2a.APITestingFrameWork.setUp.BaseTest;

import io.restassured.response.Response;

public class CreateCustomerAPI extends BaseTest{
	
	public static Response sendPostRequestToCreateCustomerAPIwithValidAuthKey(Hashtable<String, String> data) {
		Response response= given().auth().basic(config.getProperty("validSecreteKey"), "")
		.formParam("email", data.get("email")).formParam("description", data.get("description"))
		.post(config.getProperty("customerEndPoint"));
		
		return response;
	}
	
public static Response sendPostRequestToCreateCustomerAPIwithInValidAuthKey(Hashtable<String, String> data) {
	  Response response=given().auth().basic(config.getProperty("inValidSecreteKey"), "")
			  .formParam("email", data.get("email")).formParam("description", data.get("description"))
			  .post(config.getProperty("customerEndPoint"));
	  
	  return response;
	}
}
