package com.practice;

public class BinarySearch {

	static void search(int array[], int search) {
		int first = 0;
		int last = array.length - 1;
		int middle = (first + last) / 2;

		while (first <= last) 
		{
			if (array[middle] < search)
				first = middle + 1;
			else if (array[middle] == search) 
			{
				System.out.println(search + " found at location "
						+ (middle + 1) + ".");
				break;
			} else
				last = middle - 1;

			middle = (first + last) / 2;
		}
		if (first > last)
			System.out.println(search + " is not present in the list.\n");
	}

	public static void main(String args[]) {
		int a[] = { 0, 10, 20, 30, 40, 50, 60, 70, 80, 90 };
		search(a, 90);
	}
}
