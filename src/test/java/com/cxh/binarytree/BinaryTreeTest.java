package com.cxh.binarytree;

import org.junit.Test;

/**
 * 二叉树的测试程序-创建一个简单的二叉树
 * @author Administrator
 *
 */
public class BinaryTreeTest {
	@Test
	public void createBinaryTreeTest(){
		BinaryTree tree = new BinaryTree();
		tree.rootNode = new BinaryNode("1");
        /* 现在这颗树变成了这样
		        1
		      /   \
		    null  null     
         */
		tree.rootNode.leftChildNode = new BinaryNode("2");
		tree.rootNode.rightChildNode = new BinaryNode("3");
		/* 进一步进化
	        1
	      /   \
	     2      3
	   /    \    /  \
	 null null null null  
	 */
	tree.rootNode.leftChildNode.leftChildNode = new BinaryNode("4");
	//现在的树就如readme文件所说的那棵树了
	}
}
