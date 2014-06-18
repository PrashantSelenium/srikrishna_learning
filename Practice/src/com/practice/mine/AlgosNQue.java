package com.practice.mine;

import java.util.Arrays;
import java.util.StringTokenizer;

public class AlgosNQue
{

	public static void main(String args[])
	{
		String str = "sri.krishna.v.sri";
		StringTokenizer st = new StringTokenizer(str, ".");
/*		System.out.println(st.countTokens());

		System.out.println(isAnagram("abc", "cba"));

		kadans_algo(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 40 });

		duch_men_flag(new int[] { 0, 2, 1, 0, 1, 2, 1, 2, 0, 0, 1, 1 });*/
		
		pick2unique(new int[] {2, 4, 7, 9, 2, 4}, 6);
	}

	public static boolean isAnagram(String firstWord, String secondWord)
	{
		char[] word1 = firstWord.toCharArray();
		char[] word2 = secondWord.toCharArray();

		if (word1[1] > word2[2])
		{
			System.out.println("First: " + word1[1] + "\t" + word2[2]);
		}
		else
			System.out.println("Second: " + word1[1] + "\t" + word2[2]);
		Arrays.sort(word1);
		Arrays.sort(word2);
		return Arrays.equals(word1, word2);
	}

	/*
	 * Used to find the max sum of sub array
	 */
	public static void kadans_algo(int[] inputArray)
	{
		int maxStartIndex = 0;
		int maxEndIndex = 0;
		int maxSum = Integer.MIN_VALUE;

		int cumulativeSum = 0;
		int maxStartIndexUntilNow = 0;
		for (int currentIndex = 0; currentIndex < inputArray.length; currentIndex++)
		{
			int eachArrayItem = inputArray[currentIndex];
			cumulativeSum += eachArrayItem;

			if (cumulativeSum > maxSum)
			{
				maxSum = cumulativeSum;
				maxStartIndex = maxStartIndexUntilNow;
				maxEndIndex = currentIndex;
			}
			else if (cumulativeSum < 0)
			{
				maxStartIndexUntilNow = currentIndex + 1;
				cumulativeSum = 0;
			}
		}

		System.out.println("Max sum : " + maxSum);
		System.out.println("Max start index : " + maxStartIndex);
		System.out.println("Max end index : " + maxEndIndex);
	}

	public static void duch_men_flag(int[] mArray)
	{
		int low, mid, high;

		low = mid = 0;
		high = mArray.length - 1;

		while (mid <= high)
		{
			if (mArray[mid] == 0)
			{
				swap(low++, mid++, mArray);
			}
			else if (mArray[mid] == 1)
			{
				mid++;
			}
			else if (mArray[mid] == 2)
			{
				swap(mid, high--, mArray);
			}

		}

		for (int i = 0; i < mArray.length; i++)
			System.out.print(mArray[i] + "\t");
	}

	static void swap(int a, int b, int[] mArray)
	{
		mArray[a] = mArray[a] ^ mArray[b];
		mArray[b] = mArray[a] ^ mArray[b];
		mArray[a] = mArray[a] ^ mArray[b];
	}

	static void pick2unique(int[] arr, int n)
	{
		int xor = arr[0]; /* Will hold xor of all elements */
		int set_bit_no; /* Will have only single set bit of xor */
		int i;
		int x = 0;
		int y = 0;

		/* Get the xor of all elements */
		for (i = 1; i < n; i++)
			xor ^= arr[i];

		/* Get the rightmost set bit in set_bit_no */
		set_bit_no = xor & ~(xor - 1);

		/*
		 * Now divide elements in two sets by comparing rightmost set bit of xor
		 * with bit at same position in each element.
		 */
		for (i = 0; i < n; i++)
		{
			System.out.println("hello "+(arr[i] & set_bit_no));
			
			if (arr[i] == ((arr[i] & set_bit_no)))
			{
				x = x ^ arr[i];
			}
			else
			{
				y = y ^ arr[i];
			}
			

			/*
			 * if(arr[i] & set_bit_no)x = *x ^ arr[i]; XOR of first set elsey =
			 * *y ^ arr[i]; XOR of second set
			 */
		}
		
		System.out.println(x+" "+y);
	}

}
