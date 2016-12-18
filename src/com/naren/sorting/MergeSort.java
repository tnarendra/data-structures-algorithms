package com.naren.sorting;

public class MergeSort {

	public static void main(String args[]) {

		int arr[] = { 23, 12, 34, 5, 6, 23, 1, 56, 2 };
		System.out.print(" Unsorted arry: ");
		for (int i : arr) {
			System.out.print(i + " ");
		}

		mergeSort(arr);

		System.out.print("\n Sorted arry: ");
		for (int j : arr) {
			System.out.print(j + " ");
		}

		System.out.println();
	}

	private static void mergeSort(int[] arr) {
		int[] helper = new int[arr.length];
		mergeSort(arr, helper, 0, arr.length - 1);
	}

	private static void mergeSort(int[] arr, int[] helper, int low, int high) {

		if (low < high) {
			int mid = (low + high) / 2;
			mergeSort(arr, helper, low, mid);
			mergeSort(arr, helper, mid + 1, high);
			merge(arr, helper, low, mid, high);
		}
	}
	
	private static void merge(int[] arr, int[] helper, int low, int mid, int high) {

		for (int i = low; i <= high; i++) {
			helper[i] = arr[i]; }

		int left = low;
		int right = mid + 1;
		int current = low;

		while (left <= mid && right <= high) {
			if (helper[left] <= helper[right]) {
				arr[current] = helper[left];
				left++;
			} else {
				arr[current] = helper[right];
				right++;
			}
			current++;
		}

		int remaining = mid - left;
		for (int i = 0; i <= remaining; i++) {
			arr[current + i] = helper[left + i];
		}
	}
}
