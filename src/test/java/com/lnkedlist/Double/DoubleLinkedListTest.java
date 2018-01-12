package com.lnkedlist.Double;
import org.junit.Test;

import com.lnkedlist.common.LinkedListUitl;
public class DoubleLinkedListTest {
	
	@Test
	public void teseCreateDoubleLinkedList(){
		System.out.println("开始建双链表");
		Node node = new Node("0");
		Node headNode = DoubleLinkedListUitl.addNode(null, node);
		DoubleLinkedListUitl.addNode(headNode, new Node("1"));
		DoubleLinkedListUitl.addNode(headNode, new Node("2"));
		DoubleLinkedListUitl.addNode(headNode, new Node("3"));
		DoubleLinkedListUitl.addNode(headNode, new Node("4"));
		DoubleLinkedListUitl.addNode(headNode, new Node("5"));
		DoubleLinkedListUitl.addNode(headNode, new Node("6"));
		DoubleLinkedListUitl.addNode(headNode, new Node("7"));
		DoubleLinkedListUitl.addNode(headNode, new Node("8"));
		DoubleLinkedListUitl.addNode(headNode, new Node("9"));
		Node tailNode = new Node("10");
		DoubleLinkedListUitl.addNode(headNode, tailNode);
		System.out.println("双链表Create Over");
		System.out.println("now positive  traverse DoubleLinkedList");
		LinkedListUitl.traverseLinkedList(headNode, true);
		System.out.println("now reverse  traverse DoubleLinkedList");
		DoubleLinkedListUitl.reverseTraverseLinkedList(tailNode);
	}

}
