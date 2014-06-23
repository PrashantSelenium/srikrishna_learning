package com.questions.sotong;

import java.util.Scanner;

public class GettingThroughWinter
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int N, K, B;
		int ones = 0, twos = 0;
		for (int i = 0; i < T; i++)
		{
			N = sc.nextInt();
			K = sc.nextInt();
			B = sc.nextInt();
			
			for (int j = 0; j < N; j++)
			{
				if (sc.nextInt() == 1)
					ones++;
				else
					twos++;
				sc.nextInt();
			}
			
			if (ones > twos)
				System.out.println(ones * K);
			else
				System.out.println(twos * K);
			
			
			ones = twos = 0;
		}
	}
}
