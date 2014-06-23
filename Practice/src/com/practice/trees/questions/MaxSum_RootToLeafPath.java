package com.practice.trees.questions;

public class MaxSum_RootToLeafPath
{
	static StaticTree.Structure mTreeRootNode;
	static StaticTree mTreeObject;

	public static void main(String args[])
	{
		mTreeObject = new StaticTree();
		mTreeRootNode = mTreeObject.buildTree();
		
		int[] array = new int[mTreeObject.height(mTreeRootNode)];

		System.out.println(getMaxSumPath(mTreeRootNode, array, 0)[1]);
		
		System.out.println("");
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i]+" ");

	}

	private static int[] getMaxSumPath(StaticTree.Structure node, int[] array, int height)
	{
		if (node == null)
			return new int[]{0, 0};

		int[] left = getMaxSumPath(node.leftChild , array, height + 1);
		int[] right = getMaxSumPath(node.rightChild , array, height + 1);

		int[] data = new int[2];
		if (left[1] >= right[1])
		{
			data[0] = node.value;
			data[1] = node.value + left[1];

			array[height] = left[0];
			System.out.println("Left: "+data[1]);
			return data;
		}
		else
		{
			data[0] = node.value;
			data[1] = node.value + right[1];
			
			array[height] = right[0];
			System.out.println("Right: "+data[1]);
			return data;
		}
	}

}
