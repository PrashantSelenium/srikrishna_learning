package com.practice.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.practice.AVLTrees.Node;

public class TreeImpl
{
	Node start = null;
	Lock lock = new ReentrantLock();
	
	

	public void insert(int data)
	{
		Node mNewNode = new Node(data);

		if (start == null)
		{
			start = mNewNode;
			return;
		}

		Node temp = start;
		
		while (true)
		{
			if (mNewNode.getData() <= temp.getData())
			{
				if (temp.getleft() == null)
				{
					temp.setLeft(mNewNode);
					return;
				}
				temp = temp.getleft();
			}
			else
			{
				if (temp.getRight() == null)
				{
					temp.setRight(mNewNode);
					return;
				}
				temp = temp.getRight();
			}
		}
	}
	
	public void delete(int value)
	{
		Node temp = start, searchNode = null, parent = null;
		
		if (temp == null)
			return;
		
		// Search
			while (temp != null)
			{
				if (value < temp.getData())
				{
					if (temp.getleft() != null)
					{
						parent = temp;
						
						temp = temp.getleft();
						continue;
					}
					else
					{
						System.out.println("not found "+value);
						break;
					}
				}
				else if (value > temp.getData())
				{
					if (temp.getRight() != null)
					{
						parent = temp;
						
						temp = temp.getRight();
						continue;
					}
					else
					{
						System.out.println("not found "+value);
						break;
					}
				}
				else
				{
					System.out.println("found "+value);
					searchNode = temp;
					break;
				}
			}
		// Search
		
		if (searchNode != null)
		{
			if (searchNode.getleft() == null && searchNode.getRight() == null) // leaf nodes
			{
				if (parent.getleft() != null)
					parent.setLeft(null);
				else if (parent.getRight() != null)
					parent.setRight(null);
			}
			
			else if (searchNode.getleft() == null) // No left child
			{
				if (parent.getleft().getData() == value)
					parent.setLeft(searchNode.getRight());
				else if (parent.getRight().getData() == value)
					parent.setRight(searchNode.getRight());
			}
			
			else if (searchNode.getRight() == null)// No right child
			{
				if (parent.getleft().getData() == value)
					parent.setLeft(searchNode.getleft());
				else if (parent.getRight().getData() == value)
					parent.setRight(searchNode.getleft());
			}
			
			else // Have both left and right 
			{
				Node successor = getSuccessor(searchNode.getRight());
				
				if (successor != null)
				{
					System.out.println("Successor of "+searchNode.getData() +" is "+successor.getData());
					
					if (parent.getleft().getData() == value)
					{
						parent.setLeft(successor);
						searchNode.getRight().setLeft(successor.getRight());
						successor.setLeft(searchNode.getleft());
						
						if (successor != searchNode.getRight())// Check if the right of search and successor of search are equal, stack over flow
							successor.setRight(searchNode.getRight());
					}
					else if (parent.getRight().getData() == value)
					{
						parent.setRight(successor);
						searchNode.getRight().setLeft(successor.getRight());
						successor.setLeft(searchNode.getleft());
						
						if (successor != searchNode.getRight())// Check if the right of search and successor of search are equal, stack over flow
							successor.setRight(searchNode.getRight());
					}
				}
			}
		}
	}
	
	public void search (int value)
	{
		Node temp = start;
		Node node = search (value, temp);
		
		if (node != null)
			System.out.println(node.getData());
		else
			System.out.println("null");
	}
	public Node search (int value, Node node)
	{
		if (node == null)
			return null;
		
		if (value < node.getData())
			node = search (value, node.getleft());
		else if (value > node.getData())
			node = search (value, node.getRight());
		else
			return node;
		
		return node;
	}
	
	public Node getSuccessor (Node node)
	{
		if (node.getleft() == null)
			return node;
		
		return getSuccessor(node.getleft());
	}

