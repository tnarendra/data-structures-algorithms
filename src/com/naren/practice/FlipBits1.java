package com.naren.practice;

import java.util.Scanner;

public class FlipBits1 {

	private static long inverseBits(long num) {

		long all = (1L << 4) - 1;
		System.out.println(all + ", "+ num);
		return (all ^ num);

	}

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		for (int j = 0; j < t; j++) {
			long n = in.nextLong();
			System.out.println(inverseBits(n));

		}

	}

}
