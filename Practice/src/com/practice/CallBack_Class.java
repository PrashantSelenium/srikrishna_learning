package com.practice;

public class CallBack_Class implements CallBack_Interface
{
	CallBack_Interface mCi;
	
	public void registerReceiver(CallBack_Interface mCi)
	{
		this.mCi = mCi;
		
		for (int i = 0; i < 10; i++)
			mCi.print(i);
	}

	@Override
	public void print(int i)
	{
		System.out.println("IMPL Class");
	}
}
