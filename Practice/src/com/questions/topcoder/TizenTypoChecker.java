package com.questions.sotong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TizenTypoChecker

{
	static int cases = 1;
	public static void main (String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0)
		{
			int totalWords = Integer.parseInt(br.readLine());
			String input = br.readLine();
			
			String[] words = new String[totalWords];
			int[] frequency = new int[totalWords];
			
			for (int i = 0; i < totalWords; i++)
			{
				String[] mine = br.readLine().split(" ");
				words[i] = mine[0];
				frequency[i] = Integer.parseInt(mine[1]);
			}
			
			printANS(input, words, frequency);
			cases++;
		}
	}
	
	static void printANS(String input, String[] words, int[] frequency)
	{
		char start = input.charAt(0);
		char end = input.charAt(input.length() - 1);
		
		int maxID = -1;
		int maxValue = 0;
		
		int[] mine = new int[26];
		char[] inputchars = input.toCharArray();
		
		for (int m = 0; m < inputchars.length; m++)
		{
			mine[inputchars[m] - 'a']++;
		}
		
//		System.out.println(Arrays.toString(mine));
		
		for (int i = 0; i < words.length; i++)
		{
			
			if (start == words[i].charAt(0) && end == words[i].charAt(words[i].length() - 1))
			{
				char[] currentChars = words[i].toCharArray();
				
				boolean condition = true;
				for (int j = 0; j < currentChars.length; j++)
				{
					if (mine[currentChars[j] - 'a'] == 0)
					{
						condition = false;
						break;
					}
				}
				if (condition && frequency[i] > maxValue)
				{
					maxID = i;
					maxValue = frequency[i];
				}
				else if (condition && frequency[i] == maxValue)
				{
					if (words[maxID].length() > words[i].length())
					{
						maxID = i;
						maxValue = frequency[i];
					}
				}
			}
		}
		
		System.out.println("Case #"+cases);
		if (maxID == -1)
			System.out.println("ERROR");
		else
			System.out.println(words[maxID]);
	}
}