package com.practice;

import java.util.Arrays;

public class SerialNeighbour {

	int puzzle[] = {
			-1,		0, 		0, 		44, 	17, 	0, 		15, 	-1,
			
			41,		46, 	45, 	11, 	18, 	0, 		0, 		0,
			
			49,		0, 		47, 	0, 		12, 	19, 	20, 	0,
			
			0, 		48, 	39, 	56, 	0, 		8, 		0, 		23,
			
			0, 		38, 	55, 	0, 		7, 		3, 		1, 		0,
			
			0, 		54, 	0, 		58, 	0, 		6, 		27, 	0,
			
			0, 		35, 	36, 	59, 	60, 	5, 		0, 		26,
			
			-1, 	34, 	0, 		0, 		0, 		30, 	0, 		-1
	};
	
	final int solution[] = {
			-1, 42, 43, 44, 17, 16, 15, -1,
			41, 46, 45, 11, 18, 13, 14, 21,
			49, 40, 47, 10, 12, 19, 20, 22,
			50, 48, 39, 56,  9,  8,  2, 23,
			51, 38, 55, 57,  7,  3,  1, 24,
			52, 54, 37, 58,  4,  6, 27, 25,
			53, 35, 36, 59, 60,  5, 28, 26,
			-1, 34, 33, 32, 31, 30, 29, -1
			
			
	};
	
	int mTraverse[] = new int [64];
	int mTemp[] = new int [64];
	private boolean mDo = false;
	
	int convert_2D_to_1D_index(int column, int row)
	{
		return (column * 8 + row);
	}
	
	void print_puzzle()
	{
		
		for (int i = 0; i < 64;) {
				
			System.out.println( mTemp[i]+"\t"+mTemp[i + 1]
					+"\t"+mTemp[i + 2] +"\t"+mTemp[i + 3] 
							+"\t"+mTemp[i + 4]+"\t"+mTemp[i + 5]
									+"\t"+mTemp[i + 6]+"\t"+mTemp[i + 7]);

			
			i = i+8;
			
		}
		
		System.out.println("*******");
		for (int i = 0; i < 63;)
		{
			System.out.println( i+"\t"+(i + 1)
					+"\t"+(i+2) +"\t"+(i+3) 
					+"\t"+(i+4)+"\t"+(i+5)
					+"\t"+(i+6)+"\t"+(i+7));

			
			System.out.println( mTraverse[i]+"\t"+mTraverse[i + 1]
					+"\t"+mTraverse[i + 2] +"\t"+mTraverse[i + 3] 
							+"\t"+mTraverse[i + 4]+"\t"+mTraverse[i + 5]
									+"\t"+mTraverse[i + 6]+"\t"+mTraverse[i + 7]);
			System.out.println("\n");
			i = i+8;
		}
	}
	
	void validate()
	{
		int i;
		for (i = 0; i < 8 * 8; i++) {
			if (puzzle[i] != solution[i]) {
				System.out.println("FAIL\n");
				return;
			}
		}
		System.out.println("PASS\n");
	}

	void fill_serial_neighbours()
	{
		mTemp = puzzle;
		traverseElements();
		findOneZero();
		fillOneSpace();
	}
	
	public void traverseElements()
	{
		Arrays.fill(mTraverse, -1);
		//Arrays.fill(mNodeID, -1);
		for (int i = 0; i < 8 * 8; i++)
		{
			if (mTemp[i] == -1 || mTemp[i] == 0)
			{
				continue;
			}
			else
			{
				mTraverse[mTemp[i]] = i;
			}
		}
	}
	
	public void traverseElementsNew()
	{
		Arrays.fill(mTraverse, -1);
		//Arrays.fill(mNodeID, -1);
		for (int i = 0; i < 8 * 8; )
		{
			if (mTemp[i] == -1 || mTemp[i] == 0)
			{
				i++;
				continue;
			}
			else
			{
				if (mTemp[i] != 64)
					mTraverse[mTemp[i]] = i;
				i++;
			}
		}
	}
	
