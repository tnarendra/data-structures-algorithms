package com.naren.practice.strings;

import java.util.Arrays;

public class CharString {

	public static void main(String[] args) {
		char[] chr = { 'a', 'b', 'c', 'd', 'e', 'f' };

		String str = "abcdef";

		if ( Arrays.equals(str.toCharArray(), chr)) {

			System.out.println("Compared");
			
		} else{
			System.out.println(str.toString() +", "+ chr.toString());
		}

	}

}
