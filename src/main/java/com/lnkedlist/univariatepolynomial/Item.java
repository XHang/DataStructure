package com.lnkedlist.univariatepolynomial;
/**
 * 一元多项式的子项
 * @author Mr-hang
 */
public class Item {
	
	/**
	 * 指数
	 */
	public Integer exp;
	
	/**
	 * 创建新项
	 * @param exp 指数
	 * @param coef 系数
	 */
	public Item(Integer exp, Integer coef) {
		super();
		this.exp = exp;
		this.coef = coef;
	}

	/**
	 * 系数
	 */
	public Integer coef;
	
	/**
	 * 下一项的引用
	 */
	public Item nextItem;
	
}
