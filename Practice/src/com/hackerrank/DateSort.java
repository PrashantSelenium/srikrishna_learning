package com.hackerrank;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DateSort
{
	public static void main (String args[])
	{
		String[] str = new String[] {"10/12/2012",
				"10/12/2013",
				"10/12/2009"};
		sort(str);
	}
	
	static void sort(String[] str)
	{
		ArrayList<String> list= new ArrayList<String>();
		
		for (int i = 0; i< str.length; i++)
		{
			list.add(str[i]);
		}
		
		Collections.sort(list, new Comparator<String>() {
	        DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
	        @Override
	        public int compare(String o1, String o2) {
	            try {
	                return f.parse(o1).compareTo(f.parse(o2));
	            } catch (ParseException e) {
	                throw new IllegalArgumentException(e);
	            }
	        }
	    });
		
		for (int i = 0; i < list.size(); i++)
		{
			str[i] = list.get(i);
		}
		
		for (int i = 0; i < str.length; i++)
		{
			System.out.println(str[i]);
		}
		
		
	}
	
}
