package com.lnkedlist.common;

import org.junit.Test;

import com.lnkedlist.LinkedListComparator;
import com.lnkedlist.single.Node;
import com.lnkedlist.single.SingleLinkedListUitl;

public class LinkedListUitlTest {

	@Test
	public void sortTest(){
		System.out.println("create a out of order LinkedList");
		Node head =  SingleLinkedListUitl.addNode(null, "3");
		SingleLinkedListUitl.addNode(head, "1");
		SingleLinkedListUitl.addNode(head, "6");
		SingleLinkedListUitl.addNode(head, "4");
		SingleLinkedListUitl.addNode(head, "5");
		SingleLinkedListUitl.addNode(head, "3");
		SingleLinkedListUitl.addNode(head, "2");
		SingleLinkedListUitl.addNode(head, "9");
		SingleLinkedListUitl.addNode(head, "0");
		SingleLinkedListUitl.addNode(head, "5");
		System.out.println("now sort for LInkedList");
		head = (Node) LinkedListUitl.sortLinkedList(head, new LinkedListComparator());
		System.out.println("now traverse LinkedList");
		LinkedListUitl.traverseLinkedList(head, true);
	}
	
	
	@Test
	public void getNodeOfRecipe(){
		int index = 3;
		Node head =  SingleLinkedListUitl.addNode(null, "0");
		SingleLinkedListUitl.addNode(head, "2");
		SingleLinkedListUitl.addNode(head, "3");
		SingleLinkedListUitl.addNode(head, "4");
		SingleLinkedListUitl.addNode(head, "5");
		SingleLinkedListUitl.addNode(head, "6");
		SingleLinkedListUitl.addNode(head, "7");
		SingleLinkedListUitl.addNode(head, "8");
		SingleLinkedListUitl.addNode(head, "9");
		Node targetNode = (Node) LinkedListUitl.getNodeOfReciprocal(head, index);
		System.out.println("倒叙第"+index+"节点的值是"+targetNode.getData());
	}
	
	/**
	 * 获取链表中间节点测试
	 */
	@Test
	public void getNodeOfmiddleTest(){
		Node head =  SingleLinkedListUitl.addNode(null, "0");
		SingleLinkedListUitl.addNode(head, "1");
		SingleLinkedListUitl.addNode(head, "2");
		SingleLinkedListUitl.addNode(head, "3"); 
		SingleLinkedListUitl.addNode(head, "4");
		SingleLinkedListUitl.addNode(head, "5");
		SingleLinkedListUitl.addNode(head, "6");
		SingleLinkedListUitl.addNode(head, "7");
		SingleLinkedListUitl.addNode(head, "8");
		Node targetNode = (Node) LinkedListUitl.getNodeOfmiddle(head);
		System.out.println("中间节点的值是"+targetNode.getData());
	}
	
	
}
