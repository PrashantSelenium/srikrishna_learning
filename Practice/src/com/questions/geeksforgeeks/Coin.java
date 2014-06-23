package com.questions.geeksforgeeks;

import java.util.Arrays;


public class Coin
{
	public static void main (String args[])
	{
		int coins[] = new int[]{1, 2, 5, 10};
		int change = 6;
		
		getMinCoin(coins, change);
		System.out.println(getMinCoinTopDown(coins, change, coins.length - 1));
	}
	
	static void getMinCoin(int[] coins, int change)
	{
		int[] solutions = new int[change+1];
		
		for (int i = 1; i < solutions.length; i++)
			solutions[i] = 99999999;
		
		for (int i = 0; i < coins.length; i++)
		{
			for (int j = coins[i]; j <= change; j++)
			{
				solutions[j] = Math.min(solutions[j], solutions[j - coins[i]] + 1);
			}
		}
		
		System.out.println(Arrays.toString(solutions));
	}
	
	static int getMinCoinTopDown(int[] coins, int change, int length)
	{
		if (change < 0 || length < 0)
			return -1;
		
		int solution1 = 0, solution2 = 0;
		
		if (change == 0)
			return 1;
		else
			solution1 += getMinCoinTopDown(coins, change - coins[length], length);
		
			solution2 += getMinCoinTopDown(coins, change, length-1);
			
		
		if (solution1 != -1 && solution2 != -1)
		{
			int min = Math.min(solution1, solution2);
			return ++min;
		}
		else if (solution1 != -1)
			return ++solution1 ;
		else if (solution2 != -1)
			return ++solution2 ;
		else 
			return 0;
	}
}
