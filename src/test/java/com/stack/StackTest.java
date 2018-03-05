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
		//依次按0,1,2的顺序压栈
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
	
	/**
	 * 搜索栈元素测试
	 */
	@Test
	public void searchTest(){
		//保存角标元素1的引用，以便在下面的搜索代码中用它来搜索
		User user1 = null;
		Stack<User> stack = new Stack<User>(20);
		//依次按0,1,2,3的顺序压栈
		for(int i=0;i<4;i++){
			User user = new User();
			user.setUsername("人员"+i);
			user.setPassword("passwd"+i);
			if(i==1){
				user1 = user;
			}
			stack.set(user);
		}
		//搜索的是第二次压栈的元素，总共压栈四次，从上面数起，应该是第三位
		System.out.println("search ing ....."+stack.search(user1));
	}
	
	/**
	 * 清空栈
	 */
	@Test
	public void testCleanStack() {
		Stack<User> stack = new Stack<User>(20);
		//依次按0,1,2,3的顺序压栈
		for(int i=0;i<4;i++){
			User user = new User();
			user.setUsername("人员"+i);
			user.setPassword("passwd"+i);
			stack.set(user);
		}
		stack.cleanStack();
		//空栈取不出元素咯,所以这个会报错
		stack.get();
	}

}
