package com.naren.strings;

public class StringCompression {

	public static void main(String[] args) {
		perm("", "abcd");

	}

	private static void perm(String prefix, String remainder) {
		if (remainder.length() == 0)
			System.out.println(prefix);
		else {
			for (int i = 0; i < remainder.length(); i++) {
				perm(prefix + remainder.charAt(i),
						remainder.substring(0, i) + remainder.substring(i + 1, remainder.length()));

			}

		}
	}
}
