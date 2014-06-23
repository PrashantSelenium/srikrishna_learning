package com.questions.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HalloweenParty
{
	public static void main (String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        
        line = br.readLine();
        
        int testCases = Integer.parseInt(line);
        
        for (int i = 0; i < testCases; i++)
        {
        	line = br.readLine();
        	System.out.println(getNumberOfPieces(Integer.parseInt(line)));
        }
	}
	
	static int getNumberOfPieces(int value)
	{
		int x = value / 2;
		int y = value - x;
		
		return x * y;
	}
}
