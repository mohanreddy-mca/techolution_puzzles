package com.test.techolution;

public class ConsecutiveSum {

	public static void main(String[] args) {

		System.out.println(consecutiveSum(15000000));
	}

	private static long consecutiveSum(long input) {
		long output = 0;

		long pow12 = (long) Math.pow(10, 12);
		if (1 <= input && input <= pow12) {

			int odd_num = (input % 2 == 0) ? 0 : 1;
			long half_input_no = (input / 2) + odd_num; //checking half of the input number.

			for(long i = 1; i <= half_input_no; i++) {
				long sum = 0;
				for(long j = i; j <= half_input_no; j++) {
					sum = sum+j;
					if (sum >= input) {
						break;
					}
				}
				if(sum == input) {
					output++;
				}
			}
		}
		return output;
	}
	
}
