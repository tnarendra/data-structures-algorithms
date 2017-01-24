package com.naren.practice.dp;

public class PrototypeClass {
	
	private PrototypeClass(){}
	
	public static PrototypeClass getInstance() {
		return new PrototypeClass();
	}
	
	public static void main(String...strings){
		
		System.out.println(getInstance() != getInstance());
	}
}
