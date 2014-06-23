package com.practice.standredproblems;

import java.util.ArrayList;
import java.util.List;

import com.questions.geeksforgeeks.MaxNumber;

public class ProducerConsumer
{
	public static int MAX_COUNT = 10;
	public static void main (String args[])
	{
		List<Integer> mList = new ArrayList<Integer>();
		
		Thread produce = new Thread(new Producer(mList), "PRODUCER");
		Thread consume = new Thread(new Producer(mList), "CONSUMER");
		
		produce.start();
		consume.start();
	}
}


class Producer implements Runnable 
{

	List<Integer> mList;
	public Producer (List<Integer> list)
	{
		mList = list;
	}
	@Override
	public void run()
	{
		for (int i = 0; i < 20; i++)
		{
			try
			{
				produce(i);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public void produce(int value) throws InterruptedException
	{
		synchronized (mList)
		{
			if (mList.size() >= 10)
				mList.wait();
			else
			{
				mList.add(value);
				mList.notifyAll();
			}
		}
	}
	
}

class Consumer implements Runnable
{

	List<Integer> mList;
	public Consumer (ArrayList<Integer> list)
	{
		mList = list;
	}
	@Override
	public void run()
	{
		try
		{
			consume();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
	public void consume() throws InterruptedException
	{
		synchronized (mList)
		{
			while (true)
			{
				if (mList.isEmpty())
				{
					System.out.println("CONSUMER Wait");
					mList.wait();
				}
				else
				{
					System.out.println(mList.remove(mList.size() - 1));
					mList.notifyAll();
				}
			}
		}
	}
}