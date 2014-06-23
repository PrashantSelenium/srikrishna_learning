package com.questions.geeksforgeeks;

import java.util.Arrays;

public class HeapSort
{

	static int heapsize;

	public static void main(String args[])
	{
		int[] array = new int[]{50,30,10,60,20,40,70,5, 3, 2, 1, 100, 40, 20, 6, 8, 7};
		sort(array);
		
		System.out.println(Arrays.toString(array));
	}

	static void sort(int[] array)
	{
		buildHeap(array);
		
		heapsize--;
		for (int i = heapsize; i >= 0; i--)
		{
			swap(0, i, array);
			maxheapify(array, 0);
			heapsize = heapsize - 1;
		}
	}

	static void buildHeap(int[] array)
	{
		heapsize = array.length;

		for (int i = (heapsize / 2); i >= 0; i--)
			maxheapify(array, i);
		
		System.out.println(Arrays.toString(array));
	}

	static void maxheapify(int[] array, int parent)
	{
		int left = 2 * parent;
		int right = left + 1;
		int max = parent;

		if (left < heapsize && array[left] > array[max])
			max = left;
		if (right < heapsize && array[right] > array[max])
			max = right;

		if (max != parent)
		{
			swap(max, parent, array);
			maxheapify(array, max);
		}
	}

	static void swap(int arg1, int arg2, int[] array)
	{
		int temp = array[arg1];
		array[arg1] = array[arg2];
		array[arg2] = temp;
	}
}
