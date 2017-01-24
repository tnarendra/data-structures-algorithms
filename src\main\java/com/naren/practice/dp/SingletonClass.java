package com.naren.practice.dp;

public class SingletonClass {
	
	private static SingletonClass singletonClass = new SingletonClass();
	private SingletonClass(){}
	
	public static SingletonClass getInstance() {
		return singletonClass;
	}
	
	public static void main(String...strings){
		
		System.out.println(getInstance() == getInstance());
	}
}
