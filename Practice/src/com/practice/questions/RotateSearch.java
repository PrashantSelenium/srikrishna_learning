package com.practice.questions;

public class RotateSearch 
{
	static int[] mInput = {30,40,50,60,10,10,25};
	public static void main (String args[])
	{
		int rotate = 3;
		int key = 10;
		int value = search(mInput, key, 0 ,mInput.length-1 - rotate);
		
		if (value == -1)
		{
			value = search(mInput, key, mInput.length-1 - rotate + 1 ,mInput.length-1);
		}
		System.out.println(value);
	}
	
	public static int search (int[] array, int key, int low, int high)
	{
		int found = -1;
		if (low <= high)
		{
			int mid = low + ((high - low) / 2);
			
			if (array[mid] == key)
				return mid;
			else if (key < array[mid] && key >= array[low])
				found = search (array, key, low, mid);
			else if (key > array[mid] && key <= array[high])
				found = search (array, key, mid+1, high);
		}
		return found;
		
	}
}
