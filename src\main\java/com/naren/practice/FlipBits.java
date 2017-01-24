package com.naren.practice;

import java.util.Scanner;

public class FlipBits {

	private static long inverseBits(int num) {
		long res = 0;

		char[] cr = new char[32];

		for (int i = 31; i >= 0;) {
			while (num > 0) {
				if (num % 2 == 0)
					cr[i] = '1';
				else
					cr[i] = '0';
				num = num / 2;
				i--;
			}
			cr[i] = '1';
			i--;
		}

		int k = 0;
		long tmp = 0;

		for (int j = 31; j >= 0; j--) {
			tmp = Integer.valueOf(String.valueOf(cr[j])) * twoPowerI(k);
			res = res + tmp;
			k++;
		}
		return res;
	}

	private static long twoPowerI(int k) {
		long res = 1;
		while (k > 0) {
			res = res * 2;
			k--;
		}
		return res;
	}

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		for (int j = 0; j < t; j++) {
			int n = in.nextInt();
			System.out.println(inverseBits(n));
		}

	}

}
