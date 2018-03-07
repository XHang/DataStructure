package com.stack;

import javax.swing.text.AsyncBoxView.ChildState;

/**
 * 有关于栈的一些算法
 * @author Administrator
 *
 */
public class StackApplication {

	/**
	 * 十进制转八进制 <br/>
	 * 使用的是除数取余法 <br/>
	 * 具体做法就是十进制除以8，保存其商和余数。 <br/>
	 * 用商再去除8，保存商和余数 <br/>
	 * 重复以上操作，直至商为0，然后将余数倒序连起来。就是答案 <br/>
	 * 以上
	 * @param src
	 * @return
	 */
	public static String decimalToOctal(int src){
		ChainStack<Integer> stack = new ChainStack<>();
		while(true){
			if(src == 0){
				break;
			}
			System.out.println("未除的时候商 is"+src);
			int remainderNum = src%8;
			System.out.println("余数是"+remainderNum);
			stack.push(remainderNum);
			src = src/8;
			System.out.println("除的时候商 is"+src);
		}
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()){
			sb.append(stack.pop());
		}
		return sb.toString();
	}
	
	/**
	 * 输入一串符号，检查符号是否匹配
	 * @param src
	 * @return
	 * 第一种情况，个数完全匹配，没什么好说的
	 * 第二种情况，全部都只有右括号，die
	 * 第三种情况，左右括号个数不匹配。
	 * 左括号多于右括号，会导致循环完了之后，栈内还有元素
	 * 右括号多余左括号，会导致循环中，出现栈为空的情况
	 */
	public static boolean symbolMatch(String src){
		char[] charArray = src.toCharArray();
		ChainStack<Character> chainStack = new ChainStack<>();
		for(char c:charArray){
			if(c=='{'|| c=='('){
				chainStack.push(c);
			}else{
				//防止栈一个都没存进去就开始匹配了
				//这样会报空栈异常
				if(chainStack.isEmpty()) return false;
				char leftC = chainStack.pop();
				if(!isMatch(leftC,c)){
					return false;
				}
			}
		}
		if(!chainStack.isEmpty()){
			return false;
		}
		return true;
	}
	
	/**
	 * 判断左括号是否和右括号匹配
	 * @param c1 左括号
	 * @param c2 右括号
	 * @return
	 */
	private static boolean isMatch(char c1,char c2){
		if(c1 == '{'){
			return c2=='}';
		}
		if(c1 == '('){
			return c2 == ')';
		}
		return false;
	}
}
