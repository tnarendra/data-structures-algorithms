package com.naren.practice.hr.ds;

import java.util.Scanner;

public class DataStructureString {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String arr[] = new String[n];
		for (int arr_i = 0; arr_i < n; arr_i++) {
			arr[arr_i] = in.next();
		}
		int m = in.nextInt();

		for (int arr_i = 0; arr_i < m; arr_i++) {
			String str = in.next();
			int counter = 0;
			for (String str1 : arr) {
				if (str1.equals(str))
					counter++;
			}
			System.out.println(counter);
		}
	}
}