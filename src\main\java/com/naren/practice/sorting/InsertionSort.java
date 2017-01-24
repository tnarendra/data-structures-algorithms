package com.naren.practice.sorting;

public class InsertionSort {

	public static void main(String args[]) {

		int arr[] = { 23, 12, 34, 5, 6, 23, 1, 56, 2 };
		System.out.print(" Unsorted arry: ");
		for (int i : arr) {
			System.out.print(i + " ");
		}

		int[] arr1 = insertionSort(arr);

		System.out.print("\n Sorted arry: ");
		for (int j : arr1) {
			System.out.print(j + " ");
		}

		System.out.println();
	}

	private static int[] insertionSort(int[] arr) {

		for(int i = 1; i < arr.length; i++){
			int j = i;	
			int tmp = arr[i];
			
			while(j > 0 && arr[j-1] > tmp){
				arr[j] = arr[j-1];
				j--;
			}
			arr[j] = tmp;
		}
		return arr;
	}
}
