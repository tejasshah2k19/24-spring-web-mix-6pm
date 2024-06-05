package com.util;

public class RegExDemo {

	public static void main(String[] args) {
		String alphaRegEx = "[A-Za-z]+";
		
		
		String name ="ram1";
		
		//matches 
		
		System.out.println(name.matches(alphaRegEx));
		
		
		
	}
	
}
