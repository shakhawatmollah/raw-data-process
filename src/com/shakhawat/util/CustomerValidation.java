package com.shakhawat.util;

public class CustomerValidation {

	public static boolean isEmailValid(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$";
		return email.matches(emailRegex);
	}
	
	public static boolean isPhoneNumberValid(String phoneNumber) {
		String phoneNumberRegex = "^(1\\s?)?(\\d{3}|\\(\\d{3}\\))[\\s\\-]?\\d{3}[\\s\\-]?\\d{4}$";
		return phoneNumber.matches(phoneNumberRegex);
	}
	
}
