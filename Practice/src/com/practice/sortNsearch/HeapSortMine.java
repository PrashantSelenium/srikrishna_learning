package com.practice.sortNsearch;

public class HeapSortMine
{
	public static int[] mInput = { 40, 200, 30, 20, 90, 100 };// , 60, 15, 25, 2, 40};
	public static void main(String args[])
	{
		heapsort(mInput);
	}
	
	public static void heapsort(int[] a)
	{
		heapify(a);
		
		int l = a.length - 1;
		for (int i = a.length - 1; i >= 0; i--)
		{
			exchange(a, 0, i);
			l= l - 1;
			maxheap(a, 0, l);
		}

		for (int i = 0; i < mInput.length; i++)
			System.out.print(mInput[i] + " ");
	}
	
	public static void heapify(int[] a)
	{
		int length = a.length;
		
		for (int i = length/2; i >= 0; i--)
			maxheap(a, i, length);
	}
	
	public static void maxheap (int[] a, int i, int length)
	{
		int left = i * 2;
		int right = left + 1;
		
		int max = i;
		
		if (left < length && a[left] > a[i])
			i = left;
		if (right < length && a[right] > a[i])
			i = right;
		
		if (max != i)
		{
			exchange(a, max, i);
			maxheap(a, i, length);
		}
	}

	public static void exchange(int[] array, int index1, int index2)
	{
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
}
