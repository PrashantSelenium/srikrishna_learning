package com.practice;

import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;

/*
   Use only Solution.java file and class name should be the same. Otherwise you will not get the score
*/
import java.util.Scanner;
import java.io.FileInputStream;

/*
   Use only Solution.java file and class name should be the same. Otherwise you will not get the score
*/

class Solution_BlackJack
{
	static int N;
	static int[] A = new int[10];
	static int Answer;

	public static void main(String args[]) throws Exception
	{
		/*
		   data read from System.in
		*/
		Scanner sc = new Scanner(new File(("D:\\input.txt")));

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			Answer = 0;
			N = sc.nextInt();
			
			for(int i = 0; i < N; i++)
			{
				A[i] = sc.nextInt();
//				System.out.println(A[i]);
			}

			/////////////////////////////////////////////////////////////////////////////////////////////
			
			for (int i = 0; i < N; i++)
			{
				
				if (A[i] == 1)
				{
					if (Answer+11 <= 21)
						A[i] = 11;
				}
				
				if (Answer+A[i] <= 21)
				{
					Answer = Answer+ A[i];
				}
				else 
					break;
			}
			
			/////////////////////////////////////////////////////////////////////////////////////////////

//			Answer = sum1;

			// standard output will be used for the evaluation.
			System.out.print("#" + test_case);
			System.out.println("Answer:" + Answer);
			System.out.println("******");
		}
	}
}


