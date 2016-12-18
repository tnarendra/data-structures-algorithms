package com.naren.practice.string;

import java.util.Scanner;

public class StringCamelCase {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String s = in.next();

		int result = 1;

		char[] arr = s.toCharArray();

		for (char ar : arr) {
			if (Character.isUpperCase(ar))
				result += 1;
		}
		System.out.println(result);

	}

}
