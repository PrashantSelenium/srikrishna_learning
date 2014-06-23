package com.questions.sotong;

import java.io.IOException;
import java.util.Scanner;

public class TreeWeighting
{
	static int[][] mMatrix = new int[15][15];
	public static void main (String args[]) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int N = 0;
		
		while (T-- > 0)
		{
			N= sc.nextInt();
			
			for (int i = 0; i <= N; i++)
			{
				int row = sc.nextInt();
				int column = sc.nextInt();
				int weight = sc.nextInt();
				
				mMatrix[row][column] = weight;
				mMatrix[column][row] = weight;
			}
		}
	}
}
