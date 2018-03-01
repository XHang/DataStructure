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
	 * 降幂添加多项式的项
	 * @param exp
	 * @param coef
	 * @param item
	 * @return
	 */
	public static Item  addItemByDescending(Integer exp,Integer coef,Item item){
		//如果第一项没有，则传进来的指数和系数作为多项式的第一项返回出去
		if(item == null){
			return new Item(exp, coef);
		}
		Item preItem = item;
		Item postItem = item;
		while(true) {
			//如果传进来指数大于当前循环的数,表示到达临界值,可以退出循环,判断为空是判断完整个链表,还是找不到临界值,则直接退出循环,反正
			if(postItem ==null || exp>postItem.exp ) {
				break;
			}
			preItem = postItem;
			postItem = postItem.nextItem;
		}
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
