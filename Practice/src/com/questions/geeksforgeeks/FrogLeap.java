package com.questions.geeksforgeeks;

public class FrogLeap
{
	public static void main(String args[])
	{
		int start = 1, end, rocks;
		
		rocks = 4;
		end = rocks + 1;
		
		jump(start, end, "1 ");
	}
	
	static void jump(int start, int end, String str)
	{
		if (start == end)
		{
			System.out.println(str);
			return;
		}
		else if (start < end)
		{
			jump (start + 1, end, str + (start + 1) + " ");
			jump (start + 2, end, str + (start + 2) + " ");
		}
	}
}
