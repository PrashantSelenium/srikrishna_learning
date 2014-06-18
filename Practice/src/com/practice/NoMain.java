package com.practice;

public class NoMain 
{
	public static void main (String args[])
	{
		int a = 3, b = 5;
		a ^= b;
		a ^= (b ^= a);
		System.out.println(a+"\t"+b);
	}
	/*static void hello ()
	{
		System.out.println("hello hello 11");
	}
	static 
	{
		
		
		hello();
		System.out.println("hello hello");
		System.exit(0);
	}*/
}
