package com.naren.maths;

import java.util.Arrays;

public class Sum {

	public static void main(String[] args) {
		System.out.println(sum(5));
		firstNPairSum(8);
		int arr[] = { 1, 2, 4, 5, -10, -9, 67 };
		minMaxOfArray(arr);
		System.out.println(factorial(6));
		reverseAnArray(arr);

		System.out.println("\n" + sumDigits(677));

		// printSortedStrings(2);

		System.out.println(isAnagram("banana", "aaannb"));
		System.out.println(isAnagram2("banana", "aaannb"));
		System.out.println(isPrime(37));
		//153 sum of cubes of numbers equals to number.
		System.out.println(isArmstrong(371));
	}

	private static int sum(int i) {

		if (i <= 0) {
			return 0;
		}
		return i + sum(i - 1);
	}

	private static void firstNPairSum(int n) {

		if (n <= 0) {
			return;
		}

		int x = 0;
		int y = 1;
		int tmp;

		if (n >= 1) {
			System.out.print(x + ", ");
		}

		for (int i = 1; i < n; i++) {

			System.out.print((x + y) + ", ");
			tmp = x;
			x = y;
			y = tmp + x;

		}
	}

	private static void minMaxOfArray(int[] arr) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (int i : arr) {

			if (i < min)
				min = i;
			if (i > max)
				max = i;
		}
		System.out.println("\n" + "Max: " + max + ", Min: " + min);
	}

	private static int factorial(int n) {
		if (n == 0)
			return 1;
		if (n == 1)
			return 1;
		return n * factorial(n - 1);
	}

	private static void reverseAnArray(int[] arr) {
		System.out.print("\nOriginal Array : ");
		for (int i : arr) {
			System.out.print(i + " ");
		}

		for (int i = 0; i <= arr.length / 2; i++) {

			int tmp = arr[arr.length - i - 1];
			arr[arr.length - i - 1] = arr[i];
			arr[i] = tmp;
		}
		System.out.print("\nReverse Array : ");

		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	private static int sumDigits(int i) {
		int sum = 0;

		while (i > 0) {
			sum += i % 10;
			i /= 10;
		}

		return sum;

	}

	public static int numChars = 26;

	public static void printSortedStrings(int remaining) {
		printSortedStrings(remaining, "");
	}

	public static void printSortedStrings(int remaining, String prefix) {
		if (remaining == 0) {
			System.out.println(prefix);
		} else {
			for (int i = 0; i < numChars; i++) {
				char c = ithLetter(i);
				printSortedStrings(remaining - 1, prefix + c);
			}
		}
	}

	public static boolean isInOrder(String s) {
		for (int i = 1; i < s.length(); i++) {
			int prev = ithLetter(s.charAt(i - 1));
			int curr = ithLetter(s.charAt(i));
			if (prev > curr) {
				return false;
			}
		}
		return true;
	}

	public static char ithLetter(int i) {
		return (char) (((int) 'a') + i);
	}

	public static boolean isAnagram(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;

		char[] arr = s1.toCharArray();
		for (char ch : arr) {
			int i = s2.indexOf(ch);
			if (i != -1) {
				s2 = s2.substring(0, i) + s2.substring(i + 1, s2.length());

			} else
				return false;
		}

		return s2.isEmpty();
	}

	public static boolean isAnagram2(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		char[] ch1 = s1.toCharArray();
		char[] ch2 = s2.toCharArray();

		Arrays.sort(ch1);
		Arrays.sort(ch2);

		return new String(ch1).equals(new String(ch2));
	}

	public static boolean isPrime(int n) {
		if (n == 2)
			return true;

		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n%i == 0)
				return false;
		}
		return true;
	}
	
	public static boolean isArmstrong(int i) {
		int res = 0;
		int tmp = i;
		while(i > 0){
			int rem = i % 10;
			
			res += rem*rem*rem;
			
			i /= 10;
		}
		
		return tmp == res;
	}
}
