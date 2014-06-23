package com.questions.geeksforgeeks;

public class Linked {

	Node start,temp, cache;
	int length = 1;
	Linked ()
	{
		start = new Node();
		start.value = 10;
		start.next = null;
		start.parent = null;
		cache = temp = start;
	}
	
	public void insert (int value)
	{
		length++;
		Node cache = start;
		start.next = new Node();
		start.next.value= value;
		start.next.parent = cache;
		start = start.next;
	}
	
	public void print ()
	{
		if (temp == null)
			return;
		else 
		{
			System.out.println(temp.value);
			temp = temp.next;
			print();
		}
	}
	
	public void reverseprint()
	{
		while (start != null)
		{
			System.out.println(start.value);
			if (start.parent == null)
				break;
			start = start.parent;
		}
	}
	
	public void sort()
	{
		Node i,j;
		System.out.println("..................");
		for (; start != null; start = start.next)
		{
			System.out.println("Start: "+start.value);
			for (j = start.next; j != null; j = j.next)
			{
				System.out.println("Start: "+j.value);
				if (start.value < j.value)
				{
					Node temp;
					temp = start;
					
					start.next = j.next;
					start.parent = j.parent;
					
					j.next = temp.next;
					j.parent = temp.parent;
				}
				
			}
		}
		
		start = start.parent;
		System.out.println(start);
		
	}
	
	public void printnew (Node i)
	{
		System.out.println(i.parent);
	}
	
	public void getfirst()
	{
		if (start.parent == null)
			return;
		else
		{
			if (start.parent == null)
				return;
			else
				start = start.parent;
		}
		getfirst();
	}
	public static void main (String args[])
	{
		Linked linked = new Linked();
		linked.insert(11);
		linked.insert(5);
		linked.insert(40);
		linked.insert(95);
		linked.print();
		System.out.println("*************");
		linked.reverseprint();
		System.out.println("*************");
		//linked.getfirst();
		linked.sort();
		//linked.sort();
	}
	
	static class Node
	{
		Node next;
		Node parent;
		int value;
	}
}