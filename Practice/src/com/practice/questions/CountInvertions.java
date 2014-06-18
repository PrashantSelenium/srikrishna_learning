package com.practice.questions;

public class CountInvertions 
{
	static int getInvCount(int arr[], int n)
	{
	  int inv_count = 0;
	  int i, j;
	 
	  for(i = 0; i < n - 1; i++)
	    for(j = i+1; j < n; j++)
	      if(arr[i] > arr[j])
	        inv_count++;
	 
	  return inv_count;
	}
	public static void main(String args[])
	{
	  int arr[] = {1,3,5,8,9,2,6,7,6,8,9};
	  System.out.println(getInvCount(arr, 5));
	  
//	  maxJumps(arr, arr.length - 1);
	}
}
