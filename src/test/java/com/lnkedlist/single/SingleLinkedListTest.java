package com.lnkedlist.single;

import org.junit.Test;

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
		SingleLinkedListUitl.traverseLinkedList(headNode, true);
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
		SingleLinkedListUitl.traverseLinkedList(headNode, true);
		headNode = SingleLinkedListUitl.removeNode(headNode, headNode);
		System.out.println("删除后的链表是");
		SingleLinkedListUitl.traverseLinkedList(headNode, true);
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
		SingleLinkedListUitl.traverseLinkedList(headNode, true);
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
		SingleLinkedListUitl.traverseLinkedList(headNode, true);
	}
	
	
}
