package com.questions.geeksforgeeks;


public class BitCount {

	public static void main (String args[])
	{
		int[] a = {199,19,15,24,26};
		
		for (int i = 0; i < a.length; i++)
			System.out.println(bitCount(a[i]));
		
		/*for (int i = 0; i < a.length; i++)
			System.out.println(Integer.toBinaryString(a[i]).length() - Integer.bitCount(a[i]));*/
	}
	
	public static int bitCount(int i) {
        // HD, Figure 5-2
	i = i - ((i >>> 1) & 0x55555555);
	
	i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
	i = (i + (i >>> 4)) & 0x0f0f0f0f;
	i = i + (i >>> 8);
	i = i + (i >>> 16);
	return i & 0x3f;
    }
}
