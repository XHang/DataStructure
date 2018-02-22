package com.lnkedlist.application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.lnkedlist.univariatepolynomial.Item;
import com.lnkedlist.univariatepolynomial.ItemUitl;

/**
 * 链表应用，一元多项式的相加
 * @author Mr-hang
 *
 */
public class UnivariatePolynomialAddCalculate {
	
	public void addCalculate() throws  IOException{
		Item item1 = getItem();
		Item item2 = getItem();
		
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
				ItemUitl.addItem(exp, coef, mergeItem);
			}
		}
		//如果比较后，其中一个多项式中的项已经全部比较完，但是另一个多项式还有余项
		//就把余项附加到合并项里面
		if(item1 != null){
			ItemUitl.addItem(mergeItem, item1);
		}else if(item2 !=null){
			ItemUitl.addItem(mergeItem, item1);
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
				System.out.println("请输入第"+count+"项的指数");
				Integer exp = new Integer(reader.readLine());
				System.out.println("请输入第"+count+"项的系数");
				Integer coef = new Integer(reader.readLine());
				item = ItemUitl.addItem(exp, coef, item);
			} catch (NumberFormatException e) {
				System.err.println("请输入正确的的数字格式");
				continue;
			}
			System.out.println("已添加一项，键入回车继续添加，输入exit退出多项式的建立");
			if("exit".equals(reader.readLine())){
				break;
			}
		}
		return item;
	}
}
