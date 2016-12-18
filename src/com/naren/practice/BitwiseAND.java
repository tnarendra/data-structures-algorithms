package com.naren.practice;

import java.util.Scanner;

public class BitwiseAND {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
			long a = in.nextLong();
			long b = in.nextLong();

			System.out.println(product(a, b));
		}
	}

	private static long product(long a, long b) {
		long res = a;
		System.out.println(a&b);
		while (a < b) {
			a = a + 1;
			res = res & a;
		}
		return res;
	}
}
