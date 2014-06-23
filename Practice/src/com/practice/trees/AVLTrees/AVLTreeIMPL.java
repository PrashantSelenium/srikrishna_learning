package com.practice.trees.AVLTrees;

import java.util.LinkedList;
import java.util.Queue;

public class AVLTreeIMPL
{
	Node start = null;
	Node mImBalanceNode = null;

	public void insert(int data)
	{
		Node mNewNode = new Node(data);

		if (start == null)
		{
			start = mNewNode;
			start.setParent(null);
			return;
		}

		Node mCurrentNode = start;

		boolean mCondition = true;
		while (mCondition)
		{
			if (mNewNode.getData() <= mCurrentNode.getData())
			{
				if (mCurrentNode.getleft() == null)
				{
					mCurrentNode.setLeft(mNewNode);
					mNewNode.setParent(mCurrentNode);
					mCondition = false;
				}
				else
					mCurrentNode = mCurrentNode.getleft();
			}
			else
			{
				if (mCurrentNode.getRight() == null)
				{
					mCurrentNode.setRight(mNewNode);
					mNewNode.setParent(mCurrentNode);
					mCondition = false;
				}
				else
					mCurrentNode = mCurrentNode.getRight();
			}
		}
		System.out.print("Inserted " + data + " ");
		BFS();

		calculateBF(mNewNode.getParent());
		System.out.println("\n");
		printBF(mNewNode);

		Node mImbalanceNode = checkImBalance(mNewNode.getParent());

		if (mImbalanceNode != null)
		{
			if (mImbalanceNode.getbf() == 2)
			{
				if (mNewNode.getData() > mImbalanceNode.getleft().getData())
					doubleLeft(mImbalanceNode, mNewNode);
				else
					singleLeft(mImbalanceNode, mNewNode);

				System.out.print("Modified..");
				BFS();
			}
			else if (mImbalanceNode.getbf() == -2)
			{
				if (mNewNode.getData() < mImbalanceNode.getRight().getData())
					doubleRight(mImbalanceNode, mNewNode);
				else
					singleRight(mImbalanceNode, mNewNode);

				System.out.print("Modified..");
				BFS();
			}

		}

		System.out.println("\n");
	}

	public void printBF(Node node)
	{
		if (node == null)
			return;

		System.out.println(node.getData() + " BF: " + node.getbf());

		printBF(node.getParent());
	}

	public Node checkImBalance(Node node)
	{
		if (node != null)
		{
			if (node.getbf() <= 1 && node.getbf() >= -1)
				node = checkImBalance(node.getParent());
			else
				return node;

		}
		return node;

	}

	public void calculateBF(Node node)
	{
		if (node == null)
			return;

		if (node.getleft() != null && node.getRight() != null)
		{
			int left = getHeight(node.getleft());
			int right = getHeight(node.getRight());
			

//			System.out.println("\n" + left + "   " + right);
			node.setbf(left - right);
		}

		else if (node.getleft() != null)
			node.setbf(getHeight(node.getleft()));

		else if (node.getRight() != null)
			node.setbf(-getHeight(node.getRight()));

		calculateBF(node.getParent());

	}

	public int getHeight(Node child)
	{
		
		if (child == null)
			return 0;
		int heightLeft = getNewH(child.getleft());
		int heightRight = getNewH(child.getRight());

		if (heightLeft > heightRight)
			return heightLeft + 1;
		else
			return heightRight + 1;

		/*if (child.getleft() == null && child.getRight() == null)
			return 1;

		int mLeft = 1, mRight = 1;

		Queue<Node> queue = new LinkedList<Node>();
		queue.clear();
		queue.add(child);

		while (!queue.isEmpty())
		{
			Node n = queue.remove();

			if (n.getleft() != null)
			{
				mLeft++;
				queue.add(n.getleft());
			}
			if (n.getRight() != null)
			{
				mRight++;
				queue.add(n.getRight());
			}

		}

		if (mLeft >= mRight)
			return mLeft;
		else
			return mRight;*/
	}

	public int getNewH(Node t)
	{
		if (t == null)
			return 0;
		int heightLeft = getNewH(t.getleft());
		int heightRight = getNewH(t.getRight());

		if (heightLeft > heightRight)
			return heightLeft + 1;
		else
			return heightRight + 1;
	}

