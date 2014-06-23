package com.questions.geeksforgeeks;

import java.util.Arrays;


public class Merge
{
	
	public static void main (String args[])
	{
		int[] array = new int[]{50,30,10,60, 30, 2, 3, 10, 100, 6, 8, 7,20,40,70,5, 3, 2, 1, 100, 40, 20, 6, 8, 7,1};
		divide(array, 0, array.length - 1);
		
		System.out.println(Arrays.toString(array));
	}
	public static void divide(int[] array, int left, int right)
	{
		int mid = left + ((right - left)/2);
		
		if (left < right)
		{
			divide (array, left, mid);
			divide (array, mid + 1, right);
			
			combine(array, left, mid + 1, right);
		}	
	}

	public static void combine(int[] array, int left, int mid, int right)
	{
		int leftstart = left;
		int leftend = mid - 1;
		int rightstart = mid;
		int rightend = right;
		
		int[] tempArray = new int[rightend - leftstart + 1];
		int count = 0;
		while (leftstart <= leftend && rightstart <= rightend)
		{
			if (array[leftstart] < array[rightstart])
				tempArray[count++] = array[leftstart++];
			else
				tempArray[count++] = array[rightstart++];
		}
		
		while (leftstart <= leftend)
			tempArray[count++] = array[leftstart++];
		while (rightstart <= rightend)
			tempArray[count++] = array[rightstart++];
		
		leftstart = left;
		for (int i = 0; i < tempArray.length; i++, leftstart++)
			array[leftstart] = tempArray[i];
	}
	
	/*boolean isMirror(Node tree1, Node tree2)
	{
		if (tree1 != null && tree2 != null )
		{
			if (tree1.getleft() != null && tree2.getRight() != null && tree2.getleft() != null && tree1.getRight() != null)
			{
				if (tree1.getleft() == tree2.getRight() && tree1.getRight() == tree2.getleft())
					return true;
				else 
					return false;
			}
			else if (tree1.getleft() != null && tree2.getRight() != null)
			{
				if (tree1.getleft() == tree2.getRight() )
					return true;
				else
					return false;
			}
			else if (tree2.getleft() != null && tree1.getRight() != null)
			{
				if (tree2.getleft() == tree1.getRight() )
					return true;
				else
					return false;
			}
			else if (tree1.getleft() == null && tree2.getRight() == null && tree2.getleft() == null && tree1.getRight() == null)
			{
				return true;
			}
			
			if (!isMirror(tree1.getleft(), tree2.getRight()))
				return false;
			if (!isMirror(tree1.getRight(), tree2.getleft()))
				return false;
		}
		else if (tree1 == null && tree2 == null)
			return true;
		else 
			return false;
		return false;
		
	}*/
}
