package com.cxh.binarytree;


/**
 * 二叉树的遍历
 * @author Administrator
 *
 */
public class BinaryTreeTraversal {
	
	
	public static BinaryTree tree;
	/**
	 * 中序遍历(递归)
	 */
	private void inorderTraversal(BinaryNode node){
		if(node == null){
			return ;
		}
		inorderTraversal(node.leftChildNode);
		System.out.print(node.key+"    ");
		inorderTraversal(node.rightChildNode);
	}
	
	/**
	 * 后序遍历(递归)
	 */
	private void postTraversal(BinaryNode node){
		if(node == null){
			return ;
		}
		postTraversal(node.leftChildNode);
		postTraversal(node.rightChildNode);
		System.out.print(node.key+"    ");
	}
	
	
	/**
	 * 前序遍历(递归)
	 * @param node
	 */
	private void preTraversal(BinaryNode node){
		if(node == null){
			return ;
		}
		System.out.print(node.key+"    ");
		preTraversal(node.leftChildNode);
		postTraversal(node.rightChildNode);
	}
	
	
	public void inorderTraversal(BinaryTree tree){
		inorderTraversal(tree.rootNode);
		System.out.println();
	}
	public void postTraversal(BinaryTree tree){
		postTraversal(tree.rootNode);
		System.out.println();
	}
	public void preTraversal(BinaryTree tree){
		preTraversal(tree.rootNode);
		System.out.println();
	}
	
	

}
