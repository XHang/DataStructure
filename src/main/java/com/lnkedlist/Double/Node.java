package com.lnkedlist.Double;

import com.lnkedlist.AbstractNode;

/**
 * 双链表的节点
 * @author Mr-hang
 * ps:为了方便，把对象的属性设为public，真正开发请使用setting/getting
 *
 */
public class Node extends AbstractNode {
	
	private String data;
	
	public Node(String data) {
		super();
		this.data = data;
	}

	private Node preNode;
	
	private Node nextNode;

	@Override
	public String getData() {
		return this.data;
	}

	@Override
	public void setData(String data) {
		this.data = data;
	}

	//父类的方法返回值是一个抽象对象，子类可以返回自己的对象。想想好像没毛病
	@Override
	public Node getNextNode() {
		return this.nextNode;
	}

	@Override
	public void setNextNode(AbstractNode nextNode) {
		if(nextNode!=null && !(nextNode instanceof Node)){
			throw new IllegalArgumentException("只允许传双链表的节点对象");
		}
		this.nextNode =  (Node)nextNode;
	}

	public Node getPreNode() {
		return preNode;
	}

	public void setPreNode(Node preNode) {
		this.preNode = preNode;
	}
	
	
	
	
}
