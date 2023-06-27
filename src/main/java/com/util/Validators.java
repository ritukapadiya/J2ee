package com.util;

public class Validators {
	public static boolean isBlank(String content) {
		 return content == null || content.trim().length()==0;
	}
	
	public static boolean isAlpha(String content) {
		return content.matches("^[a-zA-Z]+$");
		
	}
	public static boolean isDigit(String content) {
		return content.matches("[0-9]+");
		
	}
	public static boolean isEmail(String content) {
		return content.matches("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}");
	}
}
