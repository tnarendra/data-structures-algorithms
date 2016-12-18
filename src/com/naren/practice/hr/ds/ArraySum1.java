package com.naren.practice.hr.ds;

import java.util.Scanner;

public class ArraySum1 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		for (int i = 0; i < n; i++) {
			int m = in.nextInt();
			int flav = in.nextInt();

			int[] arr = new int[flav];

			for (int j = 0; j < flav; j++) {
				arr[j] = in.nextInt();
			}

			for (int j = 0; j < flav; j++) {
				for (int a = j; a < flav; a++) {
					if (m == (arr[j] + arr[a])) {
						System.out.println(arr[j] + " " + arr[a]);
					}
				}

			}

		}

	}
}
