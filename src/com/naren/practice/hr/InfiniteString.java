package com.naren.practice.hr;

import java.util.Scanner;

public class InfiniteString {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		long n = in.nextLong();
		long l = s.length();
		long a = 0, sum = 0;
		long temp = n % l;
		for (long i = 0; i < l; ++i) {
			if (i < temp && s.charAt((int) i) == 'a')
				++sum;
			if (s.charAt((int) i) == 'a')
				sum += (long) (n / l);
		}
		System.out.println(sum);
	}
}
