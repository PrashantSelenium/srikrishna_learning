package com.questions.sotong;

import java.util.Scanner;

class CuttingColorPaper 
{
	static int mBlue = 0;
	static int mWight = 0;
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++)
		{
			int size = sc.nextInt();
			int[][] paper = new int[size][size];
			
			for (int i = 0; i < paper.length; i++)
				for (int j = 0; j < paper[i].length; j++)
					paper[i][j] = sc.nextInt();
			
			getColoredPieces(paper);
		}
	}
	
	static void getColoredPieces(int[][] paper)
	{
		splitAndCompare(paper, 0 , 0, paper.length);
		System.out.println(mWight+" "+mBlue);	
		
		mWight = mBlue = 0;
	}
	
	static void splitAndCompare(int[][] paper, int startX, int startY, int limit)
	{
		if (limit < 1)
			return;
		
		if (!equal(paper, startX, startY, limit))
		{
			splitAndCompare(paper, startX, startY, limit / 2);
			splitAndCompare(paper, startX, startY + limit / 2, limit / 2);
			splitAndCompare(paper, startX + limit/2, startY, limit / 2);
			splitAndCompare(paper, startX + limit/2, startY + limit/2, limit / 2);
		}
		else
		{
			if (paper[startX][startY] == 1)
				mBlue ++;
			else
				mWight++;
		}
	}
	
	static boolean equal(int[][] paper, int startX, int startY, int limit)
	{
		int inital = paper[startX][startY];
		
		for (int i = 0; i < limit; i++)
		{
			for (int j = 0; j < limit; j++)
			{
				if (inital != paper[i + startX][j + startY] )
					return false;
			}
		}
		return true;
	}
	
}
