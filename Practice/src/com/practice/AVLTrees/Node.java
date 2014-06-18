package com.practice.AVLTrees;


public class Node
{

	private int data;
	private int bf;
	private Node left;
	private Node right;
	private Node parent;
	
	public Node ()
	{
		
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
	
	public void setbf (int bf)
	{
		this.bf = bf;
	}
	
	public int getbf()
	{
		return bf;
	}

	public void setLeft (Node next)
	{
		this.left = next;
	}
	
	public void setRight(Node right)
	{
		this.right = right;
	}
	
	public void setParent (Node parent)
	{
		this.parent = parent;
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
	
	public Node getParent ()
	{
		return parent;
	}
	
	public int getData ()
	{
		return data;
	}
}
