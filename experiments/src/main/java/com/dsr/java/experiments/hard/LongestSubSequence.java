package com.dsr.java.experiments.hard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestSubSequence {

//	public static void main(String[] args) {
//		int[] arr = { 2, 6, 1, 9, 4, 5, 3 };
//		System.out.println(longestSubSequence(arr));
//	}
	
	
	public static void main8(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while (t-- > 0) {
			String in = br.readLine().trim();
			String inStr = br.readLine().trim();

			String[] list = inStr.split(" ");
			int[] a = new int[list.length];

			for (int i = 0; i < list.length; i++) {
				a[i] = Integer.parseInt(list[i]);
			}
			longestSubSequence(a);
		}
	}


	private static int longestSubSequence(int[] arr1) {
		List<Integer> arr = Arrays.stream(arr1).boxed().collect(Collectors.toList());
		Set<Integer> s = new HashSet<Integer>(arr);

		int maxSeqCount = 0;
		for (int i : arr) {
			if (!s.contains((i - 1))) {
				int tempSeq = 0;
				int j = i;
				while (s.contains(j++)) {
					tempSeq++;
				}

				maxSeqCount = Math.max(tempSeq, maxSeqCount);

			}
		}

		return maxSeqCount;
	}

}
