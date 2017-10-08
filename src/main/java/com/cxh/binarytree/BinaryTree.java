package com.cxh.binarytree;
/**
 * 二叉树模型
 * @author Administrator
 */
public class BinaryTree {
	Node rootNode;
	
	/**
	 * 创建一个只有根节点的树
	 * @param key 根节点的key
	 */
	BinaryTree(String key){
		rootNode = new Node(key);
	}
	/**
	 * 创建一颗空树
	 */
	BinaryTree(){
		rootNode =null;
	}
	
}
