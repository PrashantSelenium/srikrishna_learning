package com.questions.geeksforgeeks;

public class ReverseLinkedList
{
	public static void main (String args[])
	{
		Node start = new Node();
		start.data = 1;
		
		Node temp = start;
		temp.next = new Node();
		temp = temp.next;
		temp.data = 2;
		
		temp.next = new Node();
		temp = temp.next;
		temp.data = 3;
		
		temp.next = new Node();
		temp = temp.next;
		temp.data = 4;
		
		temp.next = new Node();
		temp = temp.next;
		temp.data = 5;
		
		temp.next = new Node();
		temp = temp.next;
		temp.data = 6;
		
		temp.next = new Node();
		temp = temp.next;
		temp.data = 7;
		
		temp.next = new Node();
		temp = temp.next;
		temp.data = 8;
		
		temp.next = new Node();
		temp = temp.next;
		temp.data = 9;
		
		temp.next = new Node();
		temp = temp.next;
		temp.data = 10;
		
		Node t = start;
		
		while (t != null)
		{
			System.out.print(t.data+"->");
			t = t.next;
		}
		
		Node head = start;
		Node next;
		t = null;
		
		boolean boo = false;
		while (head != null)
		{
			next = head.next;
			head.next = t;
			t = head;
			head = next;
			
			if (head != null)
				start = head;
		}
	System.out.println("");	
	
	t = start;
		
		while (t != null)
		{
			System.out.print(t.data+"->");
			t = t.next;
		}
		
		
	}
	
	private static class Node
	{
		int data;
		Node next;
	}
}
