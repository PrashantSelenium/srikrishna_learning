package com.practice.questions;

public class PositiveNegitive 
{
	public static void main (String args[])
	{
		System.out.println(Divisible_by_15(542000014));
	}
	
	static int mod_15ish(int x) {
		  // returns a number between 0 and 21 that is either x % 15
		  // or 15 + (x % 15), and returns 0 only for x == 0
		  x = (x & 0xF0F0F0F) + ((x >> 4) & 0xF0F0F0F);
		  
		  System.out.println(x);
		  x = (x & 0xFF00FF) + ((x >> 8) & 0xFF00FF);
		  System.out.println(x);
		  x = (x & 0xFFFF) + ((x >> 16) & 0xFFFF);
		  System.out.println(x);
		  // *1
		  x = (x & 0xF) + ((x >> 4) & 0xF);
		  System.out.println(x);
		  return x;
		}

		static boolean Divisible_by_15(int x) {
		  return ((x == 0) || (mod_15ish(x) == 5));
		}
}
