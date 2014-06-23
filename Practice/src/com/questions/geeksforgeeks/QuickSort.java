package com.questions.geeksforgeeks;

import java.util.Arrays;

public class QuickSort
{
	
	
	
	public static void main (String args[])
	{
		int[] array = new int[]{50,30,10,60, 30, 2, 3, 10, 100, 6, 8, 7,20,40,70,5, 3, 2, 1, 100, 40, 20, 6, 8, 7,1};
		quicksort(array, 0, array.length-1);
		
		System.out.println("Final: "+Arrays.toString(array));
	}

	static void quicksort(int[] array, int start, int end)
	{
		if (start > end)
			return;
		
		int left = start;
		int right = end;
		int pivort = array[left + ((right - left) / 2)];
		
		while (left < right)
		{
			while (array[left] < pivort)
				left++;
			while (array[right] > pivort)
				right--;
				
			if (left <= right)
			{
				swap(array, left, right);
				left++;
				right--;
			}
		}
		
		if (start < right)
			quicksort(array, start, right);
		if (left < end)
			quicksort(array, left, end);
			
	}
	
	static void swap(int[] array, int arg1, int arg2)
	{
		int temp = array[arg1];
		array[arg1] = array[arg2];
		array[arg2] = temp;
	}
}
