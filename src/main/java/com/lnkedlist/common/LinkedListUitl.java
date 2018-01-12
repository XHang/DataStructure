package com.lnkedlist.common;

import com.lnkedlist.AbstractNode;

/**
 * 链表公共工具类
 * @author Administrator
 *
 */
public class LinkedListUitl {

	/**
	 * 遍历整个链表，返回最后的节点
	 * @param preNode 头节点
	 * @param isprintln 是否需要在遍历过程中打印节点的值
	 * @return
	 */
	public  static AbstractNode traverseLinkedList(AbstractNode preNode,boolean isprintln){
		if(preNode == null){
			throw new RuntimeException("链表为空");
		}
		AbstractNode nextNode = preNode;
		//循环取preNode的下一个节点，直至为null，返回preNode
		while(nextNode!=null){
			preNode = nextNode;
			if(isprintln){
				System.out.println("当前节点的值为"+preNode.getData());
			}
			nextNode=preNode.getNextNode();
		}
		return  preNode;
	}
}
