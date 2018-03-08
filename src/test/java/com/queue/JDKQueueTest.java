package com.queue;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

import org.junit.Test;

import com.queue.vo.User;

/**
 * JDK实现的队列测试
 * @author Administrator
 *
 */
public class JDKQueueTest {
	
	/**
	 * 简单的，创建一个序列，并插入一些数据 jdk版本
	 */
	@Test
	public void createQueue(){
		ArrayDeque<User> queue = new ArrayDeque<User> ();
		for(int i=0;i<10;i++){
			User user = new User();
			user.setUsername("用户名"+i);
			user.setPassword("密码"+i);
			//ps 如果使用了offer方法，在满队列继续插入数据的话，会返回false代表插入数据失败，add方法可是会抛异常的
			queue.add(user);
		}
		//打印队列的每一个值
		//序列是一个先进先出的数据结构，所以预想中的打印序列应该是1,2,3,4.。。。
		printlnQueue(queue);
	}
	
	/**
	 * 取出并打印序列的每一个值
	 * @param queue
	 */
	private void printlnQueue(Queue<User> queue){
		Iterator<User> iterator = queue.iterator();
		while(iterator.hasNext()){
			User user = iterator.next();
			System.out.println(user);
		}
	}
	/**
	 * 正常来说，队列插入的数据是插入到队尾的
	 * 但是jdk居然还提供了一个addFirst。
	 * 这个难道是说插入新数据到队首？
	 * 演示一下
	 * 演示完毕，确实如此。。jdk你太6了
	 * 不过人家的名字本来就叫做双端对列
	 */
	@Test
	public void testAddFirst(){
		ArrayDeque<User> queue = new ArrayDeque<User> ();
		for(int i=0;i<10;i++){
			User user = new User();
			user.setUsername("用户名"+i);
			user.setPassword("密码"+i);
			queue.add(user);
		}
		User user = new User();
		user.setUsername("插队人-插到队首");
		user.setPassword("匿名，没有密码");
		queue.addFirst(user);
		printlnQueue(queue);
	}
	
	/**
	 * 演示从队列删除元素
	 */
	@Test
	public void removeElements(){
		ArrayDeque<User> queue = new ArrayDeque<User> ();
		for(int i=0;i<10;i++){
			User user = new User();
			user.setUsername("用户名"+i);
			user.setPassword("密码"+i);
			queue.add(user);
		}
		for(int i=0;i<3;i++){
			//ps 如果出队列调用的是remove的话，万一遇到空队列，这货会抛异常
			User user = queue.poll();
			System.out.println("从队列中取出的元素是"+user);
		}
		printlnQueue(queue);
	}
	
	/**
	 * 查看队首的元素，也就是一开始添加的元素
	 * 注：不会删除元素，仅仅只是查看
	 */
	@Test
	public void lookFirst(){
		ArrayDeque<User> queue = new ArrayDeque<User> ();
		for(int i=0;i<10;i++){
			User user = new User();
			user.setUsername("用户名"+i);
			user.setPassword("密码"+i);
			queue.add(user);
		}
		//相似的的方法还有element方法，但是这货在空队列的时候可是会抛一个异常的，peek只返回空
		User user = queue.peek();
		System.out.println("队首的元素是"+user);
	}
	
	

}
