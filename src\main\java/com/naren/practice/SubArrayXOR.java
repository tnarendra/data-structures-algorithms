package com.naren.practice;

import java.util.Scanner;

public class SubArrayXOR {
	
	//Sansa has an array. She wants to find the value obtained by XOR-ing the contiguous subarrays, followed by XOR-ing the values thus obtained. Can you help her in this task?


	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		for(int j = 0; j < t; j++) {
			int res = 0;

			int n = in.nextInt();
			int a[] = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = in.nextInt();
				if (i % 2 == 0) {
					res ^= a[i];
				}
			}
			if (n % 2 == 0) {
				System.out.println("0");
			} else {
				System.out.println(res);
			}
			
		}

	}
}
