package com.questions.sotong;

import java.io.IOException;
import java.util.Scanner;

public class GalaxyStationsConnected
{
	public static void main (String args[]) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		while (T-- > 0)
		{
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			
			boolean[][] pathMatrix = new boolean[N + 1][N + 1];
			int[] check1 = new int[K];
			int[] check2 = new int[K];
			
			for (int i = 0; i < M; i++)
			{
				int row = sc.nextInt();
				int column = sc.nextInt();
				
				pathMatrix[row][column] = true;
				pathMatrix[column][row] = true;
			}
			
			for (int i = 0; i < K; i++)
			{
//				check1[i] = sc.nextInt();
//				check2[i] = sc.nextInt();
				
				boolean[] visited = new boolean[N + 1];
				getPaths(sc.nextInt(), sc.nextInt(), pathMatrix, visited);
			}
			
		}
	}
	
	static void getPaths(int row, int column, boolean[][] pathMatrix, boolean[] visited)
	{
		
	}
}
