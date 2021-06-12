package com.restproject;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SimpleTest {
	
	@BeforeTest
	public void beforeInitialize(){
		System.out.println("Before Test");
	}
	

	@Test
        public void queryParameter() {
			
		RestAssured.baseURI ="https://samples.openweathermap.org/data/2.5/"; 
		RequestSpecification request = RestAssured.given();
		
		Response response = request.queryParam("q", "London,UK") 
				                   .queryParam("appid", "2b1fd2d7f77ccf1b7de9b441571b39b8") 
				                   .get("/weather");
		
		String jsonString = response.asString();
		System.out.println(jsonString);
		System.out.println(response.getStatusCode()); 
		Assert.assertEquals(jsonString.contains("London"), true);
		Headers allHeaders = response.headers();
		 
		 // Iterate over all the Headers
		 for(Header header : allHeaders)
		 {
		 System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
		 }
		System.out.println();
		String contentType = response.header("Content-Type");
		System.out.println("Content-Type="+contentType); 
		String server = response.header("Server");
		System.out.println("Server="+server);
		
		
	}
}