	public void singleLeft(Node imbalanceNode, Node newNode)
	{
		System.out.println("Single Left.");
		
		Node mTempLeft = imbalanceNode.getleft();
		Node mTempParent = imbalanceNode.getParent();
		Node mTempLeft_Right = mTempLeft.getRight();
		
		mTempLeft.setRight(imbalanceNode);
		imbalanceNode.setParent(mTempLeft);
		imbalanceNode.setLeft(mTempLeft_Right);
		mTempLeft.setParent(mTempParent);
		
		if (mTempParent.getRight().getData() == imbalanceNode.getData())
			mTempParent.setRight(mTempLeft);
		else 
			mTempParent.setLeft(mTempLeft);
	}

	public void doubleLeft(Node imbalanceNode, Node newNode)
	{
		System.out.println("Double Left.");
		
		Node mTempLeft = imbalanceNode.getleft(); // Left Node
		Node mTempRight = mTempLeft.getRight();	  // Left-Right Node
		Node mRootParent = imbalanceNode.getParent(); // Imbalance Parent
		
		Node mTempRight_Left = mTempRight.getleft();
		Node mTempRight_Right = mTempRight.getRight();
		
		mTempLeft.setRight(mTempRight_Left);
		imbalanceNode.setLeft(mTempRight_Right);
		
		if (mTempRight_Left != null)
			mTempRight_Left.setParent(mTempLeft);
		if (mTempRight_Right != null)
			mTempRight_Right.setParent(imbalanceNode);
		
		mTempRight.setLeft(mTempLeft);
		mTempRight.setRight(imbalanceNode);
		mTempRight.setParent(mRootParent);

		mTempLeft.setParent(mTempRight);
		imbalanceNode.setParent(mTempRight);


		if (mRootParent == null)
		{
			start = mTempRight;
		}
		else
			mTempRight.setParent(mRootParent);

		calculateBF(mTempRight.getleft());
		calculateBF(mTempRight.getRight());

	}

	public void singleRight(Node imbalanceNode, Node newNod)
	{
		System.out.println("Single Right.");

		Node mTempRight = imbalanceNode.getRight();
		Node mTempParent = imbalanceNode.getParent();
		Node mTempRight_Left = mTempRight.getleft();
		mTempRight.setLeft(imbalanceNode);

		imbalanceNode.setRight(mTempRight_Left);

		if (mTempRight_Left != null)
			mTempRight_Left.setParent(imbalanceNode);
		// imbalanceNode.setLeft(null);

		imbalanceNode.setParent(mTempRight);
		mTempRight.setParent(mTempParent);
//		mTempParent.setRight(mTempRight);
		
		if (mTempParent.getRight().getData() == imbalanceNode.getData())
			mTempParent.setRight(mTempRight);
		else
			mTempParent.setLeft(mTempRight);

		calculateBF(mTempRight.getleft());
		calculateBF(mTempRight.getRight());
		calculateBF(mTempRight.getParent());
	}

	public void doubleRight(Node imbalanceNode, Node newNod)
	{
		System.out.println("Double Right.");

		Node mTempRight = imbalanceNode.getRight(); // Left Node
		Node mTempLeft = mTempRight.getleft();	  // Left-Right Node
		Node mRootParent = imbalanceNode.getParent(); // Imbalance Parent
		
		Node mTempLeft_Left = mTempLeft.getleft();
		Node mTempLeft_Right = mTempLeft.getRight();
		
		mTempRight.setLeft(mTempLeft_Right);
		imbalanceNode.setRight(mTempLeft_Left);
		
		if (mTempLeft_Left != null)
			mTempLeft_Left.setParent(imbalanceNode);
		if (mTempLeft_Right != null)
			mTempLeft_Right.setParent(mTempRight);
		
		mTempLeft.setLeft(imbalanceNode);
		mTempLeft.setRight(mTempRight);

		mTempRight.setParent(mTempLeft);
		imbalanceNode.setParent(mTempLeft);


		if (mRootParent == null)
		{
			start = mTempLeft;
		}
		else
			mTempLeft.setParent(mRootParent);

		calculateBF(mTempLeft.getleft());
		calculateBF(mTempLeft.getRight());

	
	}

	public void BFS()
	{
		Node temp = start;

		if (temp == null)
			return;

		System.out.print("BFS: ");

		Queue<Node> queue = new LinkedList<Node>();
		queue.clear();
		queue.add(temp);

		while (!queue.isEmpty())
		{
			Node n = queue.remove();
			System.out.print(n.getData() + " ");

			if (n.getleft() != null)
				queue.add(n.getleft());
			if (n.getRight() != null)
				queue.add(n.getRight());
		}

		// System.out.println("\n");
	}
}
