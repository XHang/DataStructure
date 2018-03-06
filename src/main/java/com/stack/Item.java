package com.stack;

/**
 * 链表节点--链式栈的节点
 * @author Administrator
 *
 */
public class Item<T> {

	private T payload;
	
	private Item next;

	public T getPayload() {
		return payload;
	}

	public void setPayload(T payload) {
		this.payload = payload;
	}

	public Item getNext() {
		return next;
	}

	public void setNext(Item next) {
		this.next = next;
	}

	
	
	
}
