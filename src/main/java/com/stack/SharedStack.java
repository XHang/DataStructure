package com.stack;


/**
 * 共享栈
 * 所谓共享栈,就是有两个栈,然后共享同一个存储空间(比如说本程序的数组)
 * 两个栈的栈顶指针一开始处在数组的两端,当有元素添加时,其中一个栈顶指针指针将向另一个栈顶指针移动.
 * 当两个栈顶指针相碰时,则表示栈满
 * 共享栈的好处在于使多个栈的存储空间互相补充,存储空间得到有效利用
 * @author cxh
 *
 */
public class SharedStack<T> {
	private Object[] items = null;
	
	/**
	 * topA指针为栈左端,
	 * topB指针为栈右端
	 */
	private int topA,topB;
	
	/**
	 * 初始化栈
	 * @param size
	 */
	public SharedStack(int size) {
		items = new Object[size];
		topA = -1;
		topB = size;
	}
	
	/**
	 * 取栈内元素,flag=1时取左栈元素,flag = 0 取右栈元素
	 * @param flag
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T get(int flag) {
		T temp;
		switch(flag) {
		case 1:if(isEmpty(1)) {
			throw new IllegalStateException("栈是空的");
		}
		temp = (T)items[topA];
		removeElementAt(topA, 1);
		topA --;
		break;
		case 2:if(isEmpty(2)) {
			throw new IllegalStateException("栈是空的");
		}
		temp = (T)items[topB];
		removeElementAt(topB, 2);
		topB ++;
		break;
		default:throw new IllegalArgumentException("请选择正确的参数");
		} 
		return temp;
	}
	public boolean isFull() {
		return ((topA+1) == topB); 
	}
	/**
	 * 判断共享栈其中一个是否是空栈
	 * @param flag flag=1是判断左栈是否为空  flag=2 判断右栈是否为空
	 * @return
	 */
	public boolean isEmpty(int flag) {
		switch(flag) {
		case 1:return topA == -1;
		case 2: return topB == items.length;
		default:throw new IllegalArgumentException("请选择正确的参数");
		}
	}
	
	private void removeElementAt(int index,int flag) {
		switch(flag) {
		case 1:items[topA] = null; break;
		case 2: items[topB] = null; break;
		default:throw new IllegalArgumentException("请选择正确的参数");
		}
	}
	/**
	 * 压栈
	 * @param t
	 * @param flag 为1压左边栈,为2压右边栈
	 */ 
	public void set(T t,int flag) {
		switch(flag) {
		case 1: 
			if(isFull()) {
				throw new IllegalStateException("栈已满,不可压栈");
			}
			items[++topA] = t;
			break;
		case 2: 
			if(isFull()) {
				throw new IllegalStateException("栈已满,不可压栈");
			}
		items[--topB] = t;
		break;
		default:throw new IllegalArgumentException("请选择正确的参数");
		}
	}
	
}
