package com.naren.denominations;

import java.text.DecimalFormat;

public class Denom {
	static int totalDenom(double[] denom, double amount, int index) {
		if (amount == 0) {
			return 1;
		}
		if (amount < 0)
			return 0;
		
		int way = 0;
		for (int i = 0; i < denom.length; i++) {
			if (i >= index) {
				way += totalDenom(denom, Double.valueOf(new DecimalFormat(".##").format(amount - denom[i])), i);
			}
		}
		return way;
	}

	public static void main(String[] args) {
		double coins[] = { .25, .10, .05, .01 };
		double change = .01;

		int ways = totalDenom(coins, change, -1);

		System.out.println("Total ways :" + ways);
	}
}