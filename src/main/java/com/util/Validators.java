package com.util;

public class Validators {

	public static boolean isBlank(String data) {
		if(data == null || data.trim().length() == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean isAlpha(String data) {
		//a-zA-Z 
		String alphaRegex = "[a-zA-Z]+";//1-Time n-Time 
		
		return data.matches(alphaRegex);// true false 
		
	}
	
}
