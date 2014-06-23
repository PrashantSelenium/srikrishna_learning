package com.questions.hackerrank;

import java.util.HashMap;
import java.util.Map;

public class ReverseTree
{
	static int[] tree;
	static int[] values;
	static int root = -1;
	static Map<Integer, String> level = new HashMap<Integer, String>();
	
	public static void main (String args[])
	{
		values = new int[]{4,8,8,2,2,3,3,4,-1,0,0,10,11,11,12,14, 15, 15, 16, 16, 17, 17, 19, 20};
		
		for (int i = 0; i < values.length; i++)
		{
			if (values[i] == -1)
			{
				root = i;
				level.put(0, root+"");
				break;
			}
		}
		
		for (int i = 0; i < level.size(); i++)
			buildLevelOrder(i);
		
		for (int i = level.size()-1; i >= 0; i--)
			System.out.println(level.get(i));
	}
	
	static void buildLevelOrder(int height)
	{
		String[] nodes = ReverseTree.level.get(height).split(" ");
		int[] currentParents = new int[nodes.length];
		String str = "";
		
		for (int i = 0; i < nodes.length; i++)
			currentParents[i] = Integer.parseInt(nodes[i]);
	
		
		for (int i = 0; i < currentParents.length; i++)
		{
			for (int j =0; j < values.length; j++)
			{
				if (currentParents[i] == values[j])
				{
					if (str.equals(""))
						str = j+" ";
					else
						str = str+j+" ";
				}
			}
		}
		
		if (!str.equals(""))
		{
			level.put(height + 1, str.substring(0, str.length()-1));
		}
	}
}
