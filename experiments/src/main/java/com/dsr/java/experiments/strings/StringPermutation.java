package com.dsr.java.experiments.strings;

public class StringPermutation {

	static void permutation(String str, String chosen) {
		if (str.length() == 0) {
			System.out.println(chosen);
		} else {
			char[] chars = str.toCharArray();
			for(int i =0;i< chars.length;i++) {
				// chose stage
				char c = chars[i];      
				chosen = chosen+c;
				str = str.substring(str.indexOf(c)+1);
				//System.out.println(" str " + str + " chosen " + chosen);
				// explore stage
				permutation(str,chosen);
				
				// unchoose stage
				str = str + c;
				chosen = chosen.substring(0, chosen.length()-1);
			}

		}
	}

	public static void main(String[] a) {
		permutation("ABC", "");
	}
	
}
