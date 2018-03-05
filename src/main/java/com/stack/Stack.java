package com.stack;

import java.util.EmptyStackException;

/**
 * 一个栈对象
 * @author cxh
 *
 */
public class Stack<T> {
	
	private Object[] items;
	//top指针永远指向栈顶指针
	private int top;
	
	/**
	 * 创建一个栈对象,并初始化
	 * @param size 栈的容量
	 */
	public Stack(int size) {
		this.items = new Object[size];
		top = -1;
	}
	
	/**
	 * 判断栈是否已满
	 * @return
	 */
	private boolean isFull(){
		//如果指针指向数组容量的前一位的话,说明,栈已满
		//为什么是前一位呢?数组是从0角标开始的,容量为x的数组,最后一位的元素就是x-1
		return top==items.length-1;
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
	
	/**
	 * 取出栈顶元素
	 */
    @SuppressWarnings("unchecked")
	public T get() {
		if(isEmpty()) {
			throw new IllegalStateException("空栈取不出元素哦");
		}
		T t =  (T)items[top];
		removeElementAt(top);
		top--;
		return t;
	}
    
    /**
     * 压栈，将给定元素压到栈顶
     * @param item
     */
    public void set(T item) {
    	if(isFull()) {
    		throw new IllegalStateException("已经栈满,不允许再添加了哦");
    	}
    	//top指向栈顶元素，如果要继续压栈，则必须先让栈顶指针移动一位，然后再压栈
    	items[++top] = item;
    }
    
    /**
     * 返回栈内元素数量
     * @return
     */
    public int size(){
    	//top指针从0开始，故计算容量要加1
    	//因为容量是从1开始算的
    	return top+1;
    }
    /**
     * 根据角标移除数组中元素
     * @param index
     */
    private void removeElementAt(int index){
    	items[index] = null;
    }
    /**
     * 窥视栈顶元素，而不从栈内删除
     * @return
     */
    @SuppressWarnings("unchecked")
	public T peek(){
    	if(isEmpty()){
    		throw new EmptyStackException();
    	}
    	return (T)items[top];
    }
    
    /**
     * 搜索栈内元素是否有给定元素
     * 使用对象的equals进行判定
     * @param t
     * @return 元素的位置，从栈顶指针开始算起，如果找不到这个元素，返回-1
     */
    public int search(T t){
    	//判定为空是必须的，因为你不知道栈和参数，哪个会先为空
    	if(t==null){
    		for(int i=top;i >= 0;i--){
    			if(items[top] == null){
    				//之所以返回的值是栈内容量大小-i,之所以这么设计，因为元素的位置是从栈顶指针开始算起
    				return size()-i;
    			}
    		}
    	}else{
    		for(int i=top;i >= 0;i--){
    			if(t.equals(items[i])){
    				return size()-i;
    			}
    		}
    	}
		return -1;
    }
    
}
