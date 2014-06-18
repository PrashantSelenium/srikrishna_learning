package com.practice.questions;


public class RepeatNumber 
{
	static int[] mInput = {2,2,2,3,3,3,3,4,4,4};
	static int[] mCount = {1,1,1};
	
	public static void main (String args[])
	{
		for (int i = 1, j = 0; i < mInput.length; i++)
		{
			if (mInput[i] == mInput[i - 1])
			{
				mCount[j]++;
			}
			else
				j++;
		}
		
		System.out.println(mCount[0]+"\t"+mCount[1]+"\t"+mCount[2]);
	}
}
