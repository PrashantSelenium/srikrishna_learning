package com.practice.linkedlist;

class LinkedListIMPL
{
	private Node start = null;
	
	public void insert (int value)
	{
		if (start == null)
		{
			start = new Node (value, start);
		}
		else
		{
			Node temp = start;
			
			while (temp.getNext() != null)
			{
				temp = temp.getNext();
			}
			
			Node newNode = new Node (value, null);
			temp.setNext(newNode);
		}
	}
	
	public void display ()
	{
		if (start != null)
		{
			Node temp = start;

			while (temp != null)
			{
				System.out.print(temp.getData() + " ");
				temp = temp.getNext();
			}
			
		}
		
		System.out.print(" END\n");
	}
	
	public void display (Node reverse)
	{
		if (reverse == null)
			return;
		
		while (reverse != null)
		{
			System.out.print(reverse.getData() + " ");
			reverse = reverse.getNext();
		}
		
		System.out.print(" END\n");
	}
	
	public void search (int value)
	{
		if (start != null)
		{
			Node temp = start;
			int count = 1;
			
			while (temp != null)
			{
				if (temp.getData() == value)
				{
					System.out.println("Found value "+value+" at node: "+count);
					return;
				}
				count++;
				temp = temp.getNext();
			}
		}
	}
	
	public void insertFirst (int value)
	{
		Node newNode = new Node (value, null);
		
		if (start != null)
			newNode.setNext(start);
		
		start = newNode;
	}
	
	public void insertAt(int position, int value)
	{
		int count = 1;
		
		if (start != null && position >= 1)
		{
			if (position == 1)
			{
				insertFirst(value);
				return;
			}
			
			Node newNode = new Node (value, null);
			Node temp = start;
			Node previous = null;
			
			while (temp != null)
			{
				if (count++ != position)
				{
					previous = temp;
					temp = temp.getNext();
				}
				else
				{
					previous.setNext(newNode);
					newNode.setNext(temp);
				}
			}
			
		}
	}
	
	public int getDataAt(int index)
	{
		int count = 1;
		Node temp = start;
		
		while (temp != null)
		{
			if (count == index)
				return temp.getData();
			else
			{
				count++;
				temp = temp.getNext();
			}
		}
		
		return -1;
	}
	
	public void deleteNode (int position)
	{
		int count = 1; 
		
		if (start != null && position >= 1)
		{
			if (position == 1)
			{
				start = start.getNext();
				return;
			}
			
			Node temp = start;
			Node previous  =  null;
			
			while (temp != null)
			{
				if (count++ != position)
				{
					previous  = temp;
					temp = temp.getNext();
				}
				else
				{
					previous.setNext(temp.getNext());
					return;
				}
			}
		}
	}
	
	public void delete(int value)
	{
		int count = 1;
		Node temp = start;
		Node previous = null;
		
		while (temp != null)
		{
			if (temp.getData() == value && count == 1)
			{
				start = start.getNext();
				return;
			}
			else if (temp.getData() == value)
			{
				previous.setNext(temp.getNext());
				return;
			}
			else
			{
				previous = temp;
				temp = temp.getNext();
				count++;
			}
		}
	}
	
	public void updateValue(int index, int value)
	{
		Node temp = start;
		int count = 1;
		
		while (temp != null)
		{
			if (count++ == index)
			{
				temp.setData(value);
				return;
			}
			else
				temp = temp.getNext();
		}
	}
	
	public int getSize ()
	{
		int count = 0;
		Node temp = start;
		
		if (temp != null)
		{
			while (temp != null)
			{
				temp = temp.getNext();
				count++;
			}
			System.out.println("Size: "+count);
			return count;
		}
		else
		{
			System.out.println("Size: "+count);
			return 0;
		}
	}
	
	public Node getNode (int index)
	{
		int count = 1;
		Node temp = start;
		
		if (temp != null)
		{
			while (temp != null)
			{
				if (count == index)
					return temp;
				else
				{
					temp = temp.getNext();
					count++;
				}
			}
		}
			return null;
		
	}
	public void reverse ()
	{
		Node reverse = null;
		reverse = recursiveReverse(start, reverse);
		
		reverse = loopReverse(start);
		
//		display(reverse);
	}
	
