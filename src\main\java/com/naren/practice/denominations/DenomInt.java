package com.naren.practice.denominations;

import java.util.Arrays;
import java.util.Scanner;

public class DenomInt {

	static long countWays(int S[], int m, int n) {
		long[] table = new long[n + 1];

		Arrays.fill(table, 0);

		table[0] = 1;

		for (int i = 0; i < m; i++) {
			for (int j = S[i]; j <= n; j++) {
				table[j] += table[j - S[i]];
			}
		}

		return table[n];
	}

	static int primeSum2(int[] primes, int num) {
		int target = 2;

		while (true) {
			int[] ways = new int[target + 1];
			ways[0] = 1;

			for (int i = 0; i < primes.length; i++) {
				for (int j = primes[i]; j <= target; j++) {
					ways[j] += ways[j - primes[i]];
				}
			}

			if (ways[target] > num)
				break;
			target++;
		}

		return target;
	}

	static int primeSum(int[] primes, int num, int index) {
		if (num == 0) {
			return 1;
		}
		if (num < 0)
			return 0;

		int way = 0;
		for (int i = 0; i < primes.length; i++) {
			if (i >= index) {
				way += primeSum(primes, (num - primes[i]), i);
			}
		}
		return way;
	}

	public static void main(String[] args) {

		int[] primes = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97,
				101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199,
				211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331,
				337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457,
				461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599,
				601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719, 727, 733,
				739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853, 857, 859, 863, 877,
				881, 883, 887, 907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997 };

		Scanner scan = new Scanner(System.in);

		int q = scan.nextInt();

		for (int i = 0; i < q; i++) {

			int k = scan.nextInt();

			long start = System.currentTimeMillis();
			System.out.println(primeSum(primes, k, -1));
			System.out.println(System.currentTimeMillis()-start);
			
			start = System.currentTimeMillis();
			System.out.println(countWays(primes, primes.length, k));
			System.out.println(System.currentTimeMillis()-start);
			
		}

	}
}