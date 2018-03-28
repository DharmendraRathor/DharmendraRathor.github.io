package com.dsr.java.experiments;

/**
 * Palindrome is word, number which is same forward and backword.
 * eg 45654  is palindrome
 * eg 45655 is not palindorme
 * eg abcba is palindorme
 * eg abcbb is not palindrome
 * 
 * @author dsr
 *
 */
public class Palindrome {

	public static void main(String[] args) {
		System.out.println("is palindrome " + isPalindrome("abcba"));
		System.out.println("is palindrome " + isPalindrome("abcbb"));
		System.out.println("is palindrome " + isPalindrome("45654"));
		System.out.println("is palindrome " + isPalindrome("45655"));
	}

	private static boolean isPalindrome(String inString) {

		int strLength = inString.length();

		for (int i = 0; i <= (strLength / 2); i++) {

			if (inString.charAt(i) == inString.charAt(strLength - (i + 1))) {
				continue;
			} else {
				return false;
			}

		}

		return true;
	}

}
