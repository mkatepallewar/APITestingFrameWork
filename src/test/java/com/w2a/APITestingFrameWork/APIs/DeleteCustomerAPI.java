package com.w2a.APITestingFrameWork.APIs;

import static io.restassured.RestAssured.given;

import java.util.Hashtable;

import com.w2a.APITestingFrameWork.setUp.BaseTest;

import io.restassured.response.Response;

public class DeleteCustomerAPI extends BaseTest{
	
	public static Response sendDeleteRequestToDeleteCustomerAPIwithValidID(Hashtable<String, String> data) {
		Response response= given().auth().basic(config.getProperty("validSecreteKey"), "")
				.delete(config.getProperty("customerEndPoint")+"/"+data.get("id"));		
		return response;
	}
	
	

}
