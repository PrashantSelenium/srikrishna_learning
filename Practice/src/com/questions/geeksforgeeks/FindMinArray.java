package com.questions.geeksforgeeks;

public class FindMinArray {
	
	int findmin (int a[])
	{
		
		return binsearch(a, 0, a.length);
	}
	
	int binsearch (int a[], int start, int end)
	{
		if  (a[start] < a[end])
			return a[start];
		else
		{
			int mid = (start + end ) /2;
			
			/*if (a[mid] < a[end])
			{
				mid = (start+mid)/2;
				if (a[mid] < )
			}*/
			
		}
		return 0;
	}
	
	public static void main (String args[])
	{
		
		int a[] = {5, 6, 1, 2, 3, 4};
		new FindMinArray().findmin(a);
	}
}
