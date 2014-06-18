package com.practice;

import java.io.File;
import java.util.Scanner;

class Solution
{
	static int V, E;
	static int[] E1, E2;
	static int AnswerN;
	static int[] Answer;

	public static void main(String args[]) throws Exception
	{

		/*
		   data read from System.in
		*/
		Scanner sc = new Scanner(new File("D://inputnew.txt"));

		for(int test_case = 1; test_case <= 10; test_case++)
		{

			V = sc.nextInt();
			E = sc.nextInt();
			E1 = new int [E];
			E2 = new int [E];
			for(int i = 0; i < E; i++)
			{
				E1[i] = sc.nextInt();
				E2[i] = sc.nextInt();
			}


			System.out.println(V);
			/////////////////////////////////////////////////////////////////////////////////////////////
			
			
			AnswerN = E1.length-1;
			Answer = new int[AnswerN];
			for (int i = 0; i < AnswerN; i++)
			{
				Answer[i] = E1[i];
			}
			
			/////////////////////////////////////////////////////////////////////////////////////////////
			// AnswerN = -1;
			// Answer = new int [V];


			// standard output will be used for the evaluation
			// if AnswerN is not -1, then print the list of the cities
			System.out.print("#" + test_case + " " + AnswerN);
			for(int i = 0; i < AnswerN; i++)
			{
				System.out.print(" " + Answer[i]);
			}
			System.out.println();
		}
	}
}

