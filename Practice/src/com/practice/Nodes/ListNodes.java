package com.practice.Nodes;


public class ListNodes
{
	private int data;
	private ListNodes next;
	
	public ListNodes (int data)
	{
		this.data = data;
	}
	
	public ListNodes(int value, ListNodes next)
	{
		this.data = value;
		this.next = next;
	}

	public ListNodes()
	{
	}

	public void setNext (ListNodes next)
	{
		this.next = next;
	}
	
	public ListNodes getNext ()
	{
		return next;
	}
	
	public int getData ()
	{
		return data;
	}
	
	public void setData(int data)
	{
		this.data = data;
	}

}
