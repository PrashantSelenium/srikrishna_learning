package com.questions.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UtopinTree
{
	public static void main (String args[])
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
		try
		{
			line = br.readLine();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
        int N = Integer.parseInt(line);
        
        for (int i = 0; i < N; i++)
        {
        	try
			{
				line = br.readLine();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
        	System.out.println((int) getHeight(Integer.parseInt(line)));
        }
	}
	
	static double getHeight(int height)
	{
		int fullCycle = height / 2;
		double ans = 2 * (Math.pow(2, fullCycle) - 1) + 1;
		
		if (height % 2 != 0)
		{
			return 2 * ans;
		}
		return ans;
	}
}
