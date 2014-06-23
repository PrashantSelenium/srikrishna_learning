package com.questions.geeksforgeeks;

public class ArrayCounting
{
	static int[] mInput = { 1, 3, 5, 4, 2 };
	static int[] mine = new int[mInput.length];

	public static void main(String args[])
	{
		arrange(mInput, 0, mInput.length - 1, 0);

		for (int i = 0; i < mInput.length; i++)
		{
			System.out.println(mInput[i] + " : " + mine[i]);
		}
	}

	static void arrange(int[] array, int low, int high, int index)
	{
		if (array.length <= 0)
			return;

		int pivort = 0;
		int left = pivort + 1, right = high, count = 0;

//		while (left <= right)
		{
			while (right > low && left < array.length && array[left] <= array[pivort])
			{
				left++;
				count++;
			}
			while (left < array.length && right >= 0 && array[right] <= array[pivort])
			{
				count++;
				right--;
			}

			right--;
			left++;

		}

		if (index < mine.length)
			mine[index] = count;

		low++;
		int[] myarray = new int[array.length - low];

		System.arraycopy(array, low, myarray, 0, array.length - low);

		arrange(myarray, 0, myarray.length - 1, ++index);
	}
}