	public void fillOneSpace()
	{
		for (int i = 1; i < 63;)
		{
			System.out.println("Start: "+i);
			if (mTraverse[i] != -1 && mTraverse[i + 1] == -1)
			{
				int a1[] = getAccessPostion( mTraverse[i]);
				
				System.out.println(a1[0]+"\t"+a1[1]+"\t"+a1[2]+"\t"+a1[3]);
				if (a1[1] == -1 && a1[2] == -1 && a1[3] == -1)
				{
					if (a1[0] != -1)
						mTemp[a1[0]] = i + 1;
				}
			}
			if (i != 64)
				traverseElementsNew();
			i = i + 1;
		}
		
		print_puzzle();
	}
	
	public void findOneZero()
	{
		mTemp = puzzle;
		int count = 0;
		for (int i = 1; i < 61;)
		{
//			System.out.println("start: "+i);
			if (mTraverse[i] != -1 && mTraverse[i + 1] == -1 && mTraverse[i + 2] != -1)
			{
				count++;
				int a[] = getAccessPostion(mTraverse[i], mTraverse[i + 2]);
				
				
				int b = getAvailablePostions(a);
//				System.out.println(a[0]+"\t"+a[1]+"\t"+a[2]+"\t"+a[3]+" and postition available is: 11:"+b);				
				if (b != -1)
					mTemp[b] = i + 1;
			}
			/*else if (mTraverse[i] != -1 && mTraverse[i + 1] != -1 && mTraverse[i + 2] == -1)
			{
				count++;
				int a[] = getAccessPostion(mTraverse[i], mTraverse[i + 1]);
				
				int b = getAvailablePostions(a);
				//System.out.println(a[0]+"\t"+a[1]+"\t"+a[2]+"\t"+a[3]+" and postition available is: 22:"+b);				
				//System.out.println(i);
				if (b != -1)
					mTemp[b] = i + 2;
				else
				{
					int a1[] = getAccessPostion( mTraverse[i + 1]);
					if (a1[1] == -1 && a1[2] == -1 && a1[3] == -1)
						mTemp[a1[0]] = i + 2;
				}
			}*/
			
			traverseElementsNew();
			i = i + 2;
			System.out.println("END");
			if (count >=15)
				break;
		}
		
	}
	
