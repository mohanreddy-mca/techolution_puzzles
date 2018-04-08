package com.test.techolution;

import java.util.ArrayList;
import java.util.List;

public class TwoCircles {

	public static void main(String[] args) {
		int n = 4;
		String input1[][] = new String[][]{
			{"12","0","21","14","0","23"},
			{"0","45","8","0","94","9"},
			{"35","0","13","10","0","38"},
			{"0","26","8","0","9","25"}};

			String input2[][] = new String[][]{
				{"0","5","9","0","9","7"},
				{"0","15","11","0","20","16"},
				{"26","0","10","39","0","23"},
				{"37","0","5","30","0","11"},
				{"41","0","0","28","0","13"}};
				List<String> output = circles(input2);
				for (String string : output) {
					System.out.println(string);
				}
	}
	private static List<String> circles(String[][] input) {

		List<String> output = new ArrayList<>();
		for (String[] strings : input) {
			int ax = Integer.parseInt(strings[0]);
			int ay = Integer.parseInt(strings[1]);
			int ar = Integer.parseInt(strings[2]);
			int bx = Integer.parseInt(strings[3]);
			int by = Integer.parseInt(strings[4]);
			int br = Integer.parseInt(strings[5]);

			if(ax == bx && ay == by) {
				output.add("Concentric");
			}else if((ax+ay+ar == bx+by+br) || (ax+ay-ar == bx+by-br)
					|| (ax+ay-ar == bx+by+br) || (ax+ay+ar == bx+by-br)) {
				output.add("Touching");
			}else if((ax+ay+ar < bx+by+br ) && (bx+by+br < ax+ay+ar)) {
				output.add("Disjoint-Inside");
			}else if(((ax+ay+ar)-(bx+by-br) < 0) || ((bx+by+br)-(ax+ay-ar) < 0) ) {
				output.add("Disjoint‐Outside");
			}else {
				output.add("Intersecting");
			}

		}
		return output;
	}

}
