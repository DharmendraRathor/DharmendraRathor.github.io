package com.dsr.java.experiments.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of
 * non-empty words, determine if s can be segmented into a space-separated
 * sequence of one or more dictionary words.
 * 
 * @author dharmendra
 *
 */
public class WordBreak {

	public static void main(String[] args) {
		Set<String> set = new HashSet<>(Arrays.asList("apple", "pen"));
		System.out.println(wordBreak("applepenapple", set));

		Set<String> s1 = new HashSet<>(Arrays.asList("cats", "dog", "sand", "and", "cat"));
		System.out.println(wordBreak("catsandog", s1));
	}

	private static boolean wordBreak(String in, Set<String> set) {

		if (null == in) {
			return false;
		}

		if (set.contains(in)) {
			return true;
		}

		int length = in.length();
		for (int i = 0; i < length; i++) {
			if (set.contains(in.substring(0, i))) {
				return wordBreak(in.substring(i, length), set);
			}
		}

		return false;

	}

}
