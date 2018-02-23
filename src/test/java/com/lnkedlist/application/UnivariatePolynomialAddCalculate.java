package com.lnkedlist.application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;

import org.junit.Test;

import com.lnkedlist.univariatepolynomial.Item;
import com.lnkedlist.univariatepolynomial.ItemComparator;
import com.lnkedlist.univariatepolynomial.ItemUitl;

/**
 * 链表应用，一元多项式的相加
 * @author 航
 * 编写日期 ：2018/2/23
 *
 */
public class UnivariatePolynomialAddCalculate {
	
	
	/**
	 * 用户输入两个多项式，打印出来，并计算其相加后的结果
	 * 请用Junit运行
	 * @throws IOException
	 */
	@Test
	public void addCalculate() throws  IOException{
		System.out.println("请输入第一条多项式");
		Item item1 = getItem();
		printlnUnivariatePolynomial(item1);
		System.out.println("请输入第二条多项式");
		Item item2 = getItem();
		printlnUnivariatePolynomial(item2);
		System.out.println("计算多项式的和");
		Item merageItem = addCalculate(item1,item2);
		printlnUnivariatePolynomial(merageItem);
	}
	
	/**
	 * 计算两个多项式的和
	 * 要注意的是，两个多项式必须是降幂排序的!!!
	 * 规律在于，一旦比较的项指数过大，表示这个项在对面的多项式中，已经没有同类项了。
	 * 所以可以放心的合并到新的多项式中。
	 * 为什么说没有同类项呢？因为首先多项式是降幂排序的，其次移动的指针总是指数大的那一项。
	 * 这样做会趋向使两个比较的项指数相差不会太大。甚至可以相等，用来合并。
	 * 这种算法非常值得学习
	 * @param item1
	 * @param item2
	 * @return
	 */
	private Item addCalculate(Item item1,Item item2){
		//如果相加的两个多项式其中有一条是空的，直接返回另一条就是了
		if(item1 ==null){
			return item2;
		}
		if(item2 ==  null){
			return item1;
		}
		Item mergeItem = null;
		//只要比较后其中一个多项式没有需要再比较的项则退出循环
		while(item1 !=null && item2!=null){
			Integer exp= null;
			Integer coef = null ;
			//如果当前比较的项其指数相等，则将系数相加，指数不变
			if(item1.exp.compareTo(item2.exp) == 0){
				exp = item1.exp;
				coef = item1.coef+item2.coef;
				item1 = item1.nextItem;
				item2 = item2.nextItem;
			//如果当前比较的项，多项式1的指数大于多项式2的指数，则将多项式1的项添加到合并项中
			//并移动多项式1的指针到下一个
			}else if (item1.exp.compareTo(item2.exp)>0){
				exp = item1.exp;
				coef = item1.coef;
				item1 = item1.nextItem;
			}else{
				exp = item2.exp;
				coef = item2.coef;
				item2 = item2.nextItem;
			}
			//如果两个项相加后系数为0，消除，无需添加项
			if(coef !=0){
				mergeItem = ItemUitl.addItem(exp, coef, mergeItem);
			}
		}
		//如果比较后，其中一个多项式中的项已经全部比较完，但是另一个多项式还有余项
		//就把余项附加到合并项里面
		if(item1 != null){
			mergeItem = ItemUitl.addItem(mergeItem, item1);
		}else if(item2 !=null){
			mergeItem = ItemUitl.addItem(mergeItem, item2);
		}
		return mergeItem;
	}
	
	
	/**
	 * 根据用户的输入创建一个条一元多项式，用链表存储起来
	 * @return
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	private Item getItem() throws  IOException{
		int count=1;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, "utf-8"));
		Item item = null;
		while(true){
			try {
				System.out.println("请输入第"+count+"项的系数");
				Integer coef = new Integer(reader.readLine());
				System.out.println("请输入第"+count+"项的指数");
				Integer exp = new Integer(reader.readLine());
				item = ItemUitl.addItem(exp, coef, item);
			} catch (NumberFormatException e) {
				System.err.println("请输入正确的的数字格式");
				continue;
			}
			System.out.println("已添加一项，键入回车继续添加，输入exit退出多项式的建立");
			count++;
			if("exit".equals(reader.readLine())){
				break;
			}
		}
		return item;
	}
	
	/**
	 * 打印一条多项式
	 * @param item 多项式的第一项
	 * TODO 如果其中一项是负数的话
	 */
	private void printlnUnivariatePolynomial(Item item){
		Integer coef = null;
		Integer exp = null;
		while(item!=null){
			coef = item.coef;
			exp = item.exp;
			//打印系数(系数为1，无需打印系数)
			if(coef != 1){
				System.out.print(coef);
			}
			//如果指数为0，则无需打印未知数和指数
			if(exp != 0){
				//如果指数为1，无需打印指数，只需打印未知数即可
				if(exp == 1){
					System.out.print("x");
				}else{
					System.out.print("x^"+exp);
				}
			}
			//如果最后项是空的话，不需要打印加号了
			if(item.nextItem!=null){
				System.out.print("+");
			}
			item = item.nextItem;
		}
		//多项式打印完后换行
		System.out.println("");
	}

	/**
	 * 对一条多项式进行降幂排列
	 * @param item 多项式的第一项
	 * @return 降幂后多项式的第一项
	 * power by Google & Baidu
	 * 本次要求冒泡排序不能通过链表的长度进行循环
	 */
	private Item sort(Item item){
		//定义两个临时变量用于存储外部和内部循环的项
		Comparator<Item> comparator = new ItemComparator(); 
		Item outertemp = item;
		Item innertemp = item;
		//定义此变量用于存储内部循环遍历的前一项--用于交换
		Item innerPre = null;
		//每外部循环一次，outertemp就指向下一个项，如果为空，说明外部循环已经结束
		//这样就不用去计算链表的长度来控制外内循环
		while(outertemp !=null){
			while(innertemp.nextItem !=null){
				if(comparator.compare(innertemp, innertemp.nextItem)<0 ){
					swap(innertemp,innertemp.nextItem,innerPre);
				}else{
					innerPre = innertemp;
					innertemp = innertemp.nextItem;
				}
			}
			outertemp = outertemp.nextItem;
			//每次内部循环结束后，开启下一次循环都要置innerPre为null和innertemp为，以便从头开始排序
			innerPre = null;
			
				
		}
		return item;
	}
	/**
	 * 交换两个相邻项的位置
	 * @param innertemp 前项
	 * @param nextItem 后项
	 * @param innerPre 前前项 可能为空，如果为空，代表前项乃第一项
	 */
	private void swap(Item innertemp, Item nextItem, Item innerPre) {
		
	}
}
