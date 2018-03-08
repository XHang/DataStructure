package com.queue;

import org.junit.Test;

import com.queue.vo.User;

public class QueueTest {

	/**
	 * 测试假溢出
	 */
	@Test
	public void testFakeOverflow() {
		int size = 10;
		CycleQueue<User> queue = new CycleQueue<>(size);
		System.out.println("队列创建完成");
		for(int i=0;i<size;i++) {
			System.out.println("正在插入第"+i+"个元素");
			User  user  = new User();
			user.setUsername("用户"+i);
			user.setPassword("密码"+i);
			queue.add(user);
			System.out.println("插入完毕");
		}
		System.out.println("队列已塞满，查看当前队列是否已满"+queue.isFull());
		//先取几个队列元素出来玩玩
		System.out.println(queue.get());
		System.out.println(queue.get());
		System.out.println("队列已取出两个元素，查看当前队列是否已满"+queue.isFull());
		System.out.println("继续填充队列");
		queue.add(new User("张三丰","1085"));
		queue.add(new User("吕不韦","4531132"));
		System.out.println("塞了两个元素，查看队列是否已满》》》》"+queue.isFull());
	}
}
