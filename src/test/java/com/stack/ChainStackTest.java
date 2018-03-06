package com.stack;

import org.junit.Test;

import com.stack.ChainStack;


import com.stack.vo.User;

/**
 * 演示链栈的测试代码
 * @author Administrator
 *
 */
public class ChainStackTest {
	/**
	 * 演示栈的初始化，添加，取出
	 */
	@Test
	public void stackTest(){
		//初始化栈，并指定了栈的大小
		ChainStack<User> stack = new ChainStack<>();
		//依次按0,1,2的顺序压栈
		for(int i=0;i<3;i++){
			User user = new User();
			user.setUsername("人员"+i);
			user.setPassword("passwd"+i);
			stack.push(user);
		}
		System.out.println("栈是否已经空了"+stack.isEmpty());
		System.out.println("看一下栈内元素总数"+stack.getSize());
		for(int i=0;i<3;i++){
			User user = stack.pop();
			System.out.println("栈内取的元素是"+user);
		}
		System.out.println("栈是否已经空了"+stack.isEmpty());
		System.out.println("看一下栈内元素总数"+stack.getSize());
	}
}
