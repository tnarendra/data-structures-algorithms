package com.naren.practice.hr.ds;

import java.util.Arrays;
import java.util.Scanner;

public class NumCut {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int arr[] = new int[n];
		for (int arr_i = 0; arr_i < n; arr_i++) {
			arr[arr_i] = in.nextInt();
		}

		Arrays.sort(arr);

		int min = arr[0];
		System.out.println(arr.length);
		while (arr[arr.length - 1] >= 0) {
			int i;
			for (i = arr.length - 1; arr[i] > 0 && i >= 0; i--) {
				arr[i] = arr[i] - min;

				if (arr[i] == 0 && i < arr.length - 1) {
					min = arr[i + 1];
					System.out.println((arr.length - 1) - i);
					break;
				}
			}
		}
	}
}
