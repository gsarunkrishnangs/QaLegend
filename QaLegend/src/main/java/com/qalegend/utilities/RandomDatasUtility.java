package com.qalegend.utilities;

import com.github.javafaker.Faker;

public class RandomDatasUtility {
	
static Faker faker;
	
	public static String getFirstName() {
		
		faker = new Faker();
		String firstname = faker.name().firstName();
		return firstname;
	}
	
public static String getLastName() {
		
		faker = new Faker();
		String lastname = faker.name().lastName();
		return lastname;
	}

}
