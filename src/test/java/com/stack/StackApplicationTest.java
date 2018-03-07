package com.stack;

import org.junit.Test;

public class StackApplicationTest {
	
	/**
	 * 测试十进制转八进制
	 */
	@Test
	public void testDecimalToOctal(){
		int num = 4576513;
		String desc = StackApplication.decimalToOctal(num);
		System.out.println("转换的结果是"+desc);
	}
	
	/**
	 * 测试符号是否匹配
	 */
	@Test 
	public void testSymbolMatch(){
		String symbols = "{{{}}}";
		boolean flag = StackApplication.symbolMatch(symbols);
		System.out.println(symbols+"符号集是匹配的吗？"+flag);
		
	}
}
