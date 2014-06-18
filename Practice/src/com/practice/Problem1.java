package com.practice;

import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;

/*
   As the name of the class should be Solution, using Solution.java as the filename is recommended.
   In any case, you can execute your program by running 'java Solution' command.
 */
class Problem1
{
	static int[] A;
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
		Scanner sc = new Scanner(new File("D:\\ip1.txt"));

		/*
		   Read the test case from standard input.
		   100 natural numbers will be given, and stored in A[0], A[1], ..., A[99].
		 */

		A = new int [100];
		for(int i = 0; i < 100; i++)
		{
			A[i] = sc.nextInt();
		}


		/////////////////////////////////////////////////////////////////////////////////////////////
		int count = 0;
		for (count = 0; count < 100; count++)
		{
			if (count == 99)
				break;
			if (A[count] >= A[count + 1])
				break;
		}
		count++;
		/////////////////////////////////////////////////////////////////////////////////////////////
		 Answer = count;


		// Print the answer to standard output(screen).
		System.out.println(Answer);
	}
}

