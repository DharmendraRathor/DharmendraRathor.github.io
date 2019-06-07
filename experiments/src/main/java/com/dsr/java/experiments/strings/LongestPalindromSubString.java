package com.dsr.java.experiments.strings;

/**
 * Longest Palindromic substring. Given a String, find the longest palindromic
 * substring.
 * 
 * Brute force : Time complexity O(n3)
 * 
 * @author dharmendra
 *
 */
public class LongestPalindromSubString {

	static int maxLength = 0;

	public static void main(String[] args) {
		// longestSubStringBureForce("ANBABNN");

		System.out.println(" maxLength " + maxLength);
		// ANBABNN
		longestSubStringMiddleCharacter("ANBABNN");

	}

	/**
	 * TimeComplexiy = O(n) for loop and expandAndCheckPalindrome = 0(n) = O(n2).
	 * 
	 * @param in
	 */
	private static void longestSubStringMiddleCharacter(String in) {
		if (null == in || in.equals("")) {
			return;
		}

		for (int i = 0; i < in.length(); i++) {
			expandAndCheckPalindrome(in, i, i);
		}

	}

	/**
	 * TimeComplexiy = O(n)
	 * 
	 * @param in
	 * @param low
	 * @param high
	 */
	private static void expandAndCheckPalindrome(String in, int low, int high) {

		while (low >= 0 && high < in.length() && (in.charAt(low) == in.charAt(high))) {
			low--;
			high++;
		}

		String palindrome = in.substring(low + 1, high);
		if (maxLength < palindrome.length()) {
			maxLength = palindrome.length();
			System.out.println(" palindrome " + palindrome + " lenght " + maxLength);
		}
	}

//	
//	private static void expandAroundElement(String in, int low, int high) {
//
//		while (low >= 0 && high <= in.length()) {
//
//			if (isPalindrome(in.substring(low, high))) {
//				String palindrome = in.substring(low, high);
//				if (maxLength < palindrome.length()) {
//					maxLength = palindrome.length();
//					System.out.println(" palindrome " + palindrome + " lenght " + maxLength);
//				}
//			}
//
//			low--;
//			high++;
//		}
//	}

	/**
	 * Time complexity O(n)
	 * 
	 * @param in
	 * @return
	 */
	public static boolean isPalindrome(String in) {

		if (null == in || in.equals("")) {
			return false;
		}
		int length = in.length();
		int high = length;
		for (int i = 0; i < length / 2; i++) {
			if (!(in.charAt(i) == in.charAt(--high))) {
				return false;
			}

		}
		return true;
	}

	/**
	 * Time complexity O(n3) O(n2) for two loops and O(n) for isPalindrome method.
	 * 
	 * @param in
	 */
	private static void longestSubStringBureForce(String in) {

		if (null == in || in.equals("")) {
			return;
		}

		for (int i = 0; i < in.length(); i++) {
			for (int j = i; j < in.length(); j++) {
				if (isPalindrome(in.substring(i, j))) {
					String palindrome = in.substring(i, j);
					if (maxLength < palindrome.length()) {
						maxLength = palindrome.length();
						System.out.println(" palindrome " + palindrome + " lenght " + maxLength);
					}
				}
			}

		}

	}

}
