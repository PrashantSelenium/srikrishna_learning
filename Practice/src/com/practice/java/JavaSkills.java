package com.practice.java;


public class JavaSkills
{
	public static void main (String args[])
	{
		Base base = new Derived();
		base.add();
	}
}

class Base
{
	public static void add()
	{
		System.out.println("Base");
	}
}

class Derived extends Base
{
	public static void add()
	{
		System.out.println("Derived");
	}
}
