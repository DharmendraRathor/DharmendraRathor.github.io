package com.dsr.java.experiments.basic;

/**
 * Prime number is number which is only divisible by 1 and itself.
 * 
 * @author dsr
 *
 */
public class PrimeNumber {
	public static void main(String[] args) {

		// prime number check results should be true;
		System.out.println("primate number check basic " + isPrimareNumer(7));
		System.out.println("primate number check advance "+ isPrimareNumerAdvance(7));
		System.out.println("primate number check advanceTwo "+ isPrimareNumerAdvanceTwo(7));

		// prime number check results should be false;
		System.out.println("primate number check basic " + isPrimareNumer(6));
		System.out.println("primate number check advance "+ isPrimareNumerAdvance(6));
		System.out.println("primate number check advanceTwo "+ isPrimareNumerAdvanceTwo(6));
	}

	/*
	 * Check if number is divisible by each number from 2 to number -1;
	 */
	private static boolean isPrimareNumer(int num) {
		if (num == 0 || num == 1) {
			return false;
		}

		for (int count = 2; count < num; count++) {
			if (num % count == 0) {
				return false;
			}
		}
		return true;
	}

	
	/*
	 * Check if number is divisible by 2, if yes , it is not prime. 
	 * Next check if number is divisible by odd numbers.
	 */
	private static boolean isPrimareNumerAdvance(int num) {
		if (num == 0 || num == 1) {
			return false;
		}

		if (num % 2 == 0) {
			return false;
		}

		for (int count = 3; count < num; count += 2) {
			if (num % count == 0) {
				return false;
			}
		}
		return true;
	}
	
	
	/*
	 * Check if number is divisible by 2, if yes , it is not prime. 
	 * Next check if number is divisible by odd numbers till square root of number.
	 */
	private static boolean isPrimareNumerAdvanceTwo(int num) {
		if (num == 0 || num == 1) {
			return false;
		}

		if (num % 2 == 0) {
			return false;
		}

		for (int count = 3; count*count < num; count += 2) {
			if (num % count == 0) {
				return false;
			}
		}
		return true;
	}
}
