package com.questions.geeksforgeeks;

import java.util.Arrays;

public class LongestCommonSubSequence
{
	public static void main(String args[])
	{

		String str1 = "computer";
		String str2 = "router";
		int[] mArray = new int[]{2,6,3,4,1,2,9,5,8};
		lcs(str1, str2);
	}

	public static String lcs(String a, String b)
	{
		int[][] lengths = new int[a.length() + 1][b.length() + 1];

		for (int i = 0; i < a.length(); i++)
			for (int j = 0; j < b.length(); j++)
			{
				if (a.charAt(i) == b.charAt(j))
					lengths[i + 1][j + 1] = lengths[i][j] + 1;
				else
					lengths[i + 1][j + 1] = Math.max(lengths[i + 1][j], lengths[i][j + 1]);

			}
		
		for (int i = 0; i < lengths.length; i++)
			System.out.println(Arrays.toString(lengths[i]));

		// read the substring out from the matrix
		StringBuffer sb = new StringBuffer();
		for (int x = a.length(), y = b.length(); x != 0 && y != 0;)
		{
			if (lengths[x][y] == lengths[x - 1][y])
				x--;
			else if (lengths[x][y] == lengths[x][y - 1])
				y--;
			else
			{
				assert a.charAt(x - 1) == b.charAt(y - 1);
				sb.append(a.charAt(x - 1));
				x--;
				y--;
			}
		}

		return sb.reverse().toString();
	}
}
