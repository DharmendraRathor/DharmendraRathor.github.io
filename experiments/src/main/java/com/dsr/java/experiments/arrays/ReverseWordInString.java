package com.dsr.java.experiments.arrays;

import java.util.Arrays;

/**
 * 
 * Given a String of length N reverse each word in it. Words are separated by dots.
 * Input : i.like.this.program.very.much
 * Output : i.ekil.siht.margorp.yrev.hcum
 * @author dharmendra
 *
 */
public class ReverseWordInString {

	public static void main(String[] args) {
		String input = "i.like.this.program.very.much";
		System.out.println(" response " + reverseWord(input));
	}

	private static String reverseWord(String input) {
		if (null == input) {
			return input;
		}

		String[] tokens = input.split("\\.");

		StringBuilder reverseString = new StringBuilder();

		int count = 0;
		for (String word : tokens) {
			if (count == tokens.length) {
				StringBuilder sb = new StringBuilder(word);
				reverseString.append(sb.reverse());
			} else {
				StringBuilder sb = new StringBuilder(word);
				reverseString.append(sb.reverse()).append(".");

			}

			count++;

		}

		return reverseString.toString();
	}

}
