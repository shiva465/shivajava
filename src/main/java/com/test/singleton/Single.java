package com.test.singleton;

public class Single {
	private static Single singleobj;
	private String name;

	private Single() {
		System.out.println("entered into private single constructor");
	}

	public static Single getInstance() {
		if (singleobj == null) {
			singleobj = new Single();
			return singleobj;
		}
		return singleobj;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
