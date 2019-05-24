package com.dsr.java.experiments.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Program to find element in array having highest frequency. Two approaches One
 * with time complexity O(n log n) and other o(n)
 * 
 * @author dharmendra
 *
 */
public class HighestfrequenceInArray {

	public static void main(String[] args) {
		int[] numbers = { 1, 3, 4, 5, 2, 2, 7, 5, 5, 7, 7, 7, 7 };

		System.out.println(" highest number " + findElementHavingHighestFrequency(numbers));
		System.out.println(" highest number " + findElementHavingHieghestFreq2(numbers));

	}

	/**
	 * Time complexity O(n log n ) Space complexity O(1)
	 * 
	 * @param numbers
	 * @return
	 */
	private static int findElementHavingHighestFrequency(int[] numbers) {
		// Log n complexity
		Arrays.sort(numbers);

		int lastNumber = 0;
		int maxCount = 0;
		int lastMaxCount = 0;
		int maxFreqNumber = 0;

		// o(n) complexity
		for (int i : numbers) {
			if (lastNumber == i) {
				maxCount++;
				if (maxCount > lastMaxCount) {
					lastMaxCount = maxCount;
					maxFreqNumber = i;
				}
			} else {
				maxCount = 0;

			}
			lastNumber = i;
		}

		return maxFreqNumber;

	}

	/**
	 * Time complexity = O(n) Space complexity = O(n)
	 * 
	 * @param numbers
	 * @return
	 */

	private static int findElementHavingHieghestFreq2(int[] numbers) {
		Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
		// o(n) complexity
		for (int i : numbers) {
			if (freqMap.containsKey(i)) {
				int frequency = freqMap.get(i);
				freqMap.put(i, ++frequency);
			} else {
				freqMap.put(i, 0);
			}
		}

		Set<Integer> keys = freqMap.keySet();
		int higestFreqKey = 0;
		int higestFreqVal = 0;

		// o(n) complexity
		for (int i : keys) {
			int keyValue = freqMap.get(i);
			if (keyValue > higestFreqVal) {
				higestFreqKey = i;
				higestFreqVal = keyValue;
			}
		}

		return higestFreqKey;
	}

}
