package com.questions.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sherlock
{
	public static void main (String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        
        line = br.readLine();
        int testCases = Integer.parseInt(line);
        
        for (int i = 0; i < testCases; i++)
        {
        	int[] array = getLongestInt(Integer.parseInt(br.readLine()));
        	String str = "";
        	
        	if (array[0] == 0 && array[1] == 0)
        		str = "-1";
        	else if (array[1] != 0 && array[0] != 0)
        	{
        		int count = array[0];
        		str = "";
        		while (count > 0)
        		{
        			str = str + 555;
        			count--;
        		}
        		
        		count = array[1];
        		while (count > 0)
        		{
        			str = str + 33333;
        			count--;
        		}
        		
        		
        	}
        	else if (array[0] != 0)
        	{
        		str = "";
        		int count = array[0];
        		while (count > 0)
        		{
        			str = str + 555;
        			count--;
        		}
        	}
        	else if (array[1] != 0)
        	{
        		str = "";
        		int count = array[1];
        		while (count > 0)
        		{
        			str = str + 33333;
        			count--;
        		}
        	}
        	
        	System.out.println(str);
        }
	}
	
	static int[] getLongestInt(int value)
	{
		int[] output = new int[] {0,0};
		
		if (value % 3 == 0)
		{
			output[0] = value / 3;
		}
		else if ( (3 * (value % 3) + (5 * (value % 5)) == value))
		{
			output[0] = 3 * (value % 3) / 3;
			output[1] = 5 * (value % 5) / 5;
		}
		else if (value % 5 == 0)
		{
			output[1] = value / 5;
		}
		return output;
	}
}
