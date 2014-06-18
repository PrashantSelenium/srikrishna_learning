package com.practice;

import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;

/*
   As the name of the class should be Solution, using Solution.java as the filename is recommended.
   In any case, you can execute your program by running 'java Solution' command.
 */
class Problem2
{
	static int R;
	static int FR, FC;
	static int[] RR = new int[400], RC = new int[400];
	static int Answer;

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
		Scanner sc = new Scanner(new File("D:\\ip2.txt"));

		/*
		   Your program should handle 10 test cases given.
		 */
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			/*
			   Read each test case from standard input.
			   The number of rabbits will be stored in R.
			   Row index of the fox will be stored in FR, and its column index will be stored in FC.
			   Row indices of the rabiits will be stored in array RR, column indices will be stored in array RC.
			 */
			R = sc.nextInt();
			FR = sc.nextInt();
			FC = sc.nextInt();

			for(int i = 0; i < R; i++)
			{
				RR[i] = sc.nextInt();
				RC[i] = sc.nextInt();
			}
			
			System.out.println("FOX ROW: "+FR);
			System.out.println("FOX COLOUM: "+FC);

			for(int i = 0; i < R; i++)
			{
				System.out.println("RABBIT ROW: "+RR[i]);
				System.out.println("RABBIT COLOUM: "+RC[i]);
			}
			System.out.println("*******");
			/////////////////////////////////////////////////////////////////////////////////////////////
			int count = 0;
			for (int i = 0; i < R; i++)
			{
				if (RC[i] == FC && RR[i] == FR)
				{
				
					count++;
				}
				else if (RC[i] == FC)
				{
				
					count++;
				}
				else if (RR[i] == FR)
				{
				
					count++;
				}
				else if ((FR - RR[i]) == (FC - RC[i])) 
				{
				
					count++;
				}
				else if ((-1*(FR - RR[i]) == FC - RC[i]))
				{
					count++;
				}
			}
			Answer = count;
			/////////////////////////////////////////////////////////////////////////////////////////////
			 //Answer = 0;


			// Print the answer to standard ouptut(screen).
			System.out.print("#" + test_case);
			System.out.println(" " + Answer);
		}
	}
}


