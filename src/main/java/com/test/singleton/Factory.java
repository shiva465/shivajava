package com.test.singleton;

public class Factory {

private Factory factory;
private String name;

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
private Factory() {
	System.out.println("entered into private factory con");
	
}
 public static Factory getInstance() {
	 return new Factory();
 }

}
