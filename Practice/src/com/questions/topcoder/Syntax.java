package com.questions.sotong;

import java.util.Arrays;


public class Syntax
{
	public static void main (String args[])
	{
		String strin = "sita$0020and$0020gita";
		
		char[] input = strin.toCharArray();
		char[] output = new char[input.length];
		
		int j = 0;
		
		for (int i = 0; i < input.length; i++)
		{
			if (input[i] != '$')
			{
				output[j++] = input[i];
				continue;
			}
			
			i++;
			
			int[] hex = new int[]{-1, -1, -1, -1};
			int decimal = 0;
			int count = 0;
			try
			{
				while (i < input.length)
				{
					hex[count] = Integer.parseInt(input[i] + "");
					count++;
					i++;
				}
			}
			catch (NumberFormatException e)
			{
				i--;
			}
			
			boolean hexcondition = false;
			for (int k = hex.length - 1; k >= 0; k--)
			{
				if (hex[k] == -1)
				{
					hexcondition = false;
					break;
				}
				else
				{
					hexcondition = true;
					decimal = (int) (decimal + (hex[k] * Math.pow(16, hex.length - (k+1))));
				}
			}
			
			if (hexcondition)
			{
				output[j++] = (char) decimal;
//				System.out.println(decimal);
			}
			else
			{
				while (j <= i)
				{
					output[j] = input[j];
					j++;
				}
			}
			
		}
		
//		System.out.println(Arrays.toString(output));
//		
//		System.out.println(divide(15, 8));
		
	    int arr[] = {1, 2, 3};
		System.out.println(count(arr, 3, 4));
	}
	
	public static int divide(int a, int b)
    {
        if(a < b)
            return 0;
        int div = b;
        int k = 1;
        while((div<<1) <= a)
        {
            div = div<<1;
            k = k<<1;
        }
        return k + (div == a ? 0 : divide(a-div,b));
    }
	
	static int count( int S[], int arrayLength, int sum )
	{
	    // If n is 0 then there is 1 solution (do not include any coin)
	    if (sum == 0)
	        return 1;
	     
	    // If n is less than 0 then no solution exists
	    if (sum < 0)
	        return 0;
	 
	    // If there are no coins and n is greater than 0, then no solution exist
	    if (arrayLength <=0 && sum >= 1)
	        return 0;
	 
	    // count is sum of solutions (i) including S[m-1] (ii) excluding S[m-1]
	    return count( S, arrayLength - 1, sum ) + count( S, arrayLength, sum-S[arrayLength-1] );
	}
}
