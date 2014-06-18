package com.java.testQuestions;

import java.util.Arrays;


public class ArrayRotation
{
	public static void main(String args[])
	{
		int[] input = new int[]
		{ 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		
		int rotateBy = 2;
		
		rightRotate(input, input.length - rotateBy, input.length);
		System.out.println(Arrays.toString(input));

	}

	static void rightRotate(int arr[], int d, int n)
	{
		int i, j, k, temp;
		for (i = 0; i < gcd(d, n); i++)
		{
			/* move i-th values of blocks */
			temp = arr[i];
			j = i;
			while (true)
			{
				k = j + d;
				if (k >= n)
					k = k - n;
				if (k == i)
					break;
				arr[j] = arr[k];
				j = k;
			}
			arr[j] = temp;
		}
	}
	
	static int gcd(int a, int b)
	{
		if (b == 0)
			return a;
		else
			return gcd(b, a % b);
	}

}
