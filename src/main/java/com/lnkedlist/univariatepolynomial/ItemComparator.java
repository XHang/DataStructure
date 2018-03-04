package com.lnkedlist.univariatepolynomial;

import java.util.Comparator;

/**
 * 多项式单项比较器
 * @author Administrator
 * 遵循以下规则
 * 指数大的，排前，其次系数大的，排前
 *
 */
public class ItemComparator  implements Comparator<Item>{

	/**
	 * 比较方法
	 * @param item1 单项1
	 * @param item2 单项2
	 * @return 如果单项1大于单项2，返回值大于0；等于，返回0；小于，返回值小于0
	 */
	@Override
	public int compare(Item item1, Item item2) {
		if(item1 == null || item2 == null){
			throw new IllegalArgumentException("参数必须不为空");
		}
		if(item1.exp>item2.exp){
			return 1;
		}else if((item1.exp<item2.exp)){
			return -1;
		}else{
		/*	if(item1.coef>item2.coef){
				return 1;
			}else if(item1.coef < item2.coef){
				return -1;
			}else{
				return 0;
			}*/
			//如果两个项的指数一样，表示是同类型
			return 0;
		}
	}

}
