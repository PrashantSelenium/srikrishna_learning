package com.questions.sotong;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class GalaxyPang
{
	static LinkedList<Integer> list = new LinkedList<Integer>();

	public static void main(String args[]) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int window, step;
		int total;
		int test_case = 1;
		while (T-- > 0)
		{
			window = sc.nextInt();
			step = sc.nextInt();
			total = window + step;
			list.clear();

			for (int i = 0; i < total; i++)
				list.offer(sc.nextInt());

			System.out.println("Case #"+(test_case++));
			System.out.println(getAns(window, step));
		}

	}

	static int getAns(int window, int step)
	{
		boolean isIdentical = true;
		int end = 0;
		
		while (isIdentical && step > 0)
		{
			isIdentical = false;
			for (int i = 1; i < window; i++)
			{
				end = i;
				if (list.get(i) == list.get(i - 1))
				{
					list.set(i - 1, list.get(i) + 1);
					list.remove(i);
					isIdentical = true;
					step--;
				}
			}
//			print();
		}
		
		int max = Integer.MIN_VALUE;
	
		
		for (int i = 0; i < end+1; i++)
		{
			
			if (max < list.get(i) && list.size() > i)
			{
				max = list.get(i);
			}
		}
		
		return max;
	}

	static void print()
	{
		System.out.println("");
		for (int i = 0; i < list.size(); i++)
			System.out.print(list.get(i) + " ");
		System.out.println("");
	}
}
