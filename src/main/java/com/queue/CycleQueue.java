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
		//为什么要加1，因为循环队列要解决假移除问题，就要空留一个存储位置。
		//如果存储空间是0~9
		//最多只能用0~8元素，第九号元素用不了
		this.item = new Object[size+1];
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
		//加1能理解吧，队列添加元素队尾指针当然要加1
		//但是取余怎么理解呢？事实上,队尾指针0~9的时候，取余还是原来的那个值，取余毫无影响
		//但是当队尾指针到9，下面这条语句就可以给real赋0值，也就是所谓的循环了。
		real = (real+1)%item.length;
	}
	
	@SuppressWarnings("unchecked")
	public T get() {
		if(isEmpty()) {
			throw new IllegalStateException("队列已空,无法获取元素");
		}
		T t = (T) item[front];
		front = (front+1)%item.length;
		return t;
	}
	public boolean isFull() {
		//那么判断队列是否已满为什么也要+1然后取余呢？
		//如果不加1的话，队列初始化时。队首指针指向队尾指针。
		//就会被判断为队列已满，这不科学，所以要加1
		//并且为了判断是否已满的指针也能循环队列，故还需要取余
		return front == (real+1)%item.length;
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
