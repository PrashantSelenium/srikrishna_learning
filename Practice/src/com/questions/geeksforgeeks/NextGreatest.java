package com.questions.geeksforgeeks;

import java.util.Stack;

public class NextGreatest
{
	static int[] mArray = {37, 25, 50, 12, 43, 75};
	public static void main (String args[])
	{
		Stack<Integer> mStack = new Stack<Integer>();
		nextGreater(mArray, mStack);
	}
	
	static void nextGreater(int[] array, Stack<Integer> stack)
	{
		for (int i = 0; i < array.length; i++)
		{
			/*if (stack.size() == 0)
			{
				stack.push(array[i]);
			}
			
			else*/
			{
				while (!stack.empty() && stack.peek() < array[i])
				{
					System.out.println(stack.pop() + "\t"+array[i]);
					
					
				}
				stack.push(array[i]);
			}
				
		}
	}
}
