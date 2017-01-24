package com.naren.practice;

import java.util.Scanner;

public class UniqueInteger {
	private static int lonelyInteger(int[] a) {
		int i = 0;

		for (int num : a){
			i = i ^ num;
			System.out.println("Num: "+ num +", i: "+ i);
			
		}

		return i;

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}
		System.out.println(lonelyInteger(a));
	}

}
