package com.cxh.binarytree;
/**
 * 二叉树的节点
 * @author Administrator
 *
 */
public class BinaryNode {
	
	public String key;
	
	public BinaryNode leftChildNode;
	
	public BinaryNode rightChildNode;



	/**
	 * 创建一个新的节点
	 * @param key 节点的key
	 */
	public BinaryNode(String key){
		this.key=key;
		//一个新的节点，它的左右子节点肯定为空
		this.leftChildNode=null;
		this.rightChildNode=null;
	}
	

}
