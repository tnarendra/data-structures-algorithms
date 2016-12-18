package com.naren.maths;

public class Fibonacci {

	public static void fibonacci(int i) {

		if (i >= 0)
			System.out.print(0 + " ");
		if (i >= 1)
			System.out.print(1 + " ");

		int fib1 = 0;
		int fib2 = 1;
		int fib3;
		for (int j = 2; j < i; j++) {
			fib3 = fib1 + fib2;
			fib1 = fib2;
			fib2 = fib3;
			System.out.print(fib3 + " ");
		}
	}

	public static void main(String[] args) {
		fibonacci(100);
	}
}
