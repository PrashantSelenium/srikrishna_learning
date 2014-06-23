package com.practice.trees.levelorder;

public class Node
{
	private int data;
	private Node left;
	private Node right;
	private Node getNextRight;
	
	public Node getGetNextRight()
	{
		return getNextRight;
	}

	public void setGetNextRight(Node getNextRight)
	{
		this.getNextRight = getNextRight;
	}

	public Node (int data)
	{
		this.data = data;
	}
	
	public Node(int value, Node left, Node right)
	{
		this.data = value;
		this.left = left;
		this.right = right;
	}

	public void setLeft (Node next)
	{
		this.left = next;
	}
	
	public void setRight(Node right)
	{
		this.right = right;
	}
	
	public void setData(int data)
	{
		this.data = data;
	}
	
	public Node getleft ()
	{
		return left;
	}
	
	public Node getRight ()
	{
		return right;
	}
	
	public int getData ()
	{
		return data;
	}
}
