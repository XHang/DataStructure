package com.stack;

import org.junit.Test;

import com.stack.vo.User;

/**
 * 共享栈的测试程序
 * @author cxh
 *
 */
public class SharedStackTest {

	@Test
	public void createSharedStack() {
		SharedStack<User> stack = new SharedStack<>(5);
		for(int i=0;i<3;i++) {
			User user  = new User();
			user.setUsername("admin"+i);
			user.setPassword("password"+i);
			stack.set(user, 1);
		}
		for(int i=0;i<2;i++) {
			User user  = new User();
			user.setUsername("admin"+i+3);
			user.setPassword("password"+i+3);
			stack.set(user, 2);
		}
		System.out.println("栈是否已经满了"+stack.isFull());
		for(int i=0;i<3;i++) {
			User user = stack.get(1);
			System.out.println("取出左栈元素"+user);
		}
		for(int i=0;i<2;i++) {
			User user = stack.get(2);
			System.out.println("取出右栈元素"+user);
		}
		System.out.println("栈是否已经满了"+stack.isFull());
		System.out.println("左栈是否是空栈?"+stack.isEmpty(1));
		System.out.println("右栈是否是空栈?"+stack.isEmpty(2));
	}
}
