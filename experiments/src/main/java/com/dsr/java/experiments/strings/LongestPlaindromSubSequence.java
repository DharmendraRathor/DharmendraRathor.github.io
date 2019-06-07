package com.dsr.java.experiments.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Longest Palindromic Subsequence. 
 * 1. Using recursion . O(2 pow n) 
 * 2. Using dynamic programming using Map.(top down) 
 * 3. Using dynamic programming using
 * array. (bottom up)
 * 
 * @author dharmendra
 *
 */
public class LongestPlaindromSubSequence {
	public static void main(String[] args) {
		String in = "ABBDCACB";
		// System.out.println(longestSubSequence("ABBDCACB", 0, in.length() - 1));
		// Map<String, Integer> map = new HashMap<>();
		// System.out.println(longestSubSequenceWithMap(in, 0, in.length() - 1, map));
		findPalindrome(in);

	}

	/**
	 * Exponential solution with complexity O(2 pow n)
	 * 
	 * @param in
	 * @param low
	 * @param high
	 * @return
	 */
	private static int longestSubSequence(String in, int low, int high) {

		if (high < low) {
			return 0;
		}

		if (low == high) {
			return 1;
		}

		if (in.charAt(low) == in.charAt(high)) {
			return longestSubSequence(in, low + 1, high - 1) + 2;
		} else {
			return Math.max(longestSubSequence(in, low, high - 1), longestSubSequence(in, low + 1, high));
		}

	}

	/**
	 * Time Complexity = O(n2) Dynamic programming. Using top down approach.
	 * 
	 * @param map
	 */

	private static int longestSubSequenceWithMap(String in, int low, int high, Map<String, Integer> map) {

		if (high < low) {
			return 0;
		}

		if (low == high) {
			return 1;
		}

		String key = low + "|" + high;

		if (map.containsKey(key)) {
			return map.get(key);
		} else {
			if (in.charAt(low) == in.charAt(high)) {
				map.put(key, longestSubSequence(in, low + 1, high - 1) + 2);
			} else {
				map.put(key, Math.max(longestSubSequence(in, low, high - 1), longestSubSequence(in, low + 1, high)));
			}
		}

		return map.get(key);
	}

	/**
	 * Dynamic programming using array , bottom up approach. Time Complexity = O(n2)
	 */
	public static int findPalindrome(String in) {
		char[] chars = in.toCharArray(); // Convery string to character array..
		int[][] lpArr = new int[chars.length][chars.length];
		// lpArr[i][j] - length of palindrome from ith index to jth index
		// all the characters in the string are palindrome by itself of length 1.
		// So all lpArr[i][i] = 1
		for (int i = 0; i < chars.length; i++) {
			lpArr[i][i] = 1;
		}

		for (int wordLen = 2; wordLen <= chars.length; wordLen++) {

			for (int i = 0; i <= lpArr.length - wordLen; i++) {
				int j = i + wordLen - 1;
				if (chars[i] == chars[j] && wordLen == 2) {
					lpArr[i][j] = 2;
				} else if (chars[i] == chars[j]) {
					lpArr[i][j] = lpArr[i + 1][j - 1] + 2;
				} else {
					lpArr[i][j] = Math.max(lpArr[i + 1][j], lpArr[i][j - 1]);
				}
			}
			printArray(lpArr);
			System.out.println("-----------------------");
		}
		printArray(lpArr);

		return lpArr[0][lpArr.length - 1];

	}

	public static void printArray(int[][] lpArr) {
		for (int i = 0; i < lpArr.length; i++) {
			for (int j = 0; j < lpArr.length; j++) {
				System.out.print("  " + lpArr[i][j]);
			}
			System.out.println("");
		}
	}
}
