package com.questions.sotong;

import java.io.IOException;
import java.util.Scanner;

public class IrredusableFractions
{
	public static void main (String args[]) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int i = 0; i < T; i++)
		{
			int N = sc.nextInt();
			System.out.println(countFractions(N) + 2);
		}
	}
	
	static int countFractions(int N)
	{
		int result = 0;
		
		if (N == 1)
			return result;
		
		for (int i = N-1; i > 0; i--)
		{
			if (checkGCD(N, i) == 1)
				result++;
		}
		
		return result + countFractions(N-1);
	}
	
	static int checkGCD(int denominater, int numarator)
	{
	   if (numarator == 0) return denominater;
	   return checkGCD(numarator,denominater%numarator);
	}
}
