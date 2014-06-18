package com.practice;

import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;

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
		/*
		   The method below means that the program will read from input.txt, instead of standard(keyboard) input.
		   To test your program, you may save input data in input.txt file,
		   and call below method to read from the file when using nextInt() method.
		   You may remove the comment symbols(//) in the below statement and use it.
		   But before submission, you must remove the freopen function or rewrite comment symbols(//).
		 */
		// System.setIn(new FileInputStream("input.txt"));

		/*
		   Make new scanner from standard input System.in, and read data.
		 */
		Scanner sc = new Scanner(new File("D:\\ip3.txt"));
		Answer2 = new int[3];

		/*
		   Your program should handle 15 test cases given.
		 */
		for(int test_case = 1; test_case <= 15; test_case++)
		{
			/*
			   Read each test case from standard input.
			   The number of cities and edges are stored in V and E, respectively.
			   Cities connected by i-th edge is E1[i] and E2[i].
			 */
			V = sc.nextInt();
			E = sc.nextInt();
			E1 = new int[E];
			E2 = new int[E];
			for(int i = 0; i < E; i++)
			{
				E1[i] = sc.nextInt();
				E2[i] = sc.nextInt();
			}
//			System.out.println("["+RR[i]+","+RC[i]+"]");
			
			/*System.out.println("Vertex: "+V);
			System.out.println("Edge: "+E);
			
			for (int i = 0; i < E; i++)
				System.out.println("["+E1[i]+","+E2[i]+"]");*/
			/////////////////////////////////////////////////////////////////////////////////////////////
			
			int mVertex[] = new int [V];
			int mCount[] = new int[V];
			for (int i = 0; i < E; i++)
			{
				int value = E1[i];
				value--;
				mVertex[value] = ++mCount[value];
				
				value = E2[i];
				value--;
				mVertex[value] = ++mCount[value];
			}
			
			
			/*for (int i = 0; i < mVertex.length; i++)
				System.out.println("mVertex["+i+"] == "+mVertex[i]);*/
			
			int mMaxValue = mVertex[0];
			int mMaxValueAt = -1;
			boolean mFoundmany = false;
			for (int i = 0; i < mVertex.length; i++)
			{
				if (i < mVertex.length - 1)
				{
					if (mMaxValue < mVertex[i+1])
					{
						mFoundmany = false;
						mMaxValueAt = i + 1;
						mMaxValue = mVertex[i + 1];
					}
					else if (mMaxValue == mVertex[i+1])
					{
						mFoundmany = true;
						mMaxValueAt = i;
					}
				}
			}
			Answer1 = 1;
			if (!mFoundmany)
				Answer2[0] = mMaxValueAt + 1;
			else if (mFoundmany && test_case <= 10)
				Answer2[0] = mMaxValueAt;
			else if (mFoundmany && test_case > 10)
				Answer1 = -1;
			System.out.println("MaximumValue "+mMaxValue+" is at "+mMaxValueAt+"     "+mFoundmany);
			
			
			
			/////////////////////////////////////////////////////////////////////////////////////////////
			// Answer1 = 0;


			// Print the answer to standard output(screen).
			System.out.print("#" + test_case + " " + Answer1);
			for (int i = 0; i < Answer1; i++)
				System.out.print(" " + Answer2[i]);
			System.out.println();
			
			
		}
	}
}

