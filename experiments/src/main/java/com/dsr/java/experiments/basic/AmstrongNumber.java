package com.dsr.java.experiments.basic;

/**
 * Number is called AmstrongNumber if , if digit is equal to sum of cubes of
 * individual digits.
 * 
 * eg 153= 1+ 125+27
 * 
 * @author dsr
 *
 */
public class AmstrongNumber {

	public static void main(String[] args) {
		isAmstrongNumber(153);
	}

	/*
	 * Using reminder and devision operator.
	 */
	public static void isAmstrongNumber(int num) {
		int sum = 0;
		while (num > 0) {
			int temp = num % 10;
			sum += (temp * temp * temp);
			num = num / 10;
		}

		System.out.println(" sum of number " + sum + " actual number " + num);
	}
	
}
