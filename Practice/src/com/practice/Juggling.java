package com.practice;

public class Juggling
{

	public static void main (String args[])
	{
		int[] array = {1,2,3,4,5,6,7};
		leftRotate(array, 2, 7);
		
		for (int i = 0; i < 7; i++)
			System.out.print(array[i]+"\t");
	}
	static void leftRotate(int arr[], int d, int n)
	{
	  int i, j, k, temp;
	  for (i = 0; i < 1; i++)
	  {
	    /* move i-th values of blocks */
	    temp = arr[i];
	    j = i;
	    while(true)
	    {
	      k = j + d;
	      if (k >= n)
	        k = k - n;
	      if (k == i)
	        break;
	      arr[j] = arr[k];
	      j = k;
	      
		    for (int m = 0; m < 7; m++)
				System.out.print(arr[m]+"\t");
		    
		    System.out.println("\n");
		    
	    }
	    arr[j] = temp;
	  }
	}
}
