package com.stack;

import java.util.Iterator;
import java.util.Stack;

import org.junit.Test;

import com.stack.vo.User;

/**
 * JDK栈对象测试
 * @author Administrator
 *
 */
public class JDKStackTest {
	
	@Test
	public void stackTest(){
		System.out.println("下面演示的是jdk内部实现的栈对象");
		Stack<User> stack = new Stack<>();
		//依次按0,1,2,3的顺序压栈
		for(int i=0;i<4;i++){
			User user = new User();
			user.setUsername("人员"+i);
			user.setPassword("passwd"+i);
			stack.push(user);
		}
		for(int i=0;i<4;i++){
			User user = stack.pop();
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
		Stack<User> stack = new Stack<>();
		//依次按0,1,2,3的顺序压栈
		for(int i=0;i<4;i++){
			User user = new User();
			user.setUsername("人员"+i);
			user.setPassword("passwd"+i);
			if(i==1){
				user1 = user;
			}
			stack.push(user);
		}
		//搜索的是第二次压栈的元素，总共压栈四次，从上面数起，应该是第三位
		System.out.println("search ing ....."+stack.search(user1));
	}
	
	@Test
	public void traverse(){
		Stack<User> stack = new Stack<>();
		//依次按0,1,2,3的顺序压栈
		for(int i=0;i<4;i++){
			User user = new User();
			user.setUsername("人员"+i);
			user.setPassword("passwd"+i);
			stack.push(user);
		}
		Iterator<User> iterator = stack.iterator();
		while(iterator.hasNext()){
			User user = iterator.next();
			System.out.println("遍历的用户名是"+user.getUsername());
			System.out.println("遍历的密码是"+user.getPassword());
		}
		System.out.println("查看遍历后是否会被清空"+stack.isEmpty());
	}

}
