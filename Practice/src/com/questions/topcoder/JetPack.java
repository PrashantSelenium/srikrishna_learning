package com.questions.sotong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class JetPack
{
	static Weight[][] mPathMatrix;
	static boolean[] mIsVisited;
	static ArrayList<Data> mList = new ArrayList<Data>();
	static Data d;
	final static int INF = -1011;
	static Weight w;
	static final char VARIABLE = 'x';

	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		long start = System.currentTimeMillis();
		final int T = sc.nextInt();
		int totalPoints, totalRouts, problems;

		for (int i = 0; i < T; i++)
		{
			totalPoints = totalRouts = problems = 0;

			totalPoints = sc.nextInt();
			totalRouts = sc.nextInt();

			mPathMatrix = new Weight[totalPoints + 1][totalPoints + 1];
			
			mIsVisited = new boolean[totalPoints + 1];

			for (int j = 0; j < totalRouts; j++)
			{
				int row = sc.nextInt();
				int column = sc.nextInt();

				String stringWeight = sc.next();
				int currentWeight;
				
				w = mPathMatrix[row][column];
				
				if (w == null)
					w = new Weight();
				
				w.pathFound += 1;
				
				if (stringWeight.charAt(0) == 'x')
					currentWeight = INF;
				else
					currentWeight = Integer.parseInt(stringWeight);
				
				int[] source = w.weights;
				
				if (source == null)
				{
					source = new int[w.pathFound];
					source[0] = currentWeight;
				}
				else
				{
					source = new int[w.pathFound];
					for (int k = 0; k < w.pathFound - 1; k++)
						source[k] = w.weights[k];
					
					source[source.length - 1] = currentWeight;
				}
				
				w.weights = source;
				mPathMatrix[row][column] = w;
			}
			
			problems = sc.nextInt();
			for (int k = 0; k < problems; k++)
			{
				calculateDistance(sc.nextInt(), sc.nextInt());
			}
			
			System.out.println("");
		}
		
		System.out.println("Time: "+(System.currentTimeMillis() - start));
	}

	static void calculateDistance(int row, int column)
	{
		for (int i = 0; i < mIsVisited.length; i++)
			mIsVisited[i] = false;

		int[] mine = new int[100];
		mine[0] = row;
		mList.clear();
		getPaths(row, column, 1, mine);
		
		ArrayList<String> equations = new ArrayList<String>();
		for (int m = 0; m < mList.size(); m++)
			generateEquation(mList.get(m).data, 0, "", equations);
		
		if (equations.size() == 0)
			System.out.println("0 0");
		else if (equations.size() == 1)
			checkInfiniteSolutions(equations);
		else
			solveEquations(equations);
	}
	
	static void getPaths(int row, int column, int index, int[] mine)
	{
		if (mIsVisited[row] || row == column)
			return;

		mIsVisited[row] = true;
		
		for (int i = 1; i < mPathMatrix[row].length; i++)
		{
			if (mPathMatrix[row][i] != null && mPathMatrix[row][i].pathFound != 0  && i != column )
			{
				mine[index] = i;
				getPaths(i, column, index+1, mine);
			}
			else if (mPathMatrix[row][i] != null && i == column && mPathMatrix[row][i].pathFound != 0)
			{
				mine[index] = column;
				
				Data d = new Data();
				d.data = Arrays.copyOfRange(mine, 0, index+1);
				
				mList.add(d);
			}
		}
		return;
	}
	
	static int generateEquation(int[] path, int index, String str, ArrayList<String> equations)
	{
		if (index + 1 >= path.length)
			return -1;
		
		int row = path[index];
		int column = path[index + 1];
		
		
		if (mPathMatrix[row][column] == null)
		{
			return 10;
		}
		
		int[] weights = mPathMatrix[row][column].weights;
		int returnint = -10;
		for (int i = 0; i < weights.length; i++)
		{
			int temp = 0;
			if (weights[i] == INF)
				temp = 1011;
			else
				temp = weights[i];
			returnint = generateEquation(path, index + 1, str + temp + "-", equations);
		}

		if (returnint == -1)
		{
			for (int i = 0; i < weights.length; i++)
			{
				int temp = 0;
				if (weights[i] == INF)
					temp = 1011;
				else
					temp = weights[i];
				
				String s = str + temp + "-";
				s = s.substring(0, s.length() - 1);
				
//				System.out.println("Equations: "+s);
				equations.add(s);
			}
			
			return 100;
		}
		return 1000;
	}
	
	static void solveEquations(ArrayList<String> equations)
	{
		
		
		boolean[] isInfinity = new boolean[equations.size()];
		int minID = 0;
		int upperBound = 0;
		int currentSum = 0;
		
		for (int i = 0; i < equations.size(); i++)
		{
			String[] str = equations.get(i).split("-");
			
			for (int j = 0; j < str.length; j++)
			{
				if (Integer.parseInt(str[j]) == 1011)
				{
					isInfinity[i] = true;
					currentSum = 0;
					break;
				}
				else 
				{
					currentSum += Integer.parseInt(str[j]);
				}
			}
			
			if (!isInfinity[i])
			{
				if (upperBound < currentSum)
				{
					upperBound = currentSum;
					minID = i;
					currentSum = 0;
				}
			}
		}
		
		int count = 0;
		
		for (int i = 0; i < equations.size(); i++)
		{
			if (isInfinity[i])
				count++;
		}
		
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] mine = new ArrayList[count];
		count = 0;
		
		for (int i = 0; i < equations.size(); i++)
		{
			if (!isInfinity[i])
				continue;
		
			getValues(mine, count++, equations.get(i).split("-"), upperBound);
		}
		
		int list1 = 0, list2 = 0;
		int sum = 0;
		int numRoutes = 0;
		if (mine.length == 1)
		{
			for (int i = 0; i < mine[0].size(); i++, numRoutes++)
				sum += mine[0].get(i);
		}
		else
		{
			while (list1 < mine[0].size() || list2 < mine[1].size())
			{
				if (list1 < mine[0].size() && list2 < mine[1].size())
				{
					sum += Math.min(mine[0].get(list1++), mine[1].get(list2++));
					numRoutes++;
				}
				else if (list1 < mine[0].size())
				{
					sum += mine[0].get(list1++);
					numRoutes++;
				}
				else if (list2 < mine[1].size())
				{
					sum += mine[1].get(list2++);
					numRoutes++;
				}
			}
		}
		
		
		System.out.println((numRoutes+1) +" "+(sum + upperBound));
	}

	private static void getValues(ArrayList<Integer>[] mine, int count, String[] str, int upperBound)
	{
		mine[count] = new ArrayList<Integer>();

		int currentSum = 0;
		int k = 1;
		
		while (currentSum < upperBound)
		{
			int tempSum = 0;
			for (int i = 0; i < str.length; i++)
			{
				if (Integer.parseInt(str[i]) == 1011)
					tempSum += k;
				else
					tempSum += Integer.parseInt(str[i]);
			}
			
			currentSum = tempSum;
			if (currentSum < upperBound)
				mine[count].add(currentSum);
			
			k++;
		}
		
	}
	
	static void checkInfiniteSolutions(ArrayList<String> equations)
	{
		String[] str = equations.get(0).split("-");
		int count = 0;
		
		int sum = 0;
		
		for (int i = 0; i < str.length; i++)
		{
			if (Integer.parseInt(str[i]) == 1011)
			{
				System.out.println("inf");
				return;
			}
			else
			{
				count++;
				sum+=Integer.parseInt(str[i]);
			}
		}
		
		System.out.println((count) +" "+sum);
	}
}

class Data
{
	int[] data;
}
class Weight
{
	int pathFound = 0;
	int[] weights;
}