	public void BFS()
	{
		Node temp = start;

		if (temp == null)
			return;

		System.out.print("BFS: ");
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.clear();
		queue.add(temp);

		while (!queue.isEmpty())
		{
			Node n = queue.remove();
			System.out.print(n.getData() + " ");

			if (n.getleft() != null)
				queue.add(n.getleft());
			if (n.getRight() != null)
				queue.add(n.getRight());
		}
	}

	public void preorder()
	{
		System.out.print("Pre Order: ");
		Node temp = start;

		if (temp == null)
			return;

		preorder(temp);
	}

	public void inorder()
	{
		System.out.print("In Order: ");
		Node temp = start;

		if (temp == null)
			return;

		inorder(temp);
	}

	public void postorder()
	{
		System.out.print("Post Order: ");
		Node temp = start;

		if (temp == null)
			return;

		postorder(temp);
	}
	
	public void myorder ()
	{
		Node temp = start;
		
		if (temp == null)
			return;
		
		myorder(temp);
	}
	
	public void getMirror()
	{
		Node temp = start;
		
		if (temp == null)
			return;
		
		getMirror(temp);
	}
	
	public int getHeight()
	{
		Node temp = start;
		
		if (temp == null)
			return -1;
		
		return getHeight(temp); 
	}

	private void preorder(Node node)
	{
		if (node == null)
			return;
		
		System.out.print(node.getData()+ " ");
		preorder(node.getleft());
		preorder(node.getRight());
	}

	private void inorder(Node node)
	{
		if (node == null)
			return;
		
		inorder(node.getleft());
		System.out.print(node.getData()+ " ");
		inorder(node.getRight());
	}

	private void postorder(Node node)
	{
		if (node == null)
			return;
		
		postorder(node.getleft());
		postorder(node.getRight());
		System.out.print(node.getData()+ " ");
	}

	private void myorder (Node node)
	{
		if (node == null)
			return;
		
		
		myorder(node.getRight());
		System.out.print(node.getData()+ " ");
		myorder(node.getleft());
		
	}
	
	private void getMirror (Node node)
	{
		/*if (node == null)
			return;
		System.out.print(node.getData()+" ");
		
		Node temp = node.getleft();
		Node temp1 = node.getRight();
		
		
		node.setLeft(temp1);
		node.setRight(temp);
		
		getMirror(node.getleft());
		getMirror(node.getRight());*/
		
		if (node == null)
			return;
		
		System.out.print(node.getData()+" ");
		getMirror(node.getRight());
		getMirror(node.getleft());
	}
	
	private void getNextRight(Node node)
	{
		System.out.print(node.getData()+" ");
	}
	
	private int getHeight(Node t)
	{
		if (t == null)
			return 0;
		
		int heightLeft = getHeight(t.getleft());
		int heightRight = getHeight(t.getRight());
		
		if (heightLeft > heightRight)
			return heightLeft + 1;
		else
			return heightRight + 1;
	}
	public void newLine()
	{
		System.out.print("\n \n");
	}
	
	public void maxsum()
	{
		List l = new List();
		System.out.println("Max sum: "+maxsum(start, l));
	}
	/*public List maxsum(Node node, List list)
	{
		if (node == null)
			return list;
		
		
		List left = maxsum(node.getleft(), list);
		List right = maxsum(node.getRight(), list);
		
		if (left.sum > right.sum)
		{
			list.sum =  node.getData() + left.sum;
			list.data = node;
		}
		else
		{
			return node.getData() + right;
		}
	}*/
	
	public int maxsum(Node node, List list)
	{
		if (node == null)
			return 0;
		
		
		int left = maxsum(node.getleft(), list);
		int right = maxsum(node.getRight(), list);
		
		if (left > right)
		{
			System.out.println(node.getData());
			return node.getData() + left;
		}
		else
		{
			System.out.println(node.getData());
			return node.getData() + right;
		}
	}
	
	class List
	{
		List next;
		int sum = 0;
		Node data;
	}

}
