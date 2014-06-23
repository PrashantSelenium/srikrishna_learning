package com.questions.geeksforgeeks;

public class LinkedList
{
	static LinkedList l;
	public static void main (String args[])
	{
		l = new LinkedList();
		LinkedList.Node list1 = l.new Node();
		LinkedList.Node start1 = list1;
		for (int i = 1; i < 10; i = i+2)
		{
			list1.setData(i);
			list1.setNext(l.new Node());
			list1 = list1.getNext();
		}
		list1.setData(24);
		
		LinkedList.Node list2 = l.new Node();
		LinkedList.Node start2 = list2;
		for (int i = 0; i < 20; i = i+2)
		{
			list2.setData(i);
			list2.setNext(l.new Node());
			list2 = list2.getNext();
		}
		list2.setData(27);
		
		
		display(start1);
		System.out.println("");
		display(start2);
		
		Node sortNode = mergeList(start1, start2);
		
		System.out.println("");
		display(sortNode);
	}
	
	private static void display(Node node)
	{
		if (node == null)
			return;
		
		while (node != null)
		{
			System.out.print(node.getData() + " ");
			node = node.getNext();
		}
	}
	private static Node mergeList(Node list1, Node list2)
	{
		if (list1 == null || list2 == null)
			return null;
			
		Node temp = l.new Node();
		Node tempStart = temp;
		while (list1 != null || list2 != null)
		{
			int value = 0;
			if (list1 != null && list2 != null)
			{
				if (list1.getData() < list2.getData())
				{
					value = list1.getData();
					list1 = list1.getNext();
				}
				else
				{
					value = list2.getData();
					list2 = list2.getNext();
				}
			}
			else if (list1 != null)
			{
				value = list1.getData();
				list1 = list1.getNext();
			}
			else if (list2 != null)
			{
				value = list2.getData();
				list2 = list2.getNext();
			}
			
			if (temp != null)
			{
				temp.setData(value);
				temp.setNext(l.new Node());
				temp = temp.getNext();
			}
		}
		
		return tempStart;
	}
	
	class Node 
	{
		Node node;
		int data;
		
		void setData(int data)
		{
			this.data = data;
		}
		
		int getData()
		{
			return this.data;
		}
		
		void setNext(Node node)
		{
			this.node = node;
		}
		
		Node getNext()
		{
			return this.node;
		}
	}
}
