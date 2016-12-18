package com.naren.practice.hr.ds;

public class ChocoWraps {

	public static void main(String[] args) {

		chocoWraps(10, 2, 2);

	}

	private static void chocoWraps(int dol, int cost, int wraps) {

		int rem;
		int rem2;
		int chocos;
		rem = dol / cost;
		chocos = rem;

		while (rem / wraps > 0) {
			chocos += rem / wraps;
			rem2 = rem % wraps;
			rem = rem / wraps;
			rem += rem2;
		}
		System.out.println( chocos);
	}

}
