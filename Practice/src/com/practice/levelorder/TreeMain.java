package com.practice.levelorder;

public class TreeMain
{
	public static void main(String args[])
	{
		TreeImpl tree = new TreeImpl();

		tree.insert(50);
		tree.insert(25);
		tree.insert(75);
		tree.insert(12);
		tree.insert(37);
		tree.insert(43);
		tree.insert(30);
		tree.insert(33);
		tree.insert(87);
		tree.insert(93);
		tree.insert(97);
		tree.insert(74);
		tree.insert(76);
		tree.insert(77);
		tree.insert(100);
		
		tree.preorder();
		tree.newLine();
		
		tree.inorder();
		tree.newLine();
		
		tree.postorder();
		tree.newLine();
		
		tree.BFS();
		tree.newLine();
		
		System.out.println("Tree Height: "+tree.getHeight());
		tree.connectNextRight();
		
		
	}
}
