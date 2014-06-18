package com.test;

import java.util.HashSet;
import java.util.Set;

public class CafeProblem {

	public static void main(String args[]) {

		System.out.println(runCustomerSimulation(2, "ABBAJJKZKZ"));
		System.out.println(runCustomerSimulation(3, "GACCBDDBAGEE"));
		System.out.println(runCustomerSimulation(3, "GACCBGDDBAEE"));
System.out.println(runCustomerSimulation(1, "ABCBCA"));		;
System.out.println(runCustomerSimulation(2, "ABCDBCDA"));
	}

	static int runCustomerSimulation(int numComputers, String customers) {

		Set<String> mHashSet = new HashSet<String>();
		Set<String> queue = new HashSet<String>();
		int cursor = 0;
		int computers = numComputers;
		int left = 0;
		while (cursor < customers.length()) {
			String str = "" + customers.charAt(cursor);
			if (computers > 0 && mHashSet.add(str)) {
				computers--;
			} else if (computers <= numComputers && mHashSet.contains(str)) {
				computers++;
				mHashSet.remove(str);
				if (queue.contains(str))
					queue.remove(str);
			} else if (computers == 0) {

				if (!queue.add(str)) {
					queue.remove(str);
					left++;
				}

			}
			cursor++;
		}

		return left;
	}

}
