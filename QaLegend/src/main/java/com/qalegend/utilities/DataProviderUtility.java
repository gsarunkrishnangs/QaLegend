package com.qalegend.utilities;

import org.testng.annotations.DataProvider;

public class DataProviderUtility {

@DataProvider (name = "InvalidLoginUserCredentials")
	
	public Object[][] userCredentialsData() {
		
		Object[][] data = new Object[3][2];
		
		data[0][0] = "admi";
		data[0][1] = "123456";
		
		data[1][0] = "admin";
		data[1][1] = "12345";
		
		data[2][0] = "admi";
		data[2][1] = "arun@1234";
		
		return data;
}
}