package com.questions.sotong;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

/*
   As the name of the class should be Solution, using Solution.java as the filename is recommended.
   In any case, you can execute your program by running 'java Solution' command.
 */
class Problem3
{
	static int V, E;
	static int[] E1, E2;
	static int Answer1;
	static int[] Answer2;

	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(new File("D:\\ip3.txt"));
		Answer2 = new int[3];

		long start = System.currentTimeMillis();
		for(int test_case = 1; test_case <= 1; test_case++)
		{
			V = sc.nextInt();
			E = sc.nextInt();
			E1 = new int[E];
			E2 = new int[E];
			
			int[][] mListMatrix = new int[V + 1][V + 1];
			
			for(int i = 0; i < E; i++)
			{
				E1[i] = sc.nextInt();
				E2[i] = sc.nextInt();
				
				mListMatrix[E1[i]][0] += 1;
				mListMatrix[E2[i]][0] += 1;
				
				mListMatrix[E1[i]][E2[i]] += 1;
				mListMatrix[E2[i]][E1[i]] += 1;
			}
			
			int[] mCityID = null;
			int mCurrentMin = Integer.MAX_VALUE;
			for (int i = 0; i < mListMatrix.length; i++)
			{
				System.out.println(Arrays.toString(mListMatrix[i]));
				
				if (mListMatrix[i][0] != 0 && mListMatrix[i][0] < mCurrentMin)
				{
					mCurrentMin = mListMatrix[i][0];
					mCityID = new int[mCurrentMin];
					
					for (int j = 0, k = 1; k < mListMatrix[i].length && j < mCurrentMin; k++)
					{
						if (mListMatrix[i][k] != 0)
						{
							mCityID[j++] = k;
						}
					}
				}
			}
			
			if (mCurrentMin != 0)
				System.out.println("#"+test_case+" "+mCurrentMin+" "+Arrays.toString(mCityID));
			else
				System.out.println("#"+test_case+" -1");
		}
		
		System.out.println("Total: "+(System.currentTimeMillis() - start));
	}
}

