package com.naren.practice.hr.ds;

import java.util.Scanner;

public class ArraySum {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		for (int i = 0; i < n; i++) {
			int m = in.nextInt();

			int[] arr = new int[m];
			int sum = 0;

			for (int j = 0; j < m; j++) {
				int k = in.nextInt();
				sum += k;
				arr[j] = k;
			}

			int halfSum = 0;

			for (int l = 0; l < arr.length; l++) {
				int b = sum - halfSum - arr[l];
				
				//System.out.println("Sum: "+ sum +", halfSum: "+ halfSum);
				
				if (halfSum == b) {
					System.out.println("YES");
					break;
				}
				halfSum += arr[l];

				if (halfSum > b) {
					System.out.println("NO");
					break;
				}
			}

		}

	}
}
