package com.lnkedlist.single;

import org.junit.Test;

import com.lnkedlist.common.LinkedListUitl;

public class SingleLinkedListTest {
	@Test
	public void testCreateLinkedList(){
		Node headNode = SingleLinkedListUitl.addNode(null, "1");
		SingleLinkedListUitl.addNode(headNode, "2");
		SingleLinkedListUitl.addNode(headNode, "3");
		SingleLinkedListUitl.addNode(headNode, "4");
		SingleLinkedListUitl.addNode(headNode, "5");
		SingleLinkedListUitl.addNode(headNode, "6");
		SingleLinkedListUitl.addNode(headNode, "7");
		SingleLinkedListUitl.addNode(headNode, "8");
		SingleLinkedListUitl.addNode(headNode, "9");
		LinkedListUitl.traverseLinkedList(headNode, true);
	}
	
	@Test
	public void testRemoveNode(){
		Node headNode = SingleLinkedListUitl.addNode(null, "1");
		SingleLinkedListUitl.addNode(headNode, "2");
		SingleLinkedListUitl.addNode(headNode, "3");
		SingleLinkedListUitl.addNode(headNode, "4");
		SingleLinkedListUitl.addNode(headNode, "5");
		SingleLinkedListUitl.addNode(headNode, "6");
		Node targeNode = new Node("7");
		SingleLinkedListUitl.addNode(headNode, targeNode);
		SingleLinkedListUitl.addNode(headNode, "8");
		SingleLinkedListUitl.addNode(headNode, "9");
		SingleLinkedListUitl.addNode(headNode, "10");
		System.out.println("原链表是--------");
		LinkedListUitl.traverseLinkedList(headNode, true);
		headNode = SingleLinkedListUitl.removeNode(headNode, headNode);
		System.out.println("删除后的链表是");
		LinkedListUitl.traverseLinkedList(headNode, true);
	}
	
	/**
	 * 逆序建表
	 */
	@Test
	public void reverseCreateLinkedList(){
		Node headNode = SingleLinkedListUitl.addNodeFromHead(null, new Node("1"));
		headNode = SingleLinkedListUitl.addNodeFromHead(headNode, new Node("2"));
		headNode = SingleLinkedListUitl.addNodeFromHead(headNode, new Node("3"));
		headNode = SingleLinkedListUitl.addNodeFromHead(headNode, new Node("4"));
		headNode = SingleLinkedListUitl.addNodeFromHead(headNode, new Node("5"));
		headNode = SingleLinkedListUitl.addNodeFromHead(headNode, new Node("6"));
		headNode = SingleLinkedListUitl.addNodeFromHead(headNode, new Node("7"));
		headNode = SingleLinkedListUitl.addNodeFromHead(headNode, new Node("8"));
		headNode = SingleLinkedListUitl.addNodeFromHead(headNode, new Node("9"));
		LinkedListUitl.traverseLinkedList(headNode, true);
	}
	/**
	 * 翻转链表
	 */
	@Test
	public void reverseLinkedList(){
		Node headNode = SingleLinkedListUitl.addNodeFromHead(null, new Node("1"));
		headNode = SingleLinkedListUitl.addNodeFromHead(headNode, new Node("2"));
		headNode = SingleLinkedListUitl.addNodeFromHead(headNode, new Node("3"));
		headNode = SingleLinkedListUitl.addNodeFromHead(headNode, new Node("4"));
		headNode = SingleLinkedListUitl.addNodeFromHead(headNode, new Node("5"));
		headNode = SingleLinkedListUitl.addNodeFromHead(headNode, new Node("6"));
		headNode = SingleLinkedListUitl.addNodeFromHead(headNode, new Node("7"));
		headNode = SingleLinkedListUitl.addNodeFromHead(headNode, new Node("8"));
		headNode = SingleLinkedListUitl.addNodeFromHead(headNode, new Node("9"));
		//头插法生成的链表是9,8,7,6,5,4,3,2,1
		headNode = SingleLinkedListUitl.reverseLinkedLinkByLoop(headNode);
		LinkedListUitl.traverseLinkedList(headNode, true);
	}
	
	/**
	 * 创建一个环形链表，并将其遍历
	 * 
	 */
	@Test
	public void createCircleLinkedListTest(){
		Node headNode = SingleLinkedListUitl.addNodeforCircle(null, new Node("1"));
		SingleLinkedListUitl.addNodeforCircle(headNode, new Node("2"));
		SingleLinkedListUitl.addNodeforCircle(headNode, new Node("3"));
		SingleLinkedListUitl.addNodeforCircle(headNode, new Node("4"));
		SingleLinkedListUitl.addNodeforCircle(headNode, new Node("5"));
		SingleLinkedListUitl.addNodeforCircle(headNode, new Node("6"));
		SingleLinkedListUitl.addNodeforCircle(headNode, new Node("7"));
		SingleLinkedListUitl.addNodeforCircle(headNode, new Node("8"));
		SingleLinkedListUitl.addNodeforCircle(headNode, new Node("9"));
		//这是一个死循环，实际将永远遍历下去
		//LinkedListUitl.traverseLinkedList(headNode, true);
	}
	
