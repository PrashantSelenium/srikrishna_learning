package com.practice.questions;

public class NTile
{
	static Node start, temp;
	static NTile tile = new NTile();
	static final int[] ANSWER = new int[]{1,2,3,4,5,6,7,8,0};
	public static void main (String args[])
	{
		temp = start = tile.new Node(new int[]{1,2,3,4,5,6,7,0,8});
		
		startGame(temp);
	}
	
	static void startGame(Node node)
	{
		if (temp == null)
			return;
		
		while (!node.equals(ANSWER))
		{
			
		}
		
	}
	
	class Node
	{
		Node parent;
		Node next;
		int[] values;
		
		public Node(int[] input)
		{
			values = input;
		}
	}
}
