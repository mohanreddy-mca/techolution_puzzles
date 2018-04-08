package com.test.techolution;

public class FindTheWinner {

	public static void main(String[] args) {
		
		int andrea[] = new int[3];
		andrea[0] = 1;
		andrea[1] = 2;
		andrea[2] = 3;
		
		int maria[] = new int[3];
		maria[0] = 2;
		maria[1] = 1;
		maria[2] = 3;
		
		String s = "Odd";
		
		String  output =  findWinner(andrea, maria, s);
		System.out.println(output);
	}

	private static String findWinner(int andrea[], int maria[], String s) {
		String output = "";
		if(s.isEmpty() || andrea == null || maria == null || andrea.length != maria.length) {
			return output;
		}
		
		int andriaPoints = 0, mariaPoints = 0;
		
		if(s.equalsIgnoreCase("Even")) {
			for (int i = 0; i < andrea.length; i++) {
				if(i%2 == 0) {
					andriaPoints = andriaPoints + andrea[i] - maria[i];
					mariaPoints = mariaPoints + maria[i] - andrea[i];
				}
			}
		}else {
			for (int i = 0; i < andrea.length; i++) {
				if(i%2 != 0) {
					andriaPoints = andriaPoints + andrea[i] - maria[i];
					mariaPoints = mariaPoints + maria[i] - andrea[i];
				}
			}
		}
		
		if(andriaPoints == mariaPoints) {
			output = "Tie";
		}else if(andriaPoints > mariaPoints){
			output = "Andrea";
		}else {
			output = "Maria";
		}
		return output;
	}
}
