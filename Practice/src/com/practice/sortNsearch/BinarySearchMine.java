package com.practice.sortNsearch;

public class BinarySearchMine 
{
	static int[] mInput = {10,20,20,30,40,50,60};
	public static void main (String args[])
	{
		int key = 31;
		int value = search(mInput, key, 0 ,mInput.length-1);
		System.out.println(value);
	}
	
	public static int search (int[] array, int key, int low, int high)
	{
		int found = -1;
		if (low < high)
		{
			int mid = low + ((high - low) / 2);
			
			if (array[mid] == key)
				found = mid;
			else if (key < array[mid])
				found = search (array, key, low, mid);
			else if (key > array[mid])
				found = search (array, key, mid+1, high);
		}
		return found;
		
	}
}
