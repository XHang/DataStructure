package com.lnkedlist.univariatepolynomial;

public class ItemUitl {
	
	/**
	 * 添加多项式的一项
	 * @param exp 指数
	 * @param coef 系数
	 * @param item 多项式的第一项
	 * @return 多项式的第一项
	 */
	public static Item  addItem(Integer exp,Integer coef,Item item){
		//如果第一项没有，则传进来的指数和系数作为多项式的第一项返回出去
		if(item == null){
			return new Item(exp, coef);
		}
		//循环为了获取多项式的最后一项
		Item temp = item;
		while(temp.nextItem!=null){
			temp = temp.nextItem;
		}
		//多项式的最后一项的下一项赋值
		temp.nextItem = new Item(exp, coef);
		return item;
	}
	/**
	 * 将一条链表附加在另一条链表的后面
	 * 将一个多项式加在另一个多项式的后面
	 * @param item 原一元多项式
	 * @param additionItem 需要附加的多项式
	 * @return
	 */
	public static Item addItem(Item item ,Item additionItem){
		if(item == null){
			return additionItem;
		}
		Item tailItem=item;
		while(tailItem.nextItem!=null){
			tailItem = tailItem.nextItem;
		}
		tailItem.nextItem = additionItem;
		return item;
	}
}
