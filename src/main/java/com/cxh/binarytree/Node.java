package com.cxh.binarytree;
/**
 * 二叉树的节点
 * @author Administrator
 *
 */
public class Node {
	
	public String key;
	
	public  Node leftChildNode;
	
	public Node rightChildNode;



	/**
	 * 创建一个新的节点
	 * @param key 节点的key
	 */
	public Node(String key){
		this.key=key;
		//一个新的节点，它的左右子节点肯定为空
		this.leftChildNode=null;
		this.rightChildNode=null;
	}
	

}
