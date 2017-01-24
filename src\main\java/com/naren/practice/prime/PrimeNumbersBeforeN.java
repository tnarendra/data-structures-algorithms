package com.naren.practice.prime;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * All prime numbers before n
 */
public class PrimeNumbersBeforeN {

	public static boolean isPrime(int n) {
		if(n <= 1)
			return false;
		
		int sqrt = (int) Math.sqrt(n);
		for (int i = 2; i <= sqrt; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		int counter = 0;
		int prevPrime = -1;

		for (int i = n; i <= m; i++) {
			if (isPrime(i)) {
				if (Math.abs(prevPrime - i) == 2) {
					counter++;
				}
				prevPrime = i;
			}
		}
		System.out.println(counter);

	}
}
