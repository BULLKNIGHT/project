package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import springfox.documentation.spring.web.json.Json;

@RestController
public class FoodController {

	@GetMapping("/")
	public String home()
	{
		return "home";
	}
	
	@GetMapping("/categories")
	public String getAllCategory() throws UnirestException
	{
		HttpResponse<String> response = Unirest.get("https://developers.zomato.com/api/v2.1/categories")
				.header("user-key", "<give here your provided userkey>")
				.asString();
		System.out.print(response.getBody());
		return(response.getBody());

	}
	
	@GetMapping("/cities/{city}")
	public String getCityDetails(@PathVariable("city") String city) throws UnirestException
	{
		HttpResponse<String> response = Unirest.get("https://developers.zomato.com/api/v2.1/cities?q="+city)
				.header("user-key", "<give here your provided userkey>")
				.asString();
		System.out.print(response.getBody());
		return(response.getBody());
	}
	
	@GetMapping("/collections/{city_id}")
	public String getCollectionsInCity(@PathVariable("city_id") int city_id) throws UnirestException
	{
		HttpResponse<String> response = Unirest.get("https://developers.zomato.com/api/v2.1/collections?city_id="+city_id)
				.header("user-key", "<give here your provided userkey>")
				.asString();
		System.out.print(response.getBody());
		return(response.getBody());
	}
	
	@GetMapping("/cuisines/{city_id}")
	public String getCuisinesInCity(@PathVariable("city_id") int city_id) throws UnirestException
	{
		HttpResponse<String> response = Unirest.get("https://developers.zomato.com/api/v2.1/cuisines?city_id="+city_id)
				.header("user-key", "<give here your provided userkey>")
				.asString();
		System.out.print(response.getBody());
		return(response.getBody());
	}
	
	@GetMapping("/establishments/{city_id}")
	public String getEstablishmentsInCity(@PathVariable("city_id") int city_id) throws UnirestException
	{
		HttpResponse<String> response = Unirest.get("https://developers.zomato.com/api/v2.1/establishments?city_id="+city_id)
				.header("user-key", "<give here your provided userkey>")
				.asString();
		System.out.print(response.getBody());
		return(response.getBody());
	}
	
	@GetMapping("/locations/{location}")
	public String getLocation(@PathVariable("location") String location) throws UnirestException
	{
		HttpResponse<String> response = Unirest.get("https://developers.zomato.com/api/v2.1/locations?query="+location)
				.header("user-key", "<give here your provided userkey>")
				.asString();
		System.out.print(response.getBody());
		return(response.getBody());
	}
	
	@GetMapping("/locations/{location_id}/{location_type}")
	public String getLocationDetails(@PathVariable("location_id") int location_id,@PathVariable("location_type") String location_type) throws UnirestException
	{
		HttpResponse<String> response = Unirest.get("https://developers.zomato.com/api/v2.1/location_details?entity_id="+location_id+"&entity_type="+location_type)
				.header("user-key", "<give here your provided userkey>")
				.asString();
		System.out.print(response.getBody());
		return(response.getBody());
	}
	
}
