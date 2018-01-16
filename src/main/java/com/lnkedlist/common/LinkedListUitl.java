package com.lnkedlist.common;

import java.util.Comparator;


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
	
	/**
	 * 对链表进行排序
	 * 使用的是冒泡排序
	 * @param currentNode 链表的头节点
	 * @param comparable  比较器对象，比较两个节点哪个大
	 * @return  排序后的头节点
	 */
	public static AbstractNode sortLinkedList(AbstractNode currentNode,Comparator<AbstractNode> comparator){
		if(currentNode == null){
			return null;
		}
		int length = getLinkedListLength(currentNode);
		AbstractNode preNode = null;
		AbstractNode headNode = currentNode;
		AbstractNode postNode = null;
		for(int i=0;i<length;i++){
			//每一次内部循环后变量都要重置
			currentNode = headNode;
			preNode = null;
			postNode = null;
			for(int j=0;j<length-(i+1);j++){
				postNode = currentNode.getNextNode();
				if(comparator.compare(currentNode, postNode)>0){
					//要记录循环中的头节点，以便下一次循环能找到头节点
					if(j==0){
						headNode = postNode;
					}
					swap(preNode, currentNode, postNode);
					//需要交换节点位置话，左边的节点就是下一个循环的前一个节点
					preNode = postNode;
					//如果不需要交换节点位置，也需要为下一次循环记录节点值
				}else{
					if(j==0){
						headNode = currentNode;
					}
					preNode = currentNode;
					//记录下一个循环的节点值
					currentNode = postNode;
				}
			}
		}
		return headNode;
	}
	
	/**
	 * 交换节点1和节点2的位置
	 * @param preNode 节点1的前一个节点
	 * @param node1
	 * @param node2
	 */
	private  static void  swap(AbstractNode preNode,AbstractNode node1,AbstractNode node2){
		//如果这种情况成立，则说明节点1是头节点
		AbstractNode node3 = node2.getNextNode();
		if(preNode == null){
			node1.setNextNode(node3);
			node2.setNextNode(node1);
		}else{
			preNode.setNextNode(node2);
			node2.setNextNode(node1);
			node1.setNextNode(node3);
		}
		return ;
	}
	
	/**
	 * 获取链表的长度
	 * @param node  头节点
	 * @return
	 */
	public static int getLinkedListLength(AbstractNode node){
		int lentgh = 0;
		while(node!=null){
			lentgh++;
			node = node.getNextNode();
		}
		return lentgh;
	}
	
}
