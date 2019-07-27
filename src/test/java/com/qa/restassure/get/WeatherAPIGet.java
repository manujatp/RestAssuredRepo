package com.qa.restassure.get;

import org.apache.http.Header;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class WeatherAPIGet {
	
	@Test
	public void getWeatherDetails() {
		
	//Specify baseURI
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
	
		//Request object
		RequestSpecification httpRequest	= RestAssured.given();
		
		//Response object
		Response response = httpRequest.request(Method.GET, "/Melbourne");
		
		//printing response
		String responseBody = response.getBody().asString();
		System.out.println("Response is : " +responseBody);
		
		//status code
		int statusCode = response.getStatusCode();
		System.out.println("Status code is : "+statusCode);
		Assert.assertEquals(statusCode, 200);

		//status line
		
		String statusLine = response.getStatusLine();
		System.out.println("Status Line is : "+statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
		//getting header from response

		Headers allHeader = response.headers();
		
		for(io.restassured.http.Header header : allHeader ) {
			System.out.println(header.getName()+"  "+header.getValue());
		}
		
		//header verification
		
		String contentType = response.header("Content-Type");
		System.out.println("Content Type is : "+contentType);
		Assert.assertEquals(contentType, "application/json");
		
		String contentEncoding = response.header("Content-Encoding");
		System.out.println("Content Encoding is : "+contentEncoding);
		Assert.assertEquals(contentEncoding, "gzip");
	}

}
