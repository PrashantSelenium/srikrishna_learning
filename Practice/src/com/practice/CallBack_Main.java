package com.practice;

public class CallBack_Main extends CallBack_Class implements CallBack_Interface
{
	public static void main(String args[])
	{
		CallBack_Main m = new CallBack_Main();
		CallBack_Class c = new CallBack_Class();
		
		c.registerReceiver(m);
		
	}

	@Override
	public void print(int i)
	{
		super.print(i);
		System.out.println("in Class Main: "+i);
	}
}
