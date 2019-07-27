package com.qa.restassure.post;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CustomerAPIPost {
	
	
	@Test
	public void RegisterCustomer() {
		
		//Specify base URI
		
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		
		//Request Object
		RequestSpecification httpRequest = RestAssured.given();	
		
		//Request payload
		JSONObject jsonRequest = new JSONObject();
		
		jsonRequest.put("FirstName", "AnanduR");
		jsonRequest.put("LastName", "RajeshR");
		jsonRequest.put("UserName", "ananduR");
		jsonRequest.put("Password", "rajR");
		jsonRequest.put("Email", "anandumailR.com");
		
		//header content type
		httpRequest.header("Content-Type", "application/json");
		
		httpRequest.body( jsonRequest.toString());
		
		//Response Object
		Response response = httpRequest.request(Method.POST, "/register");
		
		//print response in console
		String responseBody = response.getBody().asString();
		System.out.println("Response body is : "+responseBody);
		
		//Status code
		int statusCode = response.getStatusCode();
		System.out.println("Stauts Code is : "+statusCode);
		Assert.assertEquals(statusCode, 201);
		
		//Success Code
		String successCode = response.jsonPath().get("SuccessCode");
		System.out.println("Success Code is : "+successCode);
		Assert.assertEquals(successCode, "OPERATION_SUCCESS");
		
		
		
		
	}

}
