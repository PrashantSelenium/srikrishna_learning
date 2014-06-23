package com.questions.sotong;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class ProcessingManagement
{
	public static void main (String args[]) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int N;
		
		int length[] = new int[5001];
		int width[] =  new int[5001];
		while (T-- > 0)
		{
			N = sc.nextInt();
			
			for (int i = 0; i < N; i++)
			{
				length[i] = sc.nextInt();
				width[i] = sc.nextInt();
			}
			
			System.out.println((getMinlength(length, width, N)+" "+ getMinwidth(length, width, N)));
		}
	}
	
	static int getMinlength(int[] length, int[] width, int N)
	{
		int[] temp = new int[N];
		int time = 1;
		
		for (int i = 0; i < N; i++)
			temp[i] = length[i];
		
		Arrays.sort(length, 0, N);
		int min = length[0];
		int previousID = -1;
		
		for (int i = 0; i < N; i++)
		{
			min = length[i];
			int id = 0;
			
			for (int j = 0; j < N; j++)
				if (temp[j] == min)
				{
					id = j;
					break;
				}
			
			if (id != -1 && previousID != -1 && width[id] < width[previousID])
				++time;
			previousID = id;
		}
		
		return time;
	}
	
	static int getMinwidth(int[] length, int[] width, int N)
	{
		int[] temp = new int[N];
		int time = 1;
		
		for (int i = 0; i < N; i++)
			temp[i] = width[i];
		
		Arrays.sort(width, 0, N);
		
		System.out.println(Arrays.toString(width));
		System.out.println(Arrays.toString(temp));
		
		int min = width[0];
		int previousID = -1;
		
		for (int i = 0; i < N; i++)
		{
			min = width[i];
			int id = 0;
			
			for (int j = 0; j < N; j++)
				if (temp[j] == min)
				{
					id = j;
					break;
				}
			
			if (id != -1 && previousID != -1 && length[id] < length[previousID])
			{
				System.out.println("Id = "+id);
				++time;
			}
			previousID = id;
		}
		
		return time;
	}
}	
