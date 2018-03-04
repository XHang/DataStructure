package com.lnkedlist.single;

import java.util.Objects;

import com.lnkedlist.AbstractNode;

/**
 * 单链表的节点对象
 * @author Mr-hang
 *
 */
public class Node  extends AbstractNode{
	private String data;
	
	private Node nextNode;
	
	/**
	 * 给定值和下一个节点的引用，创建节点
	 * @param data
	 * @param nextNode
	 */
	public Node(String data,Node nextNode){
		this.data = data;
		this.nextNode = nextNode;
	}
	
	/**
	 * 只给定节点的数据创建节点
	 * @param data
	 */
	public Node(String data){
		this(data,null);
	}
	

	/**
	 * 得到节点数据
	 * @return
	 */
	@Override
	public String getData() {
		return data;
	}
	/**
	 * 设置节点数据
	 * @param data
	 */
	@Override
	public void setData(String data) {
		this.data = data;
	}
	
	/**
	 * 得到下一个节点的引用
	 * @return
	 */
	@Override
	public Node getNextNode() {
		return nextNode;
	}
	/**
	 * 设置下一个节点的引用
	 * @param nextNode
	 */
	@Override
	public void setNextNode(AbstractNode nextNode) {
		if(nextNode !=null &&!(nextNode instanceof Node) ){
			throw new IllegalArgumentException("nextNode Only Allowed is SingleLinkedList");
		}
		this.nextNode = (Node)nextNode;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj==null || !(obj instanceof Node)){
			return false;
		}
		Node otherNode = (Node)obj;
		if(otherNode.hashCode()==this.hashCode() && Objects.equals(otherNode.data, this.data)){
			return true;
		}
		return false;
	}
	
}