	public int[] getAccessPostion(int second)
	{
		int mine[] = new int [4];
		
		int second2d[] = new int [2];
		
		int secondN[] = new int [8];
		
		second2d[0] = second/8;
		second2d[1] = second%8;
		
//		System.out.println("Second:"+second+"0: "+second2d[0]+"\t1:"+second2d[1]);
		if (second2d[1] == 0)
		{
			secondN[0] = -1;
			secondN[1] = (second2d[0] - 1) * 8 + (second2d[1]);
			secondN[2] = (second2d[0] - 1) * 8 + (second2d[1] + 1);
			secondN[3] = -1;
			secondN[4] = (second2d[0]) * 8 + (second2d[1] + 1);
			secondN[5] = -1;
			secondN[6] = (second2d[0] + 1) * 8 + (second2d[1]);
			secondN[7] = (second2d[0] + 1) * 8 + (second2d[1] + 1);
		}
		else if (second2d[1] == 7)
		{
			secondN[0] = (second2d[0] - 1) * 8 + (second2d[1] - 1);
			secondN[1] = (second2d[0] - 1) * 8 + (second2d[1]);
			secondN[2] = -1;
			secondN[3] = (second2d[0]) * 8 + (second2d[1] - 1);
			secondN[4] = -1;
			secondN[5] = (second2d[0] + 1) * 8 + (second2d[1] - 1);
			secondN[6] = (second2d[0] + 1) * 8 + (second2d[1]);
			secondN[7] = -1;
		}
		if (second2d[0] == 0)
		{
			secondN[0] = -1;
			secondN[1] = -1;
			secondN[2] = -1;
			secondN[3] = (second2d[0]) * 8 + (second2d[1] - 1);
			secondN[4] = (second2d[0]) * 8 + (second2d[1] + 1);
			secondN[5] = (second2d[0] + 1) * 8 + (second2d[1] - 1);
			secondN[6] = (second2d[0] + 1) * 8 + (second2d[1]);
			secondN[7] = (second2d[0] + 1) * 8 + (second2d[1] + 1);
		}
		else if (second2d[0] == 7)
		{
			secondN[0] = (second2d[0] - 1) * 8 + (second2d[1] - 1);
			secondN[1] = (second2d[0] - 1) * 8 + (second2d[1]);
			secondN[2] = (second2d[0] - 1) * 8 + (second2d[1] + 1);
			secondN[3] = (second2d[0]) * 8 + (second2d[1] - 1);
			secondN[4] = (second2d[0]) * 8 + (second2d[1] + 1);
			secondN[5] = -1;
			secondN[6] = -1;
			secondN[7] = -1;
		}
		else
		{
			secondN[0] = ((second2d[0] - 1) * 8) + (second2d[1] - 1);
			secondN[1] = ((second2d[0] - 1) * 8) + (second2d[1]);
			secondN[2] = (second2d[0] - 1) * 8 + (second2d[1] + 1);
			secondN[3] = (second2d[0]) * 8 + (second2d[1] - 1);
			secondN[4] = (second2d[0]) * 8 + (second2d[1] + 1);
			secondN[5] = (second2d[0] + 1) * 8 + (second2d[1] - 1);
			secondN[6] = (second2d[0] + 1) * 8 + (second2d[1]);
			secondN[7] = (second2d[0] + 1) * 8 + (second2d[1] + 1);
		}
		
		for (int i = 0; i < 8; i++)
		{
//			System.out.println("Value: "+secondN[i]);
			if ((secondN[i] >= 0) && (mTemp[secondN[i]] == 0))
			{
				mine[0] = secondN[i];
			}
		}
		mine[1] = -1;
		mine[2] = -1;
		mine[3] = -1;
		
		return mine;
	}
	public int[] getAccessPostion(int first, int second)
	{
		int mine[] = new int [4];
		
		int first2d[]  = new int [2];
		int second2d[] = new int [2];
		
		int firstN[] = new int [8];
		int secondN[] = new int [8];
		
		first2d[0] = first/8;
		first2d[1] = first%8;
		
		second2d[0] = second/8;
		second2d[1] = second%8;

		if (first2d[1] == 0)
		{
			firstN[0] = -1;
			firstN[1] = (first2d[0] - 1) * 8 + (first2d[1]);
			firstN[2] = (first2d[0] - 1) * 8 + (first2d[1] + 1);
			firstN[3] = -1;
			firstN[4] = (first2d[0]) * 8 + (first2d[1] + 1);
			firstN[5] = -1;
			firstN[6] = (first2d[0] + 1) * 8 + (first2d[1]);
			firstN[7] = (first2d[0] + 1) * 8 + (first2d[1] + 1);
		}
		else if (first2d[1] == 7)
		{
			firstN[0] = (first2d[0] - 1) * 8 + (first2d[1] - 1);
			firstN[1] = (first2d[0] - 1) * 8 + (first2d[1]);
			firstN[2] = -1;
			firstN[3] = (first2d[0]) * 8 + (first2d[1] - 1);
			firstN[4] = -1;
			firstN[5] = (first2d[0] + 1) * 8 + (first2d[1] - 1);
			firstN[6] = (first2d[0] + 1) * 8 + (first2d[1]);
			firstN[7] = -1;
		}
		if (first2d[0] == 0)
		{
			firstN[0] = -1;
			firstN[1] = -1;
			firstN[2] = -1;
			firstN[3] = (first2d[0]) * 8 + (first2d[1] - 1);
			firstN[4] = (first2d[0]) * 8 + (first2d[1] + 1);
			firstN[5] = (first2d[0] + 1) * 8 + (first2d[1] - 1);
			firstN[6] = (first2d[0] + 1) * 8 + (first2d[1]);
			firstN[7] = (first2d[0] + 1) * 8 + (first2d[1] + 1);
		}
		else if (first2d[0] == 7)
		{
			firstN[0] = (first2d[0] - 1) * 8 + (first2d[1] - 1);
			firstN[1] = (first2d[0] - 1) * 8 + (first2d[1]);
			firstN[2] = (first2d[0] - 1) * 8 + (first2d[1] + 1);
			firstN[3] = (first2d[0]) * 8 + (first2d[1] - 1);
			firstN[4] = (first2d[0]) * 8 + (first2d[1] + 1);
			firstN[5] = -1;
			firstN[6] = -1;
			firstN[7] = -1;
		}
		else
		{
			firstN[0] = (first2d[0] - 1) * 8 + (first2d[1] - 1);
			firstN[1] = (first2d[0] - 1) * 8 + (first2d[1]);
			firstN[2] = (first2d[0] - 1) * 8 + (first2d[1] + 1);
			firstN[3] = (first2d[0]) * 8 + (first2d[1] - 1);
			firstN[4] = (first2d[0]) * 8 + (first2d[1] + 1);
			firstN[5] = (first2d[0] + 1) * 8 + (first2d[1] - 1);
			firstN[6] = (first2d[0] + 1) * 8 + (first2d[1]);
			firstN[7] = (first2d[0] + 1) * 8 + (first2d[1] + 1);
		}
		
		if (second2d[1] == 0)
		{
			secondN[0] = -1;
			secondN[1] = (second2d[0] - 1) * 8 + (second2d[1]);
			secondN[2] = (second2d[0] - 1) * 8 + (second2d[1] + 1);
			secondN[3] = -1;
			secondN[4] = (second2d[0]) * 8 + (second2d[1] + 1);
			secondN[5] = -1;
			secondN[6] = (second2d[0] + 1) * 8 + (second2d[1]);
			secondN[7] = (second2d[0] + 1) * 8 + (second2d[1] + 1);
		}
		else if (second2d[1] == 7)
		{
			secondN[0] = (second2d[0] - 1) * 8 + (second2d[1] - 1);
			secondN[1] = (second2d[0] - 1) * 8 + (second2d[1]);
			secondN[2] = -1;
			secondN[3] = (second2d[0]) * 8 + (second2d[1] - 1);
			secondN[4] = -1;
			secondN[5] = (second2d[0] + 1) * 8 + (second2d[1] - 1);
			secondN[6] = (second2d[0] + 1) * 8 + (second2d[1]);
			secondN[7] = -1;
		}
		if (second2d[0] == 0)
		{
			secondN[0] = -1;
			secondN[1] = -1;
			secondN[2] = -1;
			secondN[3] = (second2d[0]) * 8 + (second2d[1] - 1);
			secondN[4] = (second2d[0]) * 8 + (second2d[1] + 1);
			secondN[5] = (second2d[0] + 1) * 8 + (second2d[1] - 1);
			secondN[6] = (second2d[0] + 1) * 8 + (second2d[1]);
			secondN[7] = (second2d[0] + 1) * 8 + (second2d[1] + 1);
		}
		else if (second2d[0] == 7)
		{
			secondN[0] = (second2d[0] - 1) * 8 + (second2d[1] - 1);
			secondN[1] = (second2d[0] - 1) * 8 + (second2d[1]);
			secondN[2] = (second2d[0] - 1) * 8 + (second2d[1] + 1);
			secondN[3] = (second2d[0]) * 8 + (second2d[1] - 1);
			secondN[4] = (second2d[0]) * 8 + (second2d[1] + 1);
			secondN[5] = -1;
			secondN[6] = -1;
			secondN[7] = -1;
		}
		else
		{
			secondN[0] = (second2d[0] - 1) * 8 + (second2d[1] - 1);
			secondN[1] = (second2d[0] - 1) * 8 + (second2d[1]);
			secondN[2] = (second2d[0] - 1) * 8 + (second2d[1] + 1);
			secondN[3] = (second2d[0]) * 8 + (second2d[1] - 1);
			secondN[4] = (second2d[0]) * 8 + (second2d[1] + 1);
			secondN[5] = (second2d[0] + 1) * 8 + (second2d[1] - 1);
			secondN[6] = (second2d[0] + 1) * 8 + (second2d[1]);
			secondN[7] = (second2d[0] + 1) * 8 + (second2d[1] + 1);
		}
		
		int pos = 0;
		for (int i = 0; i < 8; i++)
			for (int j = 0; j < 8; j++)
			{
				if (firstN[i] == secondN[j] && firstN[i] != -1)
				{
					mine[pos] = firstN[i];
					pos++;
					break;
				}
			}
		
		return mine;
	}
	
	public int getAvailablePostions(int[] a)
	{
		int availablepos = -1;
		boolean found = false;
		for (int i = 0; i < 4; i++)
		{
			if (a[i] == -1)
				continue;
			else if (mTemp[a[i]] % 65 == 0)
			{
				if (!found)
				{
					availablepos = a[i];
					found = true;
				}
				else
					availablepos = -1;
			}
		}
		return availablepos;
	}
	public static void main(String args[])
	{
		SerialNeighbour sn = new SerialNeighbour();
		
		sn.fill_serial_neighbours();
		sn.validate();
		
	}
}
