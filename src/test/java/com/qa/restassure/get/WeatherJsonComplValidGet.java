package com.qa.restassure.get;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class WeatherJsonComplValidGet {
	
	@Test
	public void getWeatherDetails() {
		
		//Specify base URI
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		
		//Request object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response Object
		Response response = httpRequest.request(Method.GET,"/Brisbane");
		
		//Response Body
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is : "+responseBody);
		
		JsonPath jsonPath = response.jsonPath();
		String city = jsonPath.get("City");
		String temperature = jsonPath.get("Temperature");
		String humidity = jsonPath.get("Humidity");
		String weatherDescription = jsonPath.get("WeatherDescription");
		
		Assert.assertEquals(city, "Brisbane");
		
	}

}
