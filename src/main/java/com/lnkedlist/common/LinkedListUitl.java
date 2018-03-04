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
	 *
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
	 * 头节点被认为是第一个节点
	 */
	public static int getLinkedListLength(AbstractNode node){
		int lentgh = 0;
		while(node!=null){
			lentgh++;
			node = node.getNextNode();
		}
		return lentgh;
	}
	
	/**
	 * 获取倒数第index的元素
	 * 本程序将从头节点,index为0开始计算
	 * @param node2  头节点
	 * @param 指定的index元素
	 * @return
	 * 程序流程，先遍历到正序的index位置,记为引用2，此时头节点记为引用1
	 * 然后引用1和引用2同时遍历，直至引用2到末尾节点，此时的引用1既是目标值
	 */
	public static AbstractNode  getNodeOfReciprocal(AbstractNode node2,int targetIndex){
		int index = 0;
		AbstractNode node1 = node2;
		while(true){
			//++index理论上是先用index判断，然后index再++
			if(++index == targetIndex){
				break;
			}
			node2 = node2.getNextNode();
		}
		while(node2.getNextNode()!=null){
			node2 = node2.getNextNode();
			node1 = node1.getNextNode();
		}
		return node1;
	}
	
	/**
	 * 获取中间的节点
	 * @return
	 * 解法有两个：
	 * 1：先获取链表的长度，然后取其中间的节点
	 * 2：需要两个指针，一个一次移动两个节点,一个一次只移动一个节点。
	 * 快指针移动到全程，此时慢指针指向的节点就是中间节点，其实很容易理解
	 * 慢指针移动的节点是快节点移动的节点的一半，快节点走完了全程，慢节点就走完全程的一半，也就是到了中间节点
	 * 该方法可以获取中间节点并且只遍历一遍链表
	 */
	public static AbstractNode getNodeOfmiddle(AbstractNode fastNode ){
		AbstractNode slowNode = fastNode;
		while(fastNode!=null && fastNode.getNextNode()!=null){
			System.out.println("fast指针指向"+fastNode.getData());
			System.out.println("slow指针指向"+slowNode.getData());
			fastNode = fastNode.getNextNode().getNextNode();
			slowNode = slowNode.getNextNode();
		}
		return slowNode;
	}
	
	
		
}
