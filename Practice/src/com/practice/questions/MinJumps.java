package com.practice.questions;

public class MinJumps
{
	static int[] mInput = { 1, 3, 2, 1, 0, 9 };
	static String str = "";

	public static void main(String[] args)
	{
		getMinJump(mInput, 0, mInput.length - 1);
		System.out.println(str);
	}

	static int getIndex(int[] array, int index, int currentlength)
	{

		if (array[index] == 1 || array[index] == 0)
			return 1;

		int count = 1;
		int totalDistance = 0, temp = 0;
		while (count <= array[index])
		{
			totalDistance += getIndex(array, index + count, currentlength);

			count++;
		}
		return totalDistance;
	}

	static void getMinJump(int[] array, int low, int high)
	{
		int count = 0, distance = 0, tempindex = 0, tempdis = 0, total = 0, index = -1, length = 0;

		for (int i = 0; i < array.length;)
		{
			str += array[i] + "\t";
			total = array[i];
			if (total == 0 || total == 1)
			{
				length++;
				i++;
				continue;
			}

			length++;
			count = 1;
			distance = 0;
			index = -1;
			tempindex = 0;
			tempdis = 0;

			while (count <= total && i < array.length - 1)
			{
				index = count + i;

				if (index < array.length)
				{
					distance = array[index];

					int mine = getIndex(array, index, i + total);
					System.out.println(index + "\t" + mine);
					if (distance == 0)
						distance = 1;

					if (distance < tempdis)
					{
						distance = tempdis;
						index = tempindex;
					}

					tempdis = distance;
					tempindex = index;

				}
				count++;
			}

			if (index < array.length && index != -1)
				i = index;
			else if (index == -1)
				i++;

			if (distance >= array.length)
			{
				str += array[array.length - 1] + "\t";
				i = array.length;
			}

		}
	}
}
