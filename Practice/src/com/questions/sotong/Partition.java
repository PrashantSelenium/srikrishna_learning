package com.questions.sotong;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Partition
{
	static int[] input = new int[10001];
	
	public static void main (String args[]) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int N = 0;
		int ans = 0;
		while (T-- > 0)
		{
			N = 0;
			ans = 0;
			
			N = sc.nextInt();
			
			for (int i = 0; i < N; i++)
			{
				input[i] = sc.nextInt();
			}
			
			for (int i = 1; i < N; i++)
			{
				Arrays.sort(input, i-1, N);
				input[i] = input[i] + input[i-1];
				ans += input[i];
			}
			
			System.out.println(ans);
		}
	}
}
