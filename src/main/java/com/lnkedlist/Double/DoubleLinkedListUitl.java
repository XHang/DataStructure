package com.lnkedlist.Double;

import com.lnkedlist.common.LinkedListUitl;

/**
 * 双链表工具类
 * @author Administrator
 *
 */
public class DoubleLinkedListUitl {

	/**
	 * 为双链表添加节点
	 * @param node 
	 * @return 头节点
	 */
	public static Node addNode(Node headNode,Node targetNode){
		if(headNode == null){
			return targetNode;
		}
		Node tailNode = (Node) LinkedListUitl.traverseLinkedList(headNode, false);
		tailNode.setNextNode(targetNode);
		targetNode.setPreNode(tailNode);
		targetNode.setNextNode(null);
		return headNode;
	}
}
