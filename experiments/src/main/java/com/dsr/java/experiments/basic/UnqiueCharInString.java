package com.dsr.java.experiments.basic;

import java.util.HashSet;
import java.util.Set;

/**
 * Implement algorithm to determine string has all unique characters. And try
 * withouth using extra data structure
 * 
 * @author dharmendra
 *
 */
public class UnqiueCharInString {

	public static void main(String[] args) {
		String input = "abcdefe";
		System.out.println("result " + isUniqueCharString(input));
		System.out.println("result " + isUniqueCharStringUsingSet(input));
		System.out.println("result " + isUniqueCharStringUsingArray(input));
		System.out.println("result " + uniqueCharacters(input));
	}

	/**
	 * Time complexity = o(n2) Space complexity = o(1)
	 * 
	 * @param input
	 * @return
	 */
	private static boolean isUniqueCharString(String input) {
		if (null == input || input.trim().equals("")) {
			return true;
		}
		char[] chars = input.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			char temp = chars[i];
			for (int j = i + 1; j < chars.length; j++) {
				if (temp == chars[j]) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Time complexity = O(n) Space complexity = O(n)
	 * 
	 * @param input
	 * @return
	 */
	private static boolean isUniqueCharStringUsingSet(String input) {
		char[] chars = input.toCharArray();
		if (null == input || input.trim().equals("")) {
			return true;
		}

		Set<Character> uniqueChars = new HashSet<Character>();
		for (int i = 0; i < chars.length; i++) {
			if (uniqueChars.contains(chars[i])) {
				return false;
			} else {
				uniqueChars.add(chars[i]);
			}
		}
		return true;
	}

	/**
	 * Considering ASCI string of 7 bit ie 128 char.
	 * 
	 * @param input
	 * @return
	 */
	private static boolean isUniqueCharStringUsingArray(String input) {
		char[] chars = input.toCharArray();
		if (null == input || input.trim().equals("")) {
			return true;
		}

		int[] uniqueCharSet = new int[128];
		for (int i = 0; i < chars.length; i++) {
			if (uniqueCharSet[chars[i]] == 0) {
				uniqueCharSet[chars[i]] = 1;
			} else {
				return false;
			}
		}
		return true;

	}

	/**
	 * Space complexity = O(1)
	 * Time complexity = 0(n)
	 * Using bit operator The approach is valid for strings having alphabet as a-z.
	 * This approach is little tricky. Instead of maintaining a boolean array, we
	 * maintain an integer value called checker(32 bits). As we iterate over the
	 * string, we find the int value of the character with respect to ‘a’ with the
	 * statement int bitIndex = str.charAt(i)-‘a’; Then the bit at that int value is
	 * set to 1 with the statement 1 << bitIndex . Now, if this bit is already set
	 * in the checker, the bit AND operation would make checker > 0. Return false in
	 * this case. Else Update checker to make the bit 1 at that index with the
	 * statement checker = checker | (1 <<bitIndex);
	 */
	static boolean uniqueCharacters(String input) {
		// Assuming string can have characters a-z
		// this has 32 bits set to 0
		int checker = 0;

		for (int i = 0; i < input.length(); i++) {
			int bitIndex = input.charAt(i) - 'a';
			System.out.println(bitIndex + " (1 << bitIndex) " + (1 << bitIndex) + " checker " + checker);

			// if that bit is already set in checker,
			// return false
			if ((checker & (1 << bitIndex)) > 0)
				return false;

			// otherwise update and continue by
			// setting that bit in the checker
			checker = checker | (1 << bitIndex);
		}

		// no duplicates encountered, return true
		return true;
	}
}
