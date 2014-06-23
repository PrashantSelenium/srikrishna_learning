package com.practice.trees.questions;

public class NTile
{
	static Node mStart;
	
	public static void main(String args[])
	{
		mStart = new Node(new int[][]{{1,2,3},{4,5,6},{7,0,8}});
		Node temp = mStart;
		solvePuzzle(temp);
	}
	
	static boolean solvePuzzle(Node node)
	{
		if (node == null)
			return false;
		
		if (isSolved(node))
			return true;
		
		Node newNode = new Node(node.value);
		newNode.parent = node;
		
		return false;
	}
	
	static boolean isSolved(Node node)
	{
		for (int i = 0; i < mStart.value.length; i++)
		{
			for (int j = 0; j < mStart.value[i].length; i++)
			{
				if (mStart.value[i][j] != node.value[i][j])
					return false;
			}
		}
		return true;	
	}
}

class Node
{
	Node parent;
	int[][] value;
	
	Node (int[][] input)
	{
		value = input;
	}
}
