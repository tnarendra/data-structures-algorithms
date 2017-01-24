package com.naren.practice.hr;

import java.util.Scanner;
import java.util.TreeSet;

public class ManasaStone {

	public static void main(String[] args) {

		playerIDs("[nba.p.1234]ghvadshvajsdv [nba.p.1345]");
		Scanner in = new Scanner(System.in);
		if(in.hasNextLine())
			playerIDs(in.nextLine());
		int t = in.nextInt();
		for (int j = 0; j < t; j++) {
			steps(in.nextInt(), in.nextInt(), in.nextInt());
		}
	}

	private static void steps(int n, int a, int b) {

		int max = Math.max(a, b);
		int min = Math.min(a, b);

		TreeSet<Integer> finalStones = new TreeSet<Integer>();

		for (int i = 0; i < n; i++) {
			int sum = (i * a) + ((n - 1 - i) * b);
			finalStones.add(sum);
		}

		for (Integer e : finalStones) {
			System.out.print(e + " ");
		}
		System.out.println();

	}

	private static void playerIDs(String str) {

		int start = 0;
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < str.length(); i++) {

			if (str.charAt(i) == '[')
				start = i;
			else if (str.charAt(i) == ']') {
				if (sb.length() > 0)
					sb.append(",");

				sb.append(str.substring(start + 1, i));
			}
		}

		System.out.println(sb.toString());
	}
}
