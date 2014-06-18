package com.practice;

import java.util.Arrays;

public class Anagram
{
	public void anag(String s1, String s2)
	{
		if (s1.length() == 0)
		{
			System.out.println(s2);
		}
		for (int i = 0; i < s1.length(); i++)
		{
			String str1 = s1.substring(0, i) + s1.substring(i + 1, s1.length());
			String str2 = s1.charAt(i) + s2;
			
//			System.out.print(str1 + "\t" + str2 + "\n");
			anag(str1 , str2);
		}
	}

	public static void main(String[] args)
	{
		Anagram ana = new Anagram();
//		ana.anag("ABC", "");
		ana.isAnagram( "I am Lord Voldemort", "Tom Marvolo Riddle");
	}
	
	public boolean isAnagram(String s1, String s2){
	     
		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();
		
		s1 = s1.replace(" ", "");
		s2 = s2.replace(" ", "");
			char[] a1 = s1.toCharArray();
	     char[] a2 = s2.toCharArray();
			
	     Arrays.sort(a1);
	     Arrays.sort(a2);
			
	     if (Arrays.toString(a1).equals(Arrays.toString(a2))){
	          return true;
	     }
	     return false;
	}
}
