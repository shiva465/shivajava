package com.test.singleton;

public class Test {
	public static void main(String[] args) {
		Single s1 = Single.getInstance();
		Single s2 = Single.getInstance();
		Single s3 = Single.getInstance();
		s1.setName("shiva");
		System.out.println(s1.getName());
		s2.setName("krishna");
		System.out.println(s2.getName());
		s3.setName("ramu");
		System.out.println(s3.getName());
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s1.getName() + "...." + s2.getName() + "...." + s3.getName());
	}

}
