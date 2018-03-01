package com.lnkedlist.POJO;

/**
 * 链表节点的有效载荷
 * @author 航
 *
 */
public class Payload {
	
	private String name;
	
	private String number;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Payload [name=" + name + ", number=" + number + "]";
	}
	
	
}
