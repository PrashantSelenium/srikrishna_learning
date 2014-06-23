package com.practice.Nodes;


public class TreeNodes
{
	private int data;
	private TreeNodes left;
	private TreeNodes right;
	
	public TreeNodes (int data)
	{
		this.data = data;
	}
	
	public TreeNodes(int value, TreeNodes left, TreeNodes right)
	{
		this.data = value;
		this.left = left;
		this.right = right;
	}

	public void setLeft (TreeNodes next)
	{
		this.left = next;
	}
	
	public void setRight(TreeNodes right)
	{
		this.right = right;
	}
	
	public void setData(int data)
	{
		this.data = data;
	}
	
	public TreeNodes getleft ()
	{
		return left;
	}
	
	public TreeNodes getRight ()
	{
		return right;
	}
	
	public int getData ()
	{
		return data;
	}

}
