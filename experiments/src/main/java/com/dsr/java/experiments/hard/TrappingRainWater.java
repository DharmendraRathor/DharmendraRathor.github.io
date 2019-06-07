package com.dsr.java.experiments.hard;
/**
 * Trapping Rain Water
 * Given an array arr[] of N non-negative integers representing height of blocks at index i as Ai where the width of each block is 1. Compute how much water can be trapped in between blocks after raining.
 * 
 * Time complexity o(n)
 * @author dharmendra
 *
 */
public class TrappingRainWater {
	
	public static void main(String[] args) {
		tappingRainWater("7 4 0 9");
	}

	private static void tappingRainWater(String inStr) {
		//int[] a = Stream.of(inStr.split(" ")).mapToInt(Integer::parseInt).toArray();
		
		 String[] list = inStr.split(" ");
		    int[] a = new int[list.length];

		    for (int i = 0; i < list.length; i++){
		        a[i] = Integer.parseInt(list[i]);
		    }
		    
		    
		int n = a.length;
		int[] left = new int[n];
		int[] right = new int[n];

		left[0] = a[0];

		for (int i = 1; i < n; i++) {
			left[i] = Math.max(left[i-1], a[i]);
		}

		right[n - 1] = a[n-1];

		for (int i = n - 2; i >= 0; i--) {
			right[i] = Math.max(right[i+1], a[i]);
		}

		int water = 0;
		for (int i = 1; i < n - 1; i++) {
			water += Math.min(left[i], right[i]) - a[i];
		}

		System.out.println(water);

	}
	
}
