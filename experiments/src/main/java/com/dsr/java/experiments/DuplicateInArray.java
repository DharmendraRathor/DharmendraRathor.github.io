package com.dsr.java.experiments;

/**
 * Program to find duplicate in array.
 * 
 * @author dharmendra
 *
 */
public class DuplicateInArray {

	public static void main(String[] args) {

		int[] numbers = { 1, 3, 4, 5, 6, 1, 5 };
		System.out.println("duplicate number " + findDuplicate(numbers));
		System.out.println("duplicate number " + findDuplicateWithConstantSpaceAndTime(numbers));

	}

	/**
	 * Time Complexity is O(n) - constant Space complexity is O(1) - constant
	 * 
	 * Logic is to use duplicate value and index and make that as -ve. eg , if 1 and
	 * 5 is duplicate in test array. make value at numbers[1] and value at
	 * numbers[5] as -ve value and then next time , when number will repeat and we
	 * will check value of numebers[] of duplicate value , it will be negative.
	 * 
	 * 
	 * @param numbers
	 * @return
	 */
	private static String findDuplicateWithConstantSpaceAndTime(int[] numbers) {
		String duplicateNumber = "";
		for (int i = 0; i < numbers.length; i++) {

			if (numbers[Math.abs(numbers[i])] > 0) {
				numbers[Math.abs(numbers[i])] = -numbers[Math.abs(numbers[i])];
			} else {
				duplicateNumber = duplicateNumber + " " + Math.abs(numbers[i]);
			}
		}

		return duplicateNumber;
	}

	/**
	 * Method space complexity = O(1) Method time Complexity = O(n2)
	 * 
	 * @param numbers
	 * @return
	 */
	private static String findDuplicate(int[] numbers) {
		String duplicateNumber = "";
		for (int i = 0; i < numbers.length; i++) {
			int currentNumber = numbers[i];
			for (int j = i + 1; j < numbers.length; j++) {
				if (currentNumber == numbers[j]) {
					duplicateNumber = duplicateNumber + " " + currentNumber;
				}
			}
		}

		return duplicateNumber;

	}

}
