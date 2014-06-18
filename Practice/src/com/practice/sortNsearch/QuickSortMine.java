package com.practice.sortNsearch;

public class QuickSortMine 
{
	static int[] mInput = {30, 40, 10, 20, 90, 50}; 
	
	public static void main (String args[])
	{
		int size = 10;
		/*mInput = new int[size];
		
		for (int i = 0; i < size; i++)
			mInput[i] = (int) (random() * size);
		
		for (int i = 0; i < size; i++)
			System.out.print(mInput[i] + " ");
		
		System.out.println("");*/
		
		quicksort(mInput, 0, mInput.length - 1);

		for (int i = 0; i < mInput.length; i++)
			System.out.print(mInput[i] + " ");
	}
	
	static double random()
	{
		return Math.random();
	}
	
	public static void quicksort(int[] a, int low, int high)
	{
		int left = low, right = high, mid = left + ((right - left) / 2);
		
		while (left < right)
		{
			while (a[left] < a[mid])
				left++;
			while (a[right] > a[mid])
				right--;
			
			if (left <= right)
			{
				int temp = a[left];
				a[left] = a[right];
				a[right] = temp;
				
				left++;
				right--;
			}
		}
		
		if (low < right)
			quicksort(a, low, right);
		if (left < high)
			quicksort(a, left, high);
	}
}
