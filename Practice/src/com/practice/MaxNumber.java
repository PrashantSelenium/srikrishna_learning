package com.practice;

public class MaxNumber
{
	public static void main (String args[])
	{
		
		int[] mArray = {4,14,21,82};
		quicksort(mArray, 0, mArray.length - 1);
		
		
		for (int i = 0; i < mArray.length; i++)
			System.out.println(mArray[i]);
		//getMax(mArray);
	}
	
	static void getMax(int[] array)
	{
		int length = array.length;
		int initialmax = array[length -1];
		
		boolean[] isTaken = {false, false, false, false, false, false, false};
		String str = "";
		
		System.out.println(initialmax);
//		System.exit(0);
		
		
		
		for (int i = array.length-1; i >= 0; i--)
		{
			initialmax = array[i];
			
			while (initialmax/10 != 0)
			{
				initialmax = initialmax/10;
			}
			
			
			if (!isTaken[i])
				str = str + array[i];
			
			
		}
		
		System.out.println(str);
	}
	
	static int search (int[] array, int key, int low, int high)
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
	
	public static void quicksort(int[] array, int low, int high)
	{
		int left = low, right = high;
		int pivort = low + ((high - low) / 2);
		
		while (left <= right)
		{
			int mLeft = array[left];
			int mPivort = array[pivort];
			int mRight = array[right];
			
			while (mLeft/10 != 0)
				mLeft = mLeft/10;
			while (mRight/10 != 0)
				mRight = mRight/10;
			while (mPivort/10 != 0)
				mPivort = mPivort/10;
			
			while (array[left] < array[pivort])
			{
				left++;
				
				mLeft = array[left];
				mPivort = array[pivort];
				
				while (mLeft/10 != 0)
					mLeft = mLeft/10;
				
				while (mPivort/10 != 0)
					mPivort = mPivort/10;
			}
			while (array[right] > array[pivort])
			{
				right--;
				
				mPivort = array[pivort];
				mRight = array[right];
				
				while (mRight/10 != 0)
					mRight = mRight/10;
				while (mPivort/10 != 0)
					mPivort = mPivort/10;
			}

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
