package com.dsr.java.experiments;

/*
 * Program to find count of set bit in positive integer.
 */
public class SetBitCount {

	public static void main(String[] args) {
		System.out.println("result " + setbitCount(11011));
	}

	private static int setbitCount(int n) {
		int count = 0;
		while (n > 0) {

			if (n % 2 == 1) {
				count++;
			}

			n = n / 10;
		}
		return count;
	}
}
