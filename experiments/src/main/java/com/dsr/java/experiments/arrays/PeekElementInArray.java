package com.dsr.java.experiments.arrays;

/*
 * Given an array A of integers. The task is to find a peak element in it.
An array element is peak if it is not smaller than its neighbors. For corner elements, we need to consider only one neighbor. 
 */

public class PeekElementInArray {

	public static void main(String[] args) {
		int[] input = { 988, 857, 744, 492, 228, 366, 860, 937, 433, 552, 438, 229, 276, 408, 475 };
		System.out.println(peakElement(input, 15));
	}

	static int peakElement(int a[], int n) {
		int countOfPeek = 0;
		for (int i = 0; i < n; i++) {
			if (i == 0) {
				if (a[i + 1] < a[i]) {
					//return i; // if you have to return index.
					countOfPeek++;
				}
			} else if (i == n - 1) {
				if (a[i - 1] < a[i]) {
					//return i; // if you have to return index.
					countOfPeek++;
				}
			} else {

				if (a[i - 1] < a[i] && a[i] > a[i + 1]) {
					//return i; // if you have to return index.
					countOfPeek++;
				}

			}

		}

		if (countOfPeek > 0) {
			return 1;
		} else {
			return 0;
		}
	}

}
