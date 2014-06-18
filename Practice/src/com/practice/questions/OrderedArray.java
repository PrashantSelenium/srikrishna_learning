package com.practice.questions;

public class OrderedArray 
{
	int mElements[];
	public OrderedArray()
	{
		mElements = new int[10];
	}
	
	public boolean insert(int value)
	{
		for (int i = 0; i < 10; i++)
		{
			if (mElements[i] == 0)
			{
				mElements[i] = value;
				return true;
			}
		}
		return false;
	}
	
	public void binarySort()
	{
		
	}
}
