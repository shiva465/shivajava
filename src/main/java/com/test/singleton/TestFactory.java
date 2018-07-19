package com.test.singleton;

public class TestFactory {

	public static void main(String[] args) {
		Factory f1= Factory.getInstance();
		Factory f2= Factory.getInstance();
		Factory f3= Factory.getInstance();
		f1.setName("ramu");
		f2.setName("raju");
		f3.setName("rakesh");
		System.out.println(f1);
		System.out.println(f2);
		System.out.println(f3);
		System.out.println(f1.getName()+f2.getName()+f3.getName());
		
		
	}
}
