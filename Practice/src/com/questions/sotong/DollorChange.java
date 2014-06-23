package com.questions.sotong;

import java.util.Scanner;

class DollorChange
{
	static int[] solutions = new int[1001];

	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int N, K;
		while (T-- > 0)
		{
			N = sc.nextInt();
			K = sc.nextInt();

			for (int i = 1; i < solutions.length; i++)
				solutions[i] = 1;
			for (int i = 2; i <= K; i++)
			{
				for (int j = i; j <= N; j++)
				{
					if (i == j)
						solutions[j] = (solutions[j] + 1) % 100000000;
					else
						solutions[j] = (solutions[j] + solutions[j - i]) % 100000000;
				}
			}
			System.out.println(solutions[N] % 100000000);
		}
	}
}
