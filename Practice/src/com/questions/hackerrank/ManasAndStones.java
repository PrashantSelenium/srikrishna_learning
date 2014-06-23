package com.questions.hackerrank;

import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ManasAndStones
{
	public static void main (String args[]) throws IOException
	{
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int steps = -1;
		int a = -1, b = -1;
		for (int i = 0; i < T; i++)
		{
			steps = sc.nextInt();
			a = sc.nextInt();
			b = sc.nextInt();
			
			getAns(steps, a, b);
//			String str =  getNthStep(steps, a, b);
//			System.out.println(str.substring(0, str.length()-1));
		}
	}
	
	static void getAns(int steps, int a, int b)
	{
		if (a > b)
		{
			a = a ^ b;
			b = a ^ b;
			a = a ^ b;
		}
		int min = (steps - 1) * a;
		int max = (steps - 1) * b;
		
		String str = min + " ";

		while (min < max)
		{
			min += Math.abs(b - a);
			str += min + " ";
		}
		
		System.out.println(str.substring(0, str.length() - 1));
	}
	
	static String getNthStep(int steps, int a, int b)
	{
		Set<Integer> sortedSet = new TreeSet<Integer> ();
		
		int maxElements = (int) (Math.pow(2, (double)steps) - 1);
		int[] stepsArray = new int[maxElements];
		stepsArray[0] = 0;
		int leftNodes = (int) (Math.pow(2, (double) steps-1) - 1);
		
		for (int i = 0; i < leftNodes; i++)
		{
			stepsArray[(2 * i) + 1] = stepsArray[i] + a;
			stepsArray[(2 * i) + 2] = stepsArray[i] + b;
		}
		
		String str = "";
		for (int i = leftNodes; i < stepsArray.length; i++)
		{
			if (sortedSet.add(stepsArray[i]))
				str += stepsArray[i]+" ";
		}
		
		return str;
	}
}
