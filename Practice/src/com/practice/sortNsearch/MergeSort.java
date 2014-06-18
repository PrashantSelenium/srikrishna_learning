package com.practice.sortNsearch;

public class MergeSort 
{
	public static void main (String args[])
	{
		int[] mArray = new int[] {20,10,40,30,60,50,80,70,100,90};
		divide(mArray, 0, mArray.length-1);
		
		for (int i = 0; i< mArray.length; i++)
			System.out.print(mArray[i]+" ");
	}
	
	public static void divide(int[] a, int left, int right)
	{
		int mid = left + ((right - left) / 2);
		
		if (left < right)
		{
			divide (a, left, mid);
			divide (a, mid+1, right);
			combine(a, left, mid+1, right);
		}
	}
	
	public static void combine(int[] a, int left, int mid, int right)
	{
		int leftstart, leftend, rightstart, rightend;
		leftstart = left;
		leftend = mid - 1;
		rightstart = mid;
		rightend = right;
		
		int mTemp[] = new int[right - left + 1];
		int count = 0;
		
		while (leftstart <= leftend && rightstart <= rightend)
		{
			if (a[leftstart] < a[rightstart])
				mTemp[count++] = a[leftstart++];
			else 
				mTemp[count++] = a[rightstart++];
		}
		
		while (leftstart <= leftend)
			mTemp[count++] = a[leftstart++];
		
		while (rightstart <= rightend)
			mTemp[count++] = a[rightstart++];
		
		
		for(int i = left, j = 0; j <mTemp.length; i++, j++)
		{
			a[i] = mTemp[j];
		}
	}
}
