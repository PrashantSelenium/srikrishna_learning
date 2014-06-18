package com.practice.binarytree;

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
		
		/*tree.myorder();
		tree.newLine();*/
		
		tree.getMirror();
		tree.newLine();
		
		tree.maxsum();
		
		System.out.println(tree.getHeight());

		/*tree.delete(75);
		tree.newLine();
		tree.BFS();*/
		
		/*tree.delete(75);
		tree.newLine();
		tree.BFS();*/
		
//		tree.search(80);
		
	}
}
