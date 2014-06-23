package com.practice.trees.questions;

public class StaticList
{
	SingleList mSingle;
	DoubleList mDouble;

	public SingleList getSingleList()
	{
		return mSingle;
	}
	
	public DoubleList getDoubleList()
	{
		return mDouble;
	}
	
	public SingleList singleInsert(int value)
	{
		if (mSingle == null)
		{
			mSingle = new SingleList();
			mSingle.value = value;
		}
		else
		{
			SingleList newNode = new SingleList();
			newNode.value = value;
			
			SingleList temp = mSingle;
			
			while (temp.next != null)
				temp = temp.next;
			
			temp.next = newNode;
		}
		
		return mSingle;
	}
	public void doubleInsert(int value)
	{
		if (mDouble == null)
		{
			mDouble = new DoubleList();
			mDouble.value = value;
		}
		else
		{
			DoubleList newNode = new DoubleList();
			newNode.value = value;
			
			DoubleList temp = mDouble;
			DoubleList parent = null;
			
			while (temp.next != null)
			{
				parent = temp;
				temp = temp.next;
			}
			
			temp.previous = parent;
			temp.next = newNode;
		}
	}
	
	public void printList(Object o)
	{
		if (o == mSingle)
		{
			SingleList temp = mSingle;
			
			while (temp != null)
			{
				System.out.print(temp.value+" ");
				temp = temp.next;
			}
		}
		else
		{
			
		}
	}
	class SingleList
	{
		SingleList next = null;
		int value;
	}
	class DoubleList
	{
		DoubleList next = null;
		DoubleList previous = null;
		int value;
	}
}
