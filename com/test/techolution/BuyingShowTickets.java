package com.test.techolution;

import java.util.LinkedList;

public class BuyingShowTickets {

	public static void main(String[] args) {
		Integer[] tickets = { 2,6,3,4,5 };
		Integer position = 2;
		int output = getWaitingTime(tickets, position);
		System.out.println(output);
	}

	private static Integer getWaitingTime(Integer[] tickets, Integer p) {
		LinkedList<Integer> ll = new LinkedList<Integer>();
		for (int i = 0; i < tickets.length; i++) {
			ll.add(i, tickets[i]);
		}
		Boolean done = true;
		Integer seconds = 0;
		while (done) {
			if (p == 0 && ll.getFirst() == 1) {
				done = false;
			} else if (p == 0 && ll.getFirst() != 1) {
				p = ll.size();
				ll.addLast(ll.getFirst() - 1);
			} else if (1 == ll.getFirst()) {
			} else {
				ll.addLast(ll.getFirst() - 1);
			}
			ll.removeFirst();
			System.out.println(ll.toString());
			p--;
			seconds++;
		}
		return seconds;
	}
}
