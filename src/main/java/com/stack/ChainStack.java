package com.stack;

/**
 * 链式栈
 * 其实功能和顺序栈一模一样，但是物理结构使用链式结构存储。
 * 比较适用于栈内元素个数变化过大。
 * 一般不会出现上溢
 * @author cxh <br/>
 *
 */
public class ChainStack<T> {
	private Item<T> head;
	
	private int size = 0;
	
	
	/**
	 * 判断该栈是否是空栈
	 * @return
	 */
	public boolean isEmpty(){
		return head == null;
	}
	
	/**
	 * 压栈
	 * @param t 需要压栈的对象
	 */
	public void push(T t){
		Item<T> item = new Item<T>();
		item.setPayload(t);
		if(head == null){
			head = item;
		}else{
			item.setNext(head);
			head = item;
		}
		size++;
	}
	
	/**
	 * 抛出栈内元素
	 */
	@SuppressWarnings("unchecked")
	public T pop(){
		if(isEmpty()){
			throw new IllegalStateException("栈已经空，无法抛出元素");
		}
		T t = head.getPayload();
		Item<T> node = head.getNext();
		head = node;
		size --;
		return t;
	}
	/**
	 * 获取栈内元素总数
	 * @return
	 */
	public int getSize(){
		return this.size;
	}
	
}

