package com.questions.sotong;

import java.io.IOException;
import java.util.Scanner;

public class Juice
{
	static final int INF = 999999999;

	public static void main(String args[]) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] unitPrice = new int[500];
		int[] unitWeight = new int[500];
		int[] cost = new int[10000];

		int juiceWeight = 0;

		int E, F, N;
		while (T-- > 0)
		{
			E = sc.nextInt();
			F = sc.nextInt();
			N = sc.nextInt();

			juiceWeight = F - E;

			for (int i = 0; i < N; i++)
			{
				unitPrice[i] = sc.nextInt();
				unitWeight[i] = sc.nextInt();
			}
			for (int i = 1; i <= juiceWeight; i++)
				cost[i] = INF;

			for (int i = 0; i < N; i++)
			{
				for (int j = unitWeight[i]; j <= juiceWeight; j++)
				{
					cost[j] = Math.min(cost[j], cost[j - unitWeight[i]] + unitPrice[i]);
				}
			}

			if (cost[juiceWeight] == INF)
				System.out.println("impossible");
			else
				System.out.println(cost[juiceWeight]);
			
			juiceWeight = E = F = N = 0;
		}
	}
}
