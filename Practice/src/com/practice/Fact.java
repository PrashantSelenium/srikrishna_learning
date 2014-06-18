package com.practice;


public class Fact {
	
	String str = "";
	public Integer getFact(int num)
	{
		if (num <= 1)
			return num;
		else
			return num * getFact(num-1);
	}
	
	public void makeString(String str)
	{
		String temp = str;
		String[] output = new String [2];
		for (int i = 0 ; i < str.length(); i++)
		{
//			System.out.println("String str: "+str);
			output = getAnagram(str);
			System.out.println(str.charAt(0)+output[0]);
			System.out.println(str.charAt(0)+output[1]);
			str = shiftRight(str.toCharArray());
		}
	}
	public String[] getAnagram(String name)
	{
		if (name.length() <= 2)
		{
			return rotate(name);
		}
		else
		{
			return getAnagram(name.substring(1));
		}
	}
	
	public static String shiftRight( char [] letters )
	{
	    Character last = letters[letters.length-1];  
	    if(letters.length >1)
	    { 
	        for( int index =letters.length-2; index >= 0 ; index-- )
	        {
	            letters[index+1] = letters [index];
	        }
	    }
	    
	    letters[0] = last;
	    String output = new String(letters);
	    return output;
	}
	
	public String[] rotate (String name)
	{
		String mine[] = new String[2];
		mine[0] = new String(new char[] {name.charAt(0), name.charAt(1)});
		mine[1] = new String(new char[] {name.charAt(1), name.charAt(0)});
		return mine;
	}
	
	public static int getFibo (int n)
	{
		if (n <= 1)
			return n;
		
		return getFibo((n - 1) + (n - 2));
	}
	
	public static void main (String args[])
	{
		Fact fact = new Fact();
//		fact.getFact(4);
//		fact.makeString("cat");
		System.out.println(fact.getFact(60));
	}
}
