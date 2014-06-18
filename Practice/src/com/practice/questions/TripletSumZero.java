package com.practice.questions;

public class TripletSumZero 
{
	static int[] mInput = {-1, -1, 0, 1, 5, -5, 2, 3};
	
	public static void main (String args[])
	{
		quicksort(mInput, 0, mInput.length - 1);
		
		int left, high;
		for (int i = 0; i < mInput.length; i ++)
		{
			left = i + 1;
			high = mInput.length - 1;
			
			while (left < high)
			{
				if (mInput[i] + mInput[left] + mInput[high] == 0)
				{
					System.out.println(mInput[i] + "\t" + mInput[left] + "\t" + mInput[high]);
					left++;
				}
				else if (mInput[i] + mInput[left] + mInput[high] > 0)
					high--;
				else
					left++;
					
			}
		}
	}
	
	public static void quicksort(int[] array, int low, int high)
	{
		int left = low, right = high;
		int pivort = low + ((high - low) / 2);
		
		while (left <= right)
		{
			while (array[left] < array[pivort])
				left++;
			while (array[right] > array[pivort])
				right--;

			if (left <= right)
			{
				int temp = array[left];
				array[left++] = array[right];
				array[right--] = temp;
			}
		}
		
		if (low < right)
			quicksort(array, low, right);
		if (left < high)
			quicksort(array, left, high);
	}
}
