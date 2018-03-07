package com.queue;

/**
 * 循环顺序队列
 *一般的顺序队列有假溢出的问题.为了解决这个问题.循环队列横空出世
 * @author cxh
 *
 */
public class CycleQueue<T> {
	
	//顺序队列,其实里面也是维护了一个数组来实现了
	private Object[] item;
	//定义一个队首指针.队首是删除元素的一端
	private int front ; 
	//定义一个队尾指针,队尾是添加元素的一段
	private int real;
	/**
	 * 初始化一个队列
	 * @param size
	 */
	public CycleQueue(int size) {
		this.item = new Object[size];
		front = 0;
		real = 0;
	}
	
	public boolean isEmpty() {
		return front == real;
	}
	
	public void add(T t) {
		if(isFull()) {
			throw new IllegalStateException("队列是满的,无法再添加元素");
		}
		item[real] = t;
		real = real+1;//%item.length
	}
	
	@SuppressWarnings("unchecked")
	public T get() {
		if(isEmpty()) {
			throw new IllegalStateException("队列已空,无法获取元素");
		}
		T t = (T) item[front];
		front = front+1;
		return t;
	}
	
	public boolean isFull() {
		return front == real+1;//%item.length
	}
	/**
	 * 清空队列
	 */
	public void clear() {
		for(int i = 0;i<item.length;i++) {
			item[i] = null;
		}
		this.front=0;
		this.real = 0;
	}

}
