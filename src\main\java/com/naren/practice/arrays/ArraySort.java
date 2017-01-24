package com.naren.practice.arrays;

import java.util.Scanner;

public class ArraySort {

	static void isSortPossible(int[] arr) {

		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				if (arr[j] < arr[i])
					count++;
			}

		}

		if (count % 2 == 0)
			System.out.println("YES");
		else
			System.out.println("NO");
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		
		for (int i = 0; i < n; i++) {
			int s = in.nextInt();
			int[] arr = new int[s];

			for (int j = 0; j < s; j++) {
				arr[j] = in.nextInt();
			}
			isSortPossible(arr);
		}
	}

}
