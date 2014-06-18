package com.practice;

import java.util.ArrayList;

public class DifferentObjects implements Cloneable
{
	B b;
	public DifferentObjects() 
	{
		b = new B();
		System.out.println("Object Created");
	}
	public static void main (String args[])
	{
		DifferentObjects o = new DifferentObjects();
		DifferentObjects diff = null;
		
		try 
		{
			diff = (DifferentObjects) o.clone();
			
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		o.b.list.add("hello hello");
		o.b.list.add("how are you");
		
		diff.b.list.add("am am am");
		diff.b.list.add("am am am");
		diff.b.list.add("am am am");
		diff.b.list.add("am am am");
		diff.b.list.add("am am am");
		
		System.out.println(o.b.list.size());
		System.out.println(diff.b.list.size());
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		
		DifferentObjects newobj = new DifferentObjects();
		newobj.b.list.addAll(this.b.list);
		return super.clone();
	}
	
	
}

class B
{
	ArrayList<String> list;
	
	B()
	{
		list = new ArrayList<String>();
		list.add("am b");
		System.out.println("Object B Created");
	}
	
	void add(String a)
	{
		list.add(a);
	}
}