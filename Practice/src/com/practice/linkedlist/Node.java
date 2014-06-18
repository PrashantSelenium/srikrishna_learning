package com.practice.linkedlist;

public class Node
{
	private int data;
	private Node next;
	
	public Node (int data)
	{
		this.data = data;
	}
	
	public Node(int value, Node next)
	{
		this.data = value;
		this.next = next;
	}

	public Node()
	{
	}

	public void setNext (Node next)
	{
		this.next = next;
	}
	
	public Node getNext ()
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
