package com.qa.restassure.get;

import org.apache.http.HttpRequest;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class AuthorisationGet {

	@Test
	public void authorization() {

		//Specify base URI

		RestAssured.baseURI = "http://restapi.demoqa.com/authentication/CheckForAuthentication";

		//Basic Authentication
		PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
		authScheme.setUserName("ToolsQA");
		authScheme.setPassword("TestPassword");
		
		RestAssured.authentication = authScheme;
		//Request Object
		RequestSpecification httpRequest = RestAssured.given();

		//Response object
		Response response = httpRequest.request(Method.GET, "/");

		//Response body
		String responseBody = response.getBody().asString();
		System.out.println("Response body is : "+responseBody);

		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);


	}

}