	@Test
	public void isCircleLinkedListTest(){
		Node headNode = SingleLinkedListUitl.addNodeforCircle(null, new Node("1"));
		SingleLinkedListUitl.addNodeforCircle(headNode, new Node("2"));
		SingleLinkedListUitl.addNodeforCircle(headNode, new Node("3"));
		SingleLinkedListUitl.addNodeforCircle(headNode, new Node("4"));
		SingleLinkedListUitl.addNodeforCircle(headNode, new Node("5"));
		SingleLinkedListUitl.addNodeforCircle(headNode, new Node("6"));
		SingleLinkedListUitl.addNodeforCircle(headNode, new Node("7"));
		SingleLinkedListUitl.addNodeforCircle(headNode, new Node("8"));
		SingleLinkedListUitl.addNodeforCircle(headNode, new Node("9"));
		System.out.println("这个链表是否属于环形链表："+SingleLinkedListUitl.isCircleLinkedList(headNode));
	}
	
	/**
	 * 测试获取有环链表的入口节点
	 */
	@Test
	public void getIntoNodeIfCircleLinkedListTest(){
		Node headnode = SingleLinkedListUitl.addNode(null, new Node("1"));
		SingleLinkedListUitl.addNode(headnode, new Node("2"));
		SingleLinkedListUitl.addNode(headnode, new Node("3"));
		SingleLinkedListUitl.addNode(headnode, new Node("4"));
		Node node6 = new Node("6");
		SingleLinkedListUitl.addNode(headnode, new Node("5"));
		SingleLinkedListUitl.addNode(headnode, node6);
		SingleLinkedListUitl.addNode(headnode, new Node("7"));
		SingleLinkedListUitl.addNode(headnode, new Node("8"));
		Node node9 = new Node("9");
		SingleLinkedListUitl.addNode(headnode,node9);
		node9.setNextNode(node6);
		System.out.println("这个有环链表的入口节点在"+SingleLinkedListUitl.getIntoNodeIfCircleLinkedList(headnode).getData());
	}
	
	/**
	 * 测试两个链表是否相交
	 */
	@Test
	public void isIntersectTest(){
		Node headnode1 = SingleLinkedListUitl.addNode(null, new Node("1"));
		SingleLinkedListUitl.addNode(headnode1, new Node("2"));
		SingleLinkedListUitl.addNode(headnode1, new Node("3"));
		SingleLinkedListUitl.addNode(headnode1, new Node("4"));
		SingleLinkedListUitl.addNode(headnode1, new Node("5"));
		Node node6 = new Node("6");
		SingleLinkedListUitl.addNode(headnode1, node6);
		SingleLinkedListUitl.addNode(headnode1, new Node("7"));
		
		Node headnode2 =SingleLinkedListUitl.addNode(null, new Node("1"));
		SingleLinkedListUitl.addNode(headnode2, new Node("2"));
		SingleLinkedListUitl.addNode(headnode2, new Node("3"));
		Node node4 =  new Node("4");
		SingleLinkedListUitl.addNode(headnode2,node4);
		node4.setNextNode(node6);
		
		System.out.println("链表1和链表2是否相交"+SingleLinkedListUitl.isIntersect(headnode1, headnode2));
	}
	/**
	 * 测试有环的两个链表是否相交
	 */
	@Test
	public void isIntersectIfCircleTest(){
		Node headNode0 = SingleLinkedListUitl.addNode(null, new Node("1"));
		SingleLinkedListUitl.addNode(headNode0, new Node("2"));
		SingleLinkedListUitl.addNode(headNode0, new Node("3"));
		SingleLinkedListUitl.addNode(headNode0, new Node("4"));
		Node node5 = new Node("5");
		SingleLinkedListUitl.addNode(headNode0, node5);
		SingleLinkedListUitl.addNode(headNode0, new Node("6"));
		SingleLinkedListUitl.addNode(headNode0, new Node("7"));
		SingleLinkedListUitl.addNode(headNode0, new Node("8"));
		Node node9 = new Node("9");
		SingleLinkedListUitl.addNode(headNode0, node9);
		node9.setNextNode(node5);
		
		Node headNode1 = SingleLinkedListUitl.addNode(null, new Node("A"));
		SingleLinkedListUitl.addNode(headNode1, new Node("B"));
		SingleLinkedListUitl.addNode(headNode1, new Node("C"));
		SingleLinkedListUitl.addNode(headNode1, new Node("D"));
		Node nodeE = new Node("E");
		SingleLinkedListUitl.addNode(headNode1, nodeE);
		nodeE.setNextNode(node5);
		
		System.out.println("两个链表，其中一个链表是有环链表，则两个链表是相交关系吗？："+SingleLinkedListUitl.isIntersectIfCircle(headNode0, headNode1));
	}

	/**
	 * 获取无环链表交叉节点
	 */
	@Test
	public void getIntersectNodeTest(){
		Node headnode1 = SingleLinkedListUitl.addNode(null, new Node("1"));
		SingleLinkedListUitl.addNode(headnode1, new Node("2"));
		SingleLinkedListUitl.addNode(headnode1, new Node("3"));
		SingleLinkedListUitl.addNode(headnode1, new Node("4"));
		SingleLinkedListUitl.addNode(headnode1, new Node("5"));
		Node node6 = new Node("6");
		SingleLinkedListUitl.addNode(headnode1, node6);
		SingleLinkedListUitl.addNode(headnode1, new Node("7"));
		
		Node headnode2 =SingleLinkedListUitl.addNode(null, new Node("1"));
		SingleLinkedListUitl.addNode(headnode2, new Node("2"));
		SingleLinkedListUitl.addNode(headnode2, new Node("3"));
		Node node4 =  new Node("4");
		SingleLinkedListUitl.addNode(headnode2,node4);
		node4.setNextNode(node6);
		
		System.out.println("两个无环链表交叉的节点是"+SingleLinkedListUitl.getIntersectNode(headnode1, headnode2).getData());
	}
}