	public Node loopReverse(Node start)
	{
		if (start == null)
			return null;
		
		Node head = start;
		/*Node temp = null;
		Node next = null;
		while (head != null)
		{
			next = head.getNext();
			head.setNext(temp);
			temp = head;
			if (next != null)
				head = next;
			else break;
		}
		
		while (head != null)
		{
			System.out.print(head.getData()+"->");
			head = head.getNext();
		}*/
		
		Node reverse = new Node();
		Node next = null;
		Node temp;
		
		while (head != null)
		{
			next = head.getNext();
			
			reverse.setData(next.getData());
			Node t = new Node();
			t.setNext(next);
			reverse.setNext(t);
			
			temp = head;
			if (next != null)
				head = next;
			else break;
		}
		
		
		return head;
	}
	
	public Node recursiveReverse(Node currentNode, Node reverse)
	{  

		if(currentNode == null)
			return null;
	
		if(currentNode.getNext() == null) 
		{ 
			reverse = currentNode; 
			return reverse;
		}

		reverse = recursiveReverse(currentNode.getNext(), reverse);
		currentNode.getNext().setNext(currentNode);
		currentNode.setNext(null);
		
		return reverse;
	}
	
	public Node reverseByN( int value)
	{
		if (start == null)
			return null;
		
		Node previous, next, first, head, last;
		
		last = first = previous = next = null;
		
		head = start;
		
		boolean mReverse = true;
		
		while (head != null)
		{
			Node temp = head;
			previous = null;
			int count = 0;
			while (head != null && count < value && mReverse)
			{
				next = head.getNext();
				head.setNext(previous);
				previous = head;
				head = next;
				count++;
			}
			
			Node mine = null;
			while (head != null && ! mReverse && count < value)
			{
				mine = head;
				head = head.getNext();
				count++;
			}
			
//			if (mReverse)
			{
				if (first == null)
				{
					first = previous;
				}
				else
				{
					last.setNext(previous);
				}
				
				if (!mReverse)
				{
					last.setNext(temp);
					last = mine;
				}
				else
				{
					last = temp;
				}
				
				
			}
			
			mReverse = !mReverse;
			
			
		}
		
		return first;
	}
}

public class LinkedList
{
	public static void main (String args[])
	{
		
		// list Adding
			/*LinkedListIMPL listOne = new LinkedListIMPL();
			listOne.insert(5);
			listOne.insert(6);
			listOne.insert(3);
			
			LinkedListIMPL listTwo = new LinkedListIMPL();
			listTwo.insert(2);
			listTwo.insert(4);
			listTwo.insert(8);
			listTwo.insert(9);
			
			LinkedListIMPL listAns = new LinkedListIMPL();
			
			int sizeOne = listOne.getSize();
			int sizeTwo = listTwo.getSize();
			
			int valueOne = 0, valueTwo = 0;
			
			for (int i = sizeOne; i > 0; i--)
				valueOne = valueOne * 10 + listOne.getDataAt(i);
			
			for (int i = sizeTwo; i > 0; i--)
				valueTwo = valueTwo * 10 + listTwo.getDataAt(i);
			
			int sum = valueOne + valueTwo;
			
			
			
			while (sum/10 > 0)
			{
				listAns.insert(sum % 10);
				sum = sum/10;
			}
			
			listAns.insert(sum);
			
			listAns.display();*/
		
		// list Adding
		
		LinkedListIMPL list = new LinkedListIMPL();
		for (int i = 1; i <= 23; i++)
			list.insert(i);
		
//		list.display();
		
		Node n = list.reverseByN(5);
		
		System.out.println("hello");
		while (n != null)
		{
			System.out.print(n.getData()+" ");
			n = n.getNext();
		}
		/*list.search(10);
		
		list.insertFirst(12);
		list.display();
		
//		list.delete(5);
//		list.display();
		
		list.insertAt(4, 99);
		list.insertAt(1, 100);
		list.display();
		
		list.getSize();*/
		
//		list.reverse();
//		list.display();
	}
}
