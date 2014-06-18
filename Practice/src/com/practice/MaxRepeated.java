package com.practice;

public class MaxRepeated
{
	static int[] q = {
							7,5,7,
							5,7,5,
							7,5,7,
							5,7,5,5
						   }; 
	public static void main (String args[])
	{
		findCandidate(q, 13);
	}
	
	static int findCandidate(int a[], int size)
	{
	    int maj_index = 0, count = 1;
	    int i;
	    for(i = 1; i < size; i++)
	    {
	        if(a[maj_index] == a[i])
	            count++;
	        else
	            count--;
	        if(count == 0)
	        {
	            maj_index = i;
	            count = 1;
	        }
	    }
	    
	    System.out.println(a[maj_index]);
	    return a[maj_index];
	}
}
