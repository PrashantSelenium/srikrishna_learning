package com.practice.questions;

import java.util.Arrays;

public class AnagramApp
{
	public static void main(String[] args)
	{
		System.out.println(isAnagram("abcd", "cabd"));
	}
	
	private static boolean isAnagram(String str1, String str2)
	{
		char[] charArray1 = str1.toCharArray();
		char[] charArray2 = str2.toCharArray();
		
		Arrays.sort(charArray1);
		Arrays.sort(charArray2);
		
		for (int i = 0; i < charArray1.length || i < charArray2.length; i++)
		{
			if (i < charArray1.length && i < charArray2.length)
			{
				if (charArray1[i] != charArray2[i])
					return false;
			}
		}
		return true;
	}
}