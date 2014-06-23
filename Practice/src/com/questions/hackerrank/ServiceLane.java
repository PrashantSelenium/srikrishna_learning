package com.questions.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ServiceLane
{
	public static void main (String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] lineArray = null;
        
        lineArray = br.readLine().split(" ");
        int N, T;
        int[] width;
        
        N = T = 0;
        
        N = Integer.parseInt(lineArray[0]);
        T = Integer.parseInt(lineArray[1]);
        
        lineArray = br.readLine().split(" ");
        width = new int[lineArray.length];
        
        for (int i = 0; i < lineArray.length; i++)
        	width[i] = Integer.parseInt(lineArray[i]);
        
        for (int i = 0; i < T; i++)
        {
        	lineArray = br.readLine().split(" ");
        	
        	int x = Integer.parseInt(lineArray[0]);
        	int y = Integer.parseInt(lineArray[1]);
        	
        	System.out.println(maxVehicle(x, y, width));
        }
	}
	
	static int maxVehicle (int x, int y, int[] width)
	{
		int min = Integer.MAX_VALUE;
		for (int i = x; i <= y; i++)
		{
			if (min >= width[i])
			{
				min = width[i];
				if (min == 1)
					break;
			}
		}
		
		return min;
	}
}
