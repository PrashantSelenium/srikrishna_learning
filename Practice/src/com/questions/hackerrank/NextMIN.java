package com.questions.hackerrank;

import java.util.Arrays;

public class NextMIN
{
	public static void main (String args[])
	{
		int num = 4132;
		
		getNextMin(num);
	}
	
	static void getNextMin(int number)
	{
		int[] array = new int[]{1, 2, 6, 8, 9, 9};
		int[] input = new int[]{1, 8, 6, 2, 9, 9};
		
		for (int i = input.length - 1; i >= 0; i--)
		{
			
			int n = input[i];
			int next = -1;
			for (int j = 0; j < array.length; j++)
			{
				if (n == array[j] && (j + 1 < array.length) && (array[j+1] != array[j]))
				{
					next = array[j + 1];
					break;
				}
			}
			if (next != -1)
			{
				for (int k = 0; k < input.length; k++)
				{
					if (next == input[k])
					{
						next = k;
						break;
					}
				}

				int temp = input[i];
				input[i] = input[next];
				input[next] = temp;
				break;
			}
		}
		
		System.out.println(Arrays.toString(input));
	}
}
