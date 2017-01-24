package com.naren.practice.hr.chlng;

import java.util.Scanner;

public class BestDivisor {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		bestDivisor(n);
	}

	private static void bestDivisor(int n) {
		int highSum = Integer.MIN_VALUE;
		int num = Integer.MAX_VALUE;
		
		for (int i = 1; i <= n; i++) {
			int sum = 0;
			if (n % i == 0) {
				int tmp = i;
				while(tmp > 0) {
					sum += tmp % 10;
					tmp = tmp / 10;
				}
				
				if(highSum == sum) {
					num = num < i ? num : i;
				}
				
				num = highSum < sum ? i : num;
				highSum = highSum > sum ? highSum : sum;
			}
		}
		
		System.out.println(num);

	}
}