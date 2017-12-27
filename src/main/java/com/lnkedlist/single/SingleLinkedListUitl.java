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
    public static void deleteNode(Node wu)  
    {  
        if(wu==null||wu.getNextNode()==null) return;//如果p为空或为单链表中最后一个结点不符合题意，直接返回  
        Node liu=wu.getNextNode();//q为p的后继结点  
        wu.setData(liu.getData());
        wu.setNextNode(liu.getNextNode());//从单链表中删除结点q  
    }  

    /**
     * 反转链表
     * @param headNode 目标链表的头节点
     * @return 反转链表后的头节点
     */
    public Node reverseLinkedList(Node node){
    	if(node.getNextNode() == null){
    		node.setNextNode(reverseLinkedList(node));
    	}
    }
}
