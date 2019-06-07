package com.dsr.java.experiments.strings;

public class DisplayLongestPalindromSequence {
	public static void main(String[] args) {
		//String in = "ABBDCACB";
		String in = "ABABN";
		//System.out.println(longestSubSequence("ABBDCACB", 0, in.length() - 1));
	}

//	private static String longestSubSequence(String in, int low, int high) {
//
//		if (high < low) {
//			return "";
//		}
//
//		if (low == high) {
//			return in.charAt(low) + "";
//		}
//
//		if (in.charAt(low) == in.charAt(high)) {
//			return in.charAt(low) + longestSubSequence(in, low + 1, high - 1) + in.charAt(high);
//		} else {
//			if (longestSubSequence(in, low, high - 1).length() > longestSubSequence(in, low + 1, high).length()) {
//				return longestSubSequence(in, low, high - 1);
//			} else {
//				return longestSubSequence(in, low + 1, high);
//			}
//		}
//
//	}
}
