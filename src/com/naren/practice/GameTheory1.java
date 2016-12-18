package com.naren.practice;

import java.util.Scanner;

public class GameTheory1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			int n = in.nextInt();

			player(n);
		}
	}

	private static void player(int n) {
		if (n % 7 == 0 || n % 7 == 1) {
			System.out.println("Second");
		} else
			System.out.println("First");
	}
}
