package com.dsr.java.experiments.basic;

import java.util.HashMap;
import java.util.Map;

/**
 * Sample Implementation of Fibonacci. Series characterized by the fact that
 * every number after the first two is the sum of the two preceding ones. two
 * numbers. input n (highest number at which series has to end) Series :
 * 0,1,1,2,3,5,8,13,21,34,55,89..... 
 * 
 * Three implementations 
 * 1. Using loop. 
 * 2. Using recursion. 
 * 3. Using memoization.(Technique to improve speed of
 *    computation by storing complex calculation results)
 * 
 * @author dsr
 *
 */
public class Fibonacci {

	public static void main(String[] args) {
		// with loop
		long startTime = System.nanoTime();
		loopFibonacci(10);
		System.out.println("time taken by loop method "+ (System.nanoTime() - startTime));

		// recursion
		startTime = System.nanoTime();
		for (int count = 0; count < 10; count++) {
			System.out.println(recursiveFibonacci(count));
		}
		System.out.println("time taken by recursion method "+ (System.nanoTime() - startTime));

		// memoization
		startTime = System.nanoTime();
		for (int count = 0; count < 10; count++) {
			System.out.println(memoizationFibonacci(count));
		}
		System.out.println("time taken by memo recursion method "+ (System.nanoTime() - startTime));

	}

	/*
	 * Using while loop. input = 10 output = 0 1 1 2 3 5 8
	 */
	static void loopFibonacci(int n) {
		int first = 0;
		int second = 1;
		System.out.println(first + "\n " + second);

		int sum = first + second;
		for (int count = 0; count < (n - 2); count++) {
			System.out.println(" " + sum);
			first = second;
			second = sum;
			sum = first + second;
		}

	}

	/*
	 * Using recursion.
	 */
	static int recursiveFibonacci(int n) {
		if (n == 0 || n == 1) {
			return n;
		} else {
			return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
		}
	}

	/*
	 * Using recursion and memorization of complex field in storage.
	 */
	static int memoizationFibonacci(int n) {
		Map<Integer, Integer> data = new HashMap<Integer, Integer>();
		if (n == 0 || n == 1) {
			return n;
		} else if (data.containsKey(n)) {
			return data.get(n);

		} else {
			int result = memoizationFibonacci(n - 1)
					+ memoizationFibonacci(n - 2);
			data.put(n, result);
			return result;
		}

	}

}
