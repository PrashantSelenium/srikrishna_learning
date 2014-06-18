package com.practice.questions;

import java.util.Arrays;

public class KthMinElementInArray
{
	public static void main (String args[])
	{
		
		int[] input1 = new int[]{10,15,25,40,60};
		int[] input2 = new int[]{5,9,16,30,36,42,51,72};
		int[] input3 = new int[13];
		System.out.println(kthMinElement(input1, input2, input3, 3));
	}
	
	static int kthMinElement(int[] array1, int[] array2, int[] array3, int k)
	{
		/*
		//sorting
		int temp;
		int size=0;
		int l1=array1.length;
		int l2=array2.length;
		for(int i=0;i<l1;i++)
		{
			for(int j=0;j<=l2;j++)
			{
				if(array1[i]<array2[j])
				{
								
					temp=array1[i];
					array3[size]=array2[j];
					array2[j]=temp;
					size++;
					
				}
			}
		}*/
		
		int input1_counter = 0, input2_counter = 0, array = 0;
		while (input1_counter < array1.length || input2_counter < array2.length)
		{
			if (input1_counter < array1.length && input2_counter < array2.length)
			{
				if(array1[input1_counter] < array2[input2_counter])
				{
					array3[array] = array1[input1_counter];
					input1_counter++;
				}
				else
				{
					array3[array] = array2[input2_counter];
					input2_counter++;
				}
			}
			else if (input1_counter < array1.length)
			{
				array3[array] = array1[input1_counter];
				input1_counter++;
			}
			else if (input2_counter < array2.length)
			{
				array3[array] = array2[input2_counter];
				input2_counter++;
			}
			
			array++;
		}
		
		System.out.println(Arrays.toString(array3));
		
		return array3[k];
	}
	
	static int kthMaxElement(int[] array1, int[] array2, int k)
	{
		
		return 0;
	}
}
