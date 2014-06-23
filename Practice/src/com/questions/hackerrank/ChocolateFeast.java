package com.questions.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChocolateFeast
{
	public static void main (String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] lineArray = null;
        String line = null;
        
        line = br.readLine();
        
        int T = Integer.parseInt(line);
        
        for (int i = 0; i < T; i++)
        {
        	lineArray = br.readLine().split(" ");
        	
        	int N = Integer.parseInt(lineArray[0]);
        	int C = Integer.parseInt(lineArray[1]);
        	int M = Integer.parseInt(lineArray[2]);
        	
        	System.out.println(getChocolateCount (N, C, M));
        }
	}
	
	static long getChocolateCount (int n, int a, int b)
	{
		long chocolates = n / a;
		long wafers = chocolates;
		
		while (wafers >= b)
		{
			wafers -= b;
			chocolates++;
			wafers++;
		}
		
		return chocolates;
	}
}
