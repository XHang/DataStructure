package com.lnkedlist.jdkImplement;

import java.util.Iterator;
import java.util.LinkedList;

import org.junit.Test;

import com.lnkedlist.POJO.Payload;

/**
 * JDK 关于链表的api实现
 * @author Administrator
 *
 */
public class JdkLinkedList {
	
	@Test
	public void createLinkedList(){
		LinkedList<Payload> linkedList = new LinkedList<Payload>();
		System.out.println("now create LinkedList");
		for(int i=0;i<30;i++){
			int random = (int)(Math.random()*100);
			Payload payload = new Payload();
			//生成随机汉字
			payload.setName(String.valueOf((char) (0x4e00 + (int) (Math.random() * (0x9fa5 - 0x4e00 + 1)))));
			payload.setNumber(random+"");
			linkedList.add(payload);
		}
		System.out.println("create LinkedList finish");
		System.out.println("ready println LinkedList");
		printlnLinkedList(linkedList);
	}
	
	/**
	 * 打印链表的每一项
	 * @param list
	 */
	public void printlnLinkedList(LinkedList<Payload> list){
		Iterator<Payload> iterator = list.iterator();
		//ps:别用for循环，然后get角标的方式来遍历链表
		//你要知道，链表不存在什么鬼角标，所谓角标，内部实现都得去一个个节点去找
		while(iterator.hasNext()){
			Payload payload = iterator.next();
			System.out.println(payload);
		}
	}
}
