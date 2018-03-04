package com.lnkedlist.application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
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
public class UnivariatePolynomialCalculate {
	
	
	/**
	 * 用户输入两个多项式，打印出来，并计算其相加后的结果
	 * 请用Junit运行
	 * 其实有BUG的说，如果输入的多项式包含同类项的话，实际运行后会合并不了
	 * @throws IOException
	 */
	@Test
	public void addCalculate() throws  IOException{
		System.out.println("请输入第一条多项式");
		Item item1 = getItem();
		item1 = bubbleSort(item1,new ItemComparator());
		printlnUnivariatePolynomial(item1);
		System.out.println("请输入第二条多项式");
		Item item2 = getItem();
		item2 = bubbleSort(item2,new ItemComparator());
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
	 * 冒泡排序
	 * 对一元多项式进行降幂的冒泡排序
	 * @param head 多项式的第一项
	 * @param comparator 比较器
	 * @return  排完序后多项式的第一项
	 */
	public Item bubbleSort(Item head,Comparator<Item> comparator){
		Item outer = null;
		Item inner = null;
		//总比较次数为链表的长度减1
		for(outer =head;outer.nextItem !=null;outer = outer.nextItem ){
			for(inner = head;inner.nextItem !=null;inner = inner.nextItem){
				//如果前一项比后一项大的话，交换其负载(不交换位置，这个是黑科技)
				//不过这种黑科技不适合链表节点包含太多负债的情况
				if(comparator.compare(inner, inner.nextItem)<0){
					swap(inner,inner.nextItem);
				}
			}
		}
		return head;
	}
	
	/**
	 * 交换两个节点的负载
	 * @param innertemp 前项
	 * @param nextItem 后项
	 */
	private void swap(Item innertemp, Item nextItem) {
		Integer exp= innertemp.exp;
		Integer coef = innertemp.coef;
		innertemp.exp = nextItem.exp;
		innertemp.coef = nextItem.coef;
		nextItem.exp = exp;
		nextItem.coef = coef;
	}
	
	/**
	 * 一元多项式的相乘
	 * @throws Exception 
	 * 
	 */
	@Test
	public void multitly() throws Exception {
		System.out.println("多项式相乘开始");
		System.out.println("开始输入第一个多项式");
		//Item item1 = inputItem();
		Item item1 = createItem1();
		System.out.println("输入完毕,开始打印多项式");
		printlnUnivariatePolynomial(item1);
		System.out.println("开始输入第二个多项式");
		//Item item2 = inputItem();
		Item item2 = createItem2();
		System.out.println("输入完毕,开始打印多项式");
		printlnUnivariatePolynomial(item2);
		System.out.println("开始相乘");
		Item product = multitly(item1,item2);
		printlnUnivariatePolynomial(product);
		System.out.println("以上");
		return ;
		
	}
	/**
	 * 一元多项式的相乘
	 * @param item1 
	 * @param item2
	 * @return
	 * 其算法是:先算出两个链表最大的指数和.K
	 * 然后以这个最大的指数和为范围,进行递减循环
	 * 每一次递减循环,都去找出多项式的指数和为K的两个子项.
	 * 6后进行乘
	 */
	public Item multitly(Item item1,Item item2) {
		int maxExp ;
		Item point1 = null;
		
		Item product = null;
		maxExp = item1.exp+item2.exp;
		item2 = reverse(item2);
		Item point2 = null;
		int exp;
		for(exp=maxExp;exp>=0;exp--) {
			point1 = item1;
			point2 = item2;
			Integer coef = 0;
			while(point1!=null && point1.exp>exp) {
				point1 = point1.nextItem;
			}
			while(point1!=null && point2!=null &&  point1.exp+point2.exp<exp) {
				point2 = point2.nextItem;
			}
			//我猜之所以要循环指针是为了找出乘积后同类项,并事先合并之
			while(point1 !=null && point2 !=null) {
				Integer sumExp = point1.exp+point2.exp;
				if(sumExp == exp) {
					coef+=point1.coef*point2.coef;
					point1 = point1.nextItem;
					point2 = point2.nextItem;
				}
				//如果当前两个项指数和大于exp,则要移动多项式1,驱使两个项之和接近与exp
				else if(sumExp > exp){
					point1 = point1.nextItem;
				}else {
					point2 = point2.nextItem;
				}
			}
			//如果循环之后,连一次指数之和都没有等于exp,则exp是有可能为0的,所以要判断下
			if(coef !=0.0) {
				product = ItemUitl.addItem(exp, coef, product);
			}
		}
		return product;
	}
	/**
	 * 单项之间乘
	 * @param item1 
	 * @param itme2
	 * @return 计算后的新项
	 * 计算规则
	 * 指数相加,系数相乘
	 * 
	 */
	private Item itemMultitly(Item item1,Item itme2) {                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  
		Integer coef = item1.coef*itme2.coef;
		Integer exp = item1.exp+itme2.exp;
		return new Item(exp, coef);
	}
	
	/**
	 * 输入一个多项式
	 * 要求在输入多项式后就已经将这个多项式做降幂排列了
	 * 并且合并输入过程中的同类项
	 * 其实算法很简单,就是把输入指数和已经输入多项式的每一项进行比较
	 * 找到和输入指数临界的两个元素,前一个元素的指数比输入指数小,后一个比输入指数大.
	 * 就把输入的那个项插入到两个元素中间,即可
	 * 万一要是前一个元素的指数和输入指数相等,简单,合并同类项
	 * @return
	 * @throws Exception 
	 */
	private Item inputItem() throws Exception {
		int count=1;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, "utf-8"));
		Item head = null;
		while(true){
			try {
				System.out.println("请输入第"+count+"项的系数");
				Integer coef = new Integer(reader.readLine());
				System.out.println("请输入第"+count+"项的指数");
				Integer exp = new Integer(reader.readLine());
				if(coef.intValue() == 0 &&  exp.intValue() == 0) {
					break;
				}
				head = ItemUitl.addItemByDescending(exp, coef, head);
			} catch (NumberFormatException e) {
				System.err.println("请输入正确的的数字格式");
				continue;
			}
			System.out.println("已添加一项,下面继续输入,如果系数和指数都是0则退出");
			count++;
		}
		return head;
	}
	/**
	 * 将链表反置
	 * @param item
	 * @return
	 */
	private Item reverse(Item item) {
		//遍历到最后一个元素,从递归的最深处返回
		if(item == null || item.nextItem ==null) {
			return item;
		}
		Item postItem = reverse(item.nextItem);
		//假设item指向4,下一项就是5,然后5的下一项指向4
		item.nextItem.nextItem = item;
		//4的下一项就指向null;
		item.nextItem = null;
		return postItem;
	}
	
	private  Item createItem1() {
		Item head = ItemUitl.addItem(4, 5, null);
		 head = ItemUitl.addItem(2, 3, head);
		 head = ItemUitl.addItem(1, 3, head);
		 return head;
	}
	private  Item createItem2() {
		 Item head = ItemUitl.addItem(3, 7, null);
		 head = ItemUitl.addItem(2, 5, head);
		 head = ItemUitl.addItem(1, 6, head);
		 return head;
	}
}
                                                                                                                                                                                                                                                                                                                                        