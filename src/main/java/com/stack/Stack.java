package com.stack;

import java.nio.channels.IllegalChannelGroupException;

/**
 * 一个栈对象
 * @author cxh
 *
 */
public class Stack<T> {
	
	private Object[] item;
	private int top;
	
	/**
	 * 创建一个栈对象,并初始化
	 * @param size 栈的容量
	 */
	public Stack(int size) {
		this.item = new Object[size];
		top = -1;
	}
	
	/**
	 * 判断栈是否已满
	 * @return
	 */
	private boolean isFull(){
		//如果指针指向数组容量的前一位的话,说明,栈已满
		//为什么是前一位呢?数组是从0角标开始的,容量为x的数组,最后一位的元素就是x-1
		return top==item.length-1;
	}
	
	/**
	 * 判断是不是空栈
	 * @return
	 */
	private boolean isEmpty() {
		//top指针指向-1代表空栈,如果只有一个元素,则应该指向0.
		//这也是数组的角标
		return top==-1;
	}
	
	/*
	 * 取出栈顶元素
	 */
    @SuppressWarnings("unchecked")
	public T get() {
		if(isEmpty()) {
			throw new IllegalStateException("空栈取不出元素哦");
		}
		return (T)item[top];
	}
    
    public T set(T item) {
    	if(isFull()) {
    		throw new IllegalStateException("已经栈满,不允许再添加了哦");
    	}
    	item[]
    }
}
