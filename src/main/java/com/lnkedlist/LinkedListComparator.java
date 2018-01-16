package com.lnkedlist;

import java.util.Comparator;

public class LinkedListComparator implements Comparator<AbstractNode> {

	@Override
	public int compare(AbstractNode o1, AbstractNode o2) {
		if(o1.getData()==null && o2.getData() == null){
			return 0;
		}
		if(o1.getData() == null){
			return 1;
		}
		if(o2.getData() == null ){
			return -1;
		}
		return o1.getData().compareTo(o2.getData());
	}


}
