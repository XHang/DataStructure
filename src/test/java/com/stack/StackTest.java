package com.stack;

import org.junit.Test;

import com.stack.vo.User;

/**
 * 栈测试
 * @author Administrator
 *
 */
public class StackTest {
	
	/**
	 * 演示栈的初始化，添加，取出
	 */
	@Test
	public void stackTest(){
		//初始化栈，并指定了栈的大小
		Stack<User> stack = new Stack<>(3);
		//依次按1,2,3的顺序压栈
		for(int i=0;i<3;i++){
			User user = new User();
			user.setUsername("人员"+i);
			user.setPassword("passwd"+i);
			stack.set(user);
		}
		for(int i=0;i<3;i++){
			User user = stack.get();
			System.out.println("栈内取的元素是"+user);
		}
		
	}

}
