package com.naren.practice.sorting;

public class SelectionSort {

	public static void main(String args[]) {

		int arr[] = { 23, 12, 34, 5, 6, 23, 1, 56, 2 };
		System.out.print(" Unsorted arry: ");
		for (int i : arr) {
			System.out.print(i + " ");
		}

		int[] arr1 = selectionSort(arr);

		System.out.print("\n Sorted arry: ");
		for (int j : arr1) {
			System.out.print(j + " ");
		}

		System.out.println();
	}

	private static int[] selectionSort(int[] arr) {

		for (int i = 0; i < arr.length - 1; i++) {
			int pos = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[pos])
					pos = j;
			}
			int tmp = arr[i];
			arr[i] = arr[pos];
			arr[pos] = tmp;
		}
		return arr;
	}
}
