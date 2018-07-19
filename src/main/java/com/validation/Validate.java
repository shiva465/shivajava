package com.validation;

public class Validate {

	public boolean nullCheck(String text) {
		System.out.println("entered into nullCheck::Validate");
		if(text==null) {
			return true;
		}
		System.out.println("exiting from nullCheck::Validate");
		return false;
	}
}
