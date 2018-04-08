package com.test.techolution;

public class InTheFeature {

	public static void main(String[] args) {
		int output = minDays(3, 5, 1);
		System.out.println(output);
	}

	private static int minDays(int a, int k, int p) {
		int numDays = 1;
		if (a >= 1 && a <= 100 && k >= 1 && k <= 100 && p >= 0 && p <= 100) {
			while (k <= a + p) {
				numDays = numDays + 1;
				k += k;
				a += a;
			}
		}
		return numDays;
	}
	
}
