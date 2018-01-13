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
		AbstractNode postNode = null;
		AbstractNode preNode = null;
		AbstractNode headNode = currentNode;
		for(int i=0;i<length;i++){
			currentNode = headNode;
			for(int j=0;j<length-(i+1);j++){
				if(comparator.compare(currentNode, currentNode.getNextNode())){
					
				}
			}
		}
		
		
		
		
		while(true){
			postNode = currentNode.getNextNode();
			//说明第一个节点比第二个节点大
			if(comparator.compare(currentNode, postNode)>0){
				sawp(preNode,currentNode,postNode);
			}
		}
	}
	
	/**
	 * 交换节点1和节点2的位置
	 * @param preNode 节点1的前一个节点
	 * @param node1
	 * @param node2
	 */
	private  static void  sawp(AbstractNode preNode,AbstractNode node1,AbstractNode node2){
		
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
