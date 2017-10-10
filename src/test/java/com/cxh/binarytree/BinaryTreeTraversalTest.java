package com.cxh.binarytree;

import org.junit.Test;

/**
 * 二叉树的遍历-测试类
 * @author Administrator
 *
 */
public class BinaryTreeTraversalTest {
	
	
	
	/**
	 * 为测试程序运行前创建一颗二叉树
	 * 形状大概是这样的 
	 */ 
	@Test
	public void binaryTreeTraversalTest(){
		BinaryTree  tree = new BinaryTree("1");
		tree.rootNode.leftChildNode = new Node("2");
		tree.rootNode.rightChildNode = new Node("3");
		tree.rootNode.leftChildNode.leftChildNode = new Node("4");
		tree.rootNode.leftChildNode.rightChildNode = new Node("5");
		
		BinaryTreeTraversal treeTraversal = new BinaryTreeTraversal();
		System.out.println("中序遍历.......");
		treeTraversal.inorderTraversal(tree);
		System.out.println("前序遍历.......");
		treeTraversal.preTraversal(tree);
		System.out.println("后序遍历.......");
		treeTraversal.postTraversal(tree);
	}
}
