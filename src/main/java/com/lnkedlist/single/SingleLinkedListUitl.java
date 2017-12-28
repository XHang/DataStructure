package com.lnkedlist.single;

/**
 * 单链表工具类
 * @author Mr-hang
 *
 */
public class SingleLinkedListUitl {
	
	/**
	 * 添加新的节点到链表中
	 * @param head 链表的头节点
	 * @param value 新节点的数据
	 * @return
	 * PS: 返回末尾节点的话，可能会丢失头节点，导致链表丢失
	 */
	public static Node addNode(Node head,String value){
		//先创建一个只带值的新节点
		Node newNode = new Node(value);
		return addNode(head,newNode);
	}
	/**
	 * 添加新的节点到链表中
	 * @param head 链表的头节点
	 * @param targeNode 新节点
	 * @return
	 * PS: 返回末尾节点的话，可能会丢失头节点，导致链表丢失
	 */
	public static Node addNode(Node head,Node targeNode){
		//如果头节点没有，意味着链表是空的，这时候就创建一个只有头节点的链表返回
		if(head == null){
			head = targeNode;
		}else{
			//如果有头节点，先遍历到最后一个节点，再把终节点的下一个节点的引用指向新创建的节点
			Node endNode = traverseLinkedList(head,false);
			endNode.setNextNode(targeNode);
		}
		return head;
	}
	
	/**
	 * 单链表添加节点，头插法，额，其实就是把新来的节点当做头节点
	 * @param headNode 头节点
	 * @param target 目标节点
	 * @return 头节点
	 */
	public static Node addNodeFromHead(Node headNode,Node target){
		if(headNode == null){
			return target;
		}else{
			target.setNextNode(headNode);
			return target;
		}
	}
	
	
	
	
	
	
	/**
	 * 遍历整个链表，返回最后的节点
	 * @param preNode 头节点
	 * @param isprintln 是否需要在遍历过程中打印节点的值
	 * @return
	 */
	public  static Node traverseLinkedList(Node preNode,boolean isprintln){
		if(preNode == null){
			throw new RuntimeException("链表为空");
		}
		Node nextNode = preNode;
		//循环取preNode的下一个节点，直至为null，返回preNode
		while(nextNode!=null){
			preNode = nextNode;
			if(isprintln){
				System.out.println("当前节点的值为"+preNode.getData());
			}
			nextNode=preNode.getNextNode();
		}
		return  preNode;
	}
	
	/**
	 *从链表中删除指定节点
	 * @param headNode 头节点
	 * @param targetNode 目标节点
	 * @return 头节点
	 */
	public static Node removeNode(Node headNode,Node targetNode){
		//如果头节点是空，返回空，如果目标节点是空，返回头节点
		if(headNode == null ){
			return null;
		}
		if(targetNode == null){
			return headNode;
		}
		//如果头节点就是目标节点，则判断头节点是否还有剩余节点
			//若无，返回空
			//若有，将把头节点的下一个指针置空，然后把下一个节点当作头节点返回
		Node preNode =headNode ;
		Node postNode = headNode.getNextNode();
		if(preNode.equals(targetNode)){
			if(postNode==null){
				return null;
			}else{
				headNode.setNextNode(null);
				return postNode;
			}
		}
		//剩下的情况就是遍历，查看链表的哪一个节点是目标节点
		while(postNode!=null){
			//如果后一个节点就是需要删除的节点，就把前一个节点的下一个指针指向删除节点的下一个指针
			if(postNode.equals(targetNode)){
				preNode.setNextNode(postNode.getNextNode());
				return headNode;
			}
			preNode = postNode;
			postNode = preNode.getNextNode();
		}
		return headNode;
	}

    /**
     * 反转链表
     * @param headNode 目标链表的头节点
     * @return 反转链表后的头节点
     * 假设需要翻转的链表是1,2,3,4,5
     *其实关键在于你要在递归过程中保存每一个链表的元素，这才可能反转链表
     */
    public static Node reverseLinkedLink(Node head) {  
    	//如果递归到最后一个元素5，返回
        if(head == null || head.getNextNode()==null){
        	return head;
        }
        //获取递归回浮的元素，预计会是5,5,5,5,5  笑~
        Node reNode = reverseLinkedLink(head.getNextNode());
        head.getNextNode().setNextNode(head);
        head.setNextNode(null);
        //确保在每一次递归回浮中，都保存头节点的引用
        return reNode;
    }  
    
    /**
     * 反转链表,用循环实现
     * @param currentNode
     * @return
     * 重点是在一次循环你要有两个节点，一个节点是当前循环的节点，另一个是当前循环节点的前一个节点
     */
    public static Node reverseLinkedLinkByLoop(Node currentNode){
    	Node preNode = null;
    	Node postNode = null;
    	while(currentNode!=null){
    		//preNode等于空的情况只能是第一次循环，一次循环后，preNode永远指向当前循环节点的前一个节点
    		if(preNode == null){
    			preNode = currentNode;
    			currentNode = preNode.getNextNode();
    			preNode.setNextNode(null);
    		}else{
    			postNode = currentNode.getNextNode();	//记录当前节点的后一个节点
    			currentNode.setNextNode(preNode);  			//把当前循环节点的下一个节点指向preNode，也就是前一个节点
    			preNode = currentNode;								//把当前循环的节点设为preNode，以便在下一轮循环记录前一个节点
    			currentNode = postNode;
    		}
    	}
		return preNode;
    	
    }
    
    
}
