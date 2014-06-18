package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class ReverseTree
{
	static String line = null;
	static int testCases = 0;
	static  int[] values = null, tree = null;
	static int parent = -1;
	static boolean[] isParent;
	static ArrayList<String> list = new ArrayList<String>();
	
	public static void main(String args[])
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		try
		{
			line = br.readLine();
			testCases = Integer.parseInt(line);
			values = new int[testCases];
			
			String[] input = br.readLine().split(" ");
			for (int i = 0; i < input.length; i++)
			{
				values[i] = Integer.parseInt(input[i]);
				
				if (values[i] == -1)
					parent = i;
			}
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		createTree(values, parent);
		
		System.out.println(Arrays.toString(tree));
//		System.out.println(Arrays.toString(isParent));
		printTree(tree, isParent);
	}
	
	static void printTree(int[] tree, boolean[] isParent)
	{
		int level = 0;
		int maxChildren = 0;
		int[] skipCounter = new int[isParent.length];
		
		int falseCounter = 0;
		for (int i = 0; i < isParent.length; i++)
		{
			if (!isParent[i])
				falseCounter++;
			
			skipCounter[i] = falseCounter;
			
			System.out.println("I = "+i+" Parent: "+isParent[i]+" Counter"+falseCounter);
		}
		
		String str = "";
		int visitedNodes = 0;
		int currentSkipper = skipCounter[0];
		for (int i = 0; i < tree.length; i++)
		{
			maxChildren = (int) Math.pow(2,  level);
			
//			System.out.println("I = "+i+" = "+ (maxChildren  - (currentSkipper * 2)));
			if (visitedNodes++ < (maxChildren - (currentSkipper * 2)))
			{
				str = str + tree[i]+ " ";
			}
			
			if (visitedNodes >= (maxChildren - (currentSkipper * 2)))
			{
				str = str + "\n";
				visitedNodes = 0;
				level++;
				
				currentSkipper  = skipCounter[i];
				
			}
		}
		
		System.out.println(str);
	}
	static void createTree(int[] values,int parent)
	{
		int elementsFilled = 0;
		tree = new int[values.length];
		isParent = new boolean[values.length];
		for (int i = 0; i < tree.length; i++)
			tree[i] = -1;
		
		tree[0] = parent;
		elementsFilled++;
		
		int counter = 1;
		int power = (int) Math.pow(2, counter);
		
		for (int i = 0; i < tree.length; i++)
		{
			int currentparent = tree[i];
			power = (int) Math.pow(2, counter);
			
			if (currentparent == 23)
				System.out.println("Searching 23");
			for (int j = 0; j < values.length; j++)
			{
				if (currentparent == values[j] && elementsFilled < tree.length)
				{
					if (currentparent == 23)
						System.out.println("Found");
					tree[elementsFilled++] = j;
					isParent[i] = true;
				}
			}
			
		}
	}
}
