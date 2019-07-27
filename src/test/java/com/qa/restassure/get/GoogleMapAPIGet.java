package com.qa.restassure.get;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;

public class GoogleMapAPIGet {
	
	
	@Test
	
	public void googleMap() {
		
		//Specify base URI
		RestAssured.baseURI = "http://maps.googleapis.com";
		
		//Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response Object
		
	//	Response response = httpRequest.request(Method.GET, "/maps/api/place/nearbysearch/xml?location=-33.8670522,151.195")
		
		
	}

}
