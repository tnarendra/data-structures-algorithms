package com.naren.practice;

import java.util.Scanner;

public class GameTheory2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			int x = in.nextInt();
			int y = in.nextInt();

			winner(x, y);
		}
	}

	public static void winner(int x, int y) {
		x = x % 4;
		y = y % 4;
		if ((y == 0) || (y == 3) || (x == 0) || (x == 3))
			System.out.println("First");
		System.out.println("Second");
	}
}
