package com.qa.restassure.get;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class WeatherJsonValidatingAPIGet {
	
	@Test
	public void getWeatherDetails() {
		
		//Specify Base URI
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		
		//Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response Object
		Response response = httpRequest.request(Method.GET, "/Sydney");
		
		String responseBody = response.getBody().asString();
		System.out.println("Response body is : "+responseBody);
		
		//verifying values present in response body 
		
		Assert.assertEquals(responseBody.contains("Sydney"), true);
		
	}

}
