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
}
