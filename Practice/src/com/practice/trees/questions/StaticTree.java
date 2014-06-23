package com.practice.trees.questions;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class StaticTree
{
	Structure mObject = null;
	Queue<Structure> mQueue;

	public StaticTree()
	{
		mQueue = new ConcurrentLinkedQueue<StaticTree.Structure>();
	}
	
	public Structure buildTree()
	{
		insert(10);
		insert(15);
		insert(30);
		insert(45);
		insert(3);
		insert(2);
		insert(11);
		insert(60);
		insert(20);
		insert(1);
		insert(4);
		insert(7);
		
		
		return mObject;
	}
	
	public void preOrder(Structure node)
	{
		if (node == null)
			return;
		
		System.out.print(node.value+" ");
		preOrder(node.leftChild);
		preOrder(node.rightChild);
	}
	
	public void inOrder(Structure node)
	{
		if (node == null)
			return;
		
		inOrder(node.leftChild);
		System.out.print(node.value+" ");
		inOrder(node.rightChild);
	}
	
	public void postOrder(Structure node)
	{
		if (node == null)
			return;
		
		postOrder(node.leftChild);
		postOrder(node.rightChild);
		System.out.print(node.value+" ");
	}
	
	public Structure getRootNode()
	{
		return mObject;
	}
	
	public int height(Structure node)
	{
		if (node == null)
			return 0;
		
		int left = height(node.leftChild);
		int right = height (node.rightChild);
		
		return 1 + Math.max(left, right);
	}
	
	void insert (int value)
	{
		if (mObject == null)
		{
			mObject = new Structure();
			mObject.value = value;
			return;
		}
		
		Structure temp = mObject;
		
		Structure newObject = new Structure();
		newObject.value = value;
		
		mQueue.removeAll(mQueue);
		mQueue.add(temp);
		
		while (!mQueue.isEmpty())
		{
			Structure mine = mQueue.poll();
			if (mine == null)
				break;
			
			if (mine.leftChild != null)
				mQueue.add(mine.leftChild);
			if (mine.rightChild != null)
				mQueue.add(mine.rightChild);
			
			if (mine.leftChild == null)
			{
				mine.leftChild = newObject;
				break;
			}
			else if (mine.rightChild == null)
			{
				mine.rightChild = newObject;
				break;
			}
			
		}
	}
	class Structure
	{
		Structure leftChild = null;
		Structure rightChild = null;
		int value = 0;
	}
}