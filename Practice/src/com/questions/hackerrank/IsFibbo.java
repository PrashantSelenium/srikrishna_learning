package com.questions.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IsFibbo
{
	public static void main (String args[]) throws IOException, NumberFormatException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        
        line = br.readLine();
        int N = Integer.parseInt(line);
        
        for (int i = 0; i < N; i++)
        {
        	isFibbo(Double.parseDouble(br.readLine()));
        }
	}
	
	static void isFibbo(double num)
	{
		double answer = 5 * num * num;
		
		double temp = Math.sqrt((answer - 4));
		
		if (temp * temp == (answer - 4))
		{
			System.out.println("IsFibo");
			return;
		}
		
		temp = Math.sqrt((answer + 4));
		if (temp * temp == (answer + 4))
		{
			System.out.println("IsFibo");
			return;
		}
		
		System.out.println("IsNotFibo");
	}
}
