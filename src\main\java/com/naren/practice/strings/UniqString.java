package com.naren.practice.strings;

public class UniqString {

	private static boolean isUniqChars(String word) {
		boolean b[] = new boolean[128];
		if(word.length() > 128)
			return false;
		
		for(int i = 0; i < word.length(); i++){
			if(b[word.charAt(i)]) 
				return false;
			else
				b[word.charAt(i)] = true;
		}
		
		return true;
	}
	
	
	public static void main(String[] args) {
		String[] words = {"google", "amazon", "mango", "abcd", "orange"};
		
		for(String word: words){
			System.out.println(isUniqChars(word));
		}
	}
}
