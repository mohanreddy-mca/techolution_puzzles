package com.test.techolution;

import java.util.HashSet;
import java.util.Set;

public class LargestSubSetSum {

	public static void main(String[] args) {
		
		//long start = System.currentTimeMillis();
		int input [] = new int [] {2,4,25,1000000000};
		long output [] = maxSubsetSum(input);
		for (long l : output) {
			System.out.println(l);
		}
		//System.out.println("time taken:="+(System.currentTimeMillis()-start));
	}
	
	private static long[] maxSubsetSum(int[] k) {
		long output[] = null;
		int maxArraySize = (int) Math.pow(10,3);
		if(k == null || k.length > maxArraySize) {
			return output;
		}else {
			output = new long[k.length];
			for(int i =0; i < k.length; i++) {
				output[i] = getSubSetSum_v3(k[i]);
			}
		}
		return output;
	}
	
	private static long getSubSetSum_v3(int val) {
		int odd_num = (val % 2 == 0) ? 0 : 1;
		long half_input_no = (val / 2) + odd_num;
		long subSetSum = 0;
		
		Set<Integer> set = new HashSet<>();
		
		if(isPrimeNumber(val)) {
			subSetSum += 1;
			subSetSum += val;
		}else {
			if(val % 2 != 0) { //if not even number then no need to check 2 multiples
				for(int j=1; j<=half_input_no; j=j+2) {
					if(val % j == 0) {
						if(set.contains(j)) {
							break;
						}
						set.add(j);
						set.add(val/j);
						//System.out.println(j +"*"+ val/j);
						subSetSum +=j;
						if(j != val/j) {
							subSetSum +=val/j;
						}
					}
				}
			}else {
				for(int j=1; j<=half_input_no; j++) {
					if(val % j == 0) {
						if(set.contains(j)) {
							break;
						}
						set.add(j);
						set.add(val/j);
						//System.out.println(j +"*"+ val/j);
						subSetSum +=j;
						if(j != val/j) {
							subSetSum +=val/j;
						}
					}
				}
			}
		}
		return subSetSum;
	}

	private static boolean isPrimeNumber(int num) {
		int temp;
		boolean isPrime=true;
		for(int i=2;i<=num/2;i++)
		{
	           temp=num%i;
		   if(temp==0)
		   {
		      isPrime=false;
		      break;
		   }
		}
		//If isPrime is true then the number is prime else not
		return isPrime;
	}
	
	/*private static long getSubSetSum_v1(int val) {
		long subSetSum = 0;
		for(int j=1; j<=val; j++) {
			if(val % j ==0) {
				subSetSum +=j;
			}
		}
		return subSetSum;
	}
	
	private static long getSubSetSum_v2(int val) {
		long subSetSum = 0;
		Set<Integer> set = new HashSet<>();
		for(int j=1; j<=val; j++) {
			if(val % j ==0) {
				if(set.contains(j)) {
					break;
				}
				set.add(j);
				set.add(val/j);
				//System.out.println(j +"*"+ val/j);
				subSetSum +=j;
				if(j != val/j) {
					subSetSum +=val/j;
				}
			}
		}
		return subSetSum;
	}*/
}
