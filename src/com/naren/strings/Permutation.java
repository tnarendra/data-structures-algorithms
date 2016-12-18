package com.naren.strings;

public class Permutation {

	public static void main(String[] args) {
		compress("aaaabbbbcd");

	}

	private static void compress(String str) {
		int count = 0;
		
		for(int i = 0; i< str.length(); i++){
			count++;
			if(str.charAt(i) == str.charAt(i+1)){
				
			} else{
				
				//str.charAt(i) = null;
				//str.substring(i - (count -1), i);
			}
			
		}
	}
}
