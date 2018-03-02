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
		Item preItem = null;
		Item postItem = item;
		while(true) {
			//如果传进来指数大于当前循环的数,表示到达临界值,可以退出循环,判断为空是万一判断完整个链表,还是找不到临界值,则直接退出循环
			if(postItem ==null || exp>postItem.exp ) {
				break;
			}
			preItem = postItem;
			postItem = postItem.nextItem;
		}
		//跳出循环只是当输入的指数大于后一项是才会跳出
		//但是关于输入的指数和前一项的指数,还有三种可能
		//1:前一项是空的,这种情况的话,说明输入的指数比第一项还要大,自然连前一项都没赋值就退出循环了
		//这个时候,新来的老大要替换掉旧的老大了
		if(preItem == null) {
			Item targerItem = new Item(exp, coef);
			targerItem.nextItem = item;
			return targerItem;
		}
		//2:是输入的指数小于前一项的指数
		if(exp<preItem.exp) {
			Item targerItem = new Item(exp, coef);
			preItem.nextItem=targerItem;
			targerItem.nextItem = postItem;
		//3 是输入的指数等于前一项的指数
		}else {
			preItem.coef = preItem.coef+coef;
		}
		//什么,你说,输入的指数大于前一项的指数,那前一项应该就是后一项了,不可能成为前一项了
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
