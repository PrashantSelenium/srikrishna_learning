package com.questions.hackerrank;

public class MaxProfit
{
	public static void main (String args[])
	{
		int[] prices = new int[]{10,20,5,6,46,7,47,80};
		
		int max = getSum(prices, 0, prices.length-1, prices.length-1);
	}

	private static int getSum(int[] prices, int start, int mid, int high)
	{
		int profit = 0;
		int max1 = (getMax(prices, 0, high));
		int min1 = (getMin(prices, 0, high));
		
		System.out.println(max1 - min1);
		System.out.println("");
		int max2, min2;
		if (profit < (max1 - min1))
			profit = max1 - min1;
		
		while (start < mid)
		{
			mid--;
			
			max1 = getMax(prices, start, mid-1);
			min1 = getMin(prices, start, mid-1);
			
			
			max2 = getMax(prices, mid, high);
			min2 = getMin(prices, mid, high);
			
			System.out.println((max1 - min1) + (max2 - min2));
			System.out.println("");
		}
		return -1;
	}
	
	static int getMax(int[] prices, int start, int end)
	{
		int max = 0;
		
		for (int i = start; i <= end; i++)
		{
			if (max < prices[i])
				max = prices[i];
		}
		
		System.out.println("MAX: "+start+" "+(end)+" "+max);
		return max;
	}
	
	static int getMin(int[] prices, int start, int end)
	{
		int min = Integer.MAX_VALUE;
		
		for (int i = start; i <= end; i++)
		{
			if (min > prices[i])
				min = prices[i];
		}
		
		System.out.println("Min: "+start+" "+(end)+" "+min);
		return min;
	}
	
	
}
