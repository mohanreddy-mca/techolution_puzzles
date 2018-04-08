package com.test.techolution;

public class PsychometricTesting {

	public static void main(String[] args) {
		int[] scores = new int[] {4,8,7,1000000000};
		int[] lowerLimits = new int[] {2,4,1000000000}; 
		int maxValueLimit = (int) Math.pow(10,9);
		System.out.println(maxValueLimit);
		int[]upperLimits = new int[] {8,4,1000000000};
		int output[] = jobOffers(scores, lowerLimits, upperLimits);
		
		if(output == null) {
			System.out.println("Input data wrong...");
		}else {
			for (int i : output) {
				System.out.println(i);
			}
		}
	}

	static int[] jobOffers(int[] scores, int[] lowerLimits, int[]upperLimits) {
		int output[] = null;
		int maxSize = (int) Math.pow(10,5);
		int maxValueLimit = (int) Math.pow(10,9);
		
		if(lowerLimits == null || upperLimits == null || (lowerLimits.length != upperLimits.length)) {
			return output;
		}
		if(scores.length > maxSize || lowerLimits.length > maxSize || upperLimits.length > maxSize) {
			return output;
		}
		
		output = new int[lowerLimits.length];
		for(int i =0; i<lowerLimits.length ; i++) {
			int matchedRec = 0;
			for(int j =0; j<scores.length; j++) {
				if(scores[j] > maxValueLimit || lowerLimits[i] > maxValueLimit || upperLimits[i] > maxValueLimit) {
					return null;
				}
				if(scores[j] >= lowerLimits[i] && scores[j] <= upperLimits[i] ) {
					matchedRec++;
				}
			}
			output[i] = matchedRec;
		}
		
		return output;
		
	}
}
