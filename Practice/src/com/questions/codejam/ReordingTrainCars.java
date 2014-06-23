package com.questions.codejam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class ReordingTrainCars
{
	static ArrayList<String> list = new ArrayList<String>();
	static int count = 0;
	static int grandCount = 0;
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		T = 1;
		
		while (T-- > 0)
		{
			br.readLine();
			String[] str = br.readLine().split(" ");
			Arrays.sort(str);			
			generateStrings(str);
			System.out.println("Ans: "+count);
			count  = 0;
		}
	}
	
	static void generateStrings(String[] input)
	{
		for (int i = 0; i < input.length; i++)
		{
			generateStrings(i, input);
		}
	}
	
	static void generateStrings(int index, String[] input)
	{
		char required = '\n';
		char currentChar = '\n';
		required = input[index].charAt(input[index].length() - 1);
		
//		System.out.println("Input = "+input[index] + " Required: "+required);
		for (int i = 0; i < input.length; i++)
		{
			if (i == index)
				continue;
			
			currentChar = input[i].charAt(0);
			System.out.println("Input: "+input[i]+" "+currentChar +" "+required);
			
			if (required == currentChar)
			{
				required = input[i].charAt(input[i].length() - 1);
			}
			else
			{
				return;
			}
		}
		
		count++;
	}
}
