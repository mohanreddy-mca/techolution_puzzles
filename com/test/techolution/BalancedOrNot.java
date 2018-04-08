package com.test.techolution;

public class BalancedOrNot {

	public static void main(String[] args) {
		
		String input [] = new String[6];
		input[0] = "2"; //size of expressions
		input[1] = "<>>>"; //string1
		input[2] = "<>>>>"; //string2
		input[3] = "2"; //maxreplacements
		input[4] = "2"; // replacement1
		input[5] = "2"; //replacement2
		
		int output[] = balancedOrNot(input);
		for (int i : output) {
			System.out.println(i);
		}
	}

	private static int [] balancedOrNot (String input[]) {
		int output[]  = null;
		try {
			int noOfExpressions = Integer.parseInt(input[0]);
			output = new int[noOfExpressions];
			
			for(int i =1; i<= noOfExpressions; i++) {
				String str = input[i];
				str.chars();
				//getting lessthan, greater than symbols count from input
				long countLessthan = str.chars().filter(num -> num == '<').count();
				long countGreaterThan = str.chars().filter(num -> num == '>').count();
				long diffChars = Math.abs(countLessthan - countGreaterThan);
				int maxReplacements = Integer.parseInt(input[noOfExpressions+1+i]);
				if(countLessthan ==  countGreaterThan) {
					output[i-1] = 1;
				}else if(diffChars <= maxReplacements) {
					output[i-1] = 1;
				}else {
					output[i-1] = 0;
				}
			}
			return output;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return output;
		
	}
}
