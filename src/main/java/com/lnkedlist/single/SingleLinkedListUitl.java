package com.lnkedlist.single;

import org.junit.internal.Throwables;

import com.lnkedlist.common.LinkedListUitl;

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
			Node endNode = (Node) LinkedListUitl.traverseLinkedList(head,false);
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
    	//如果递归到最后一个元素5，返回,之所以还有判断为空,是为了访问传入的head本来就是空的
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
    
    /**
     * 为循环链表添加末尾节点
     * @param circleNode 头节点
     * @param targetNode 目标节点
     * @return 头节点
     *  实际环形链表也可以是双选链表，只要多设置一个引用就行，实际没有尝试的必要
     */
    public static Node addNodeforCircle(Node circleNode,Node targetNode){
    	Node firstNode = circleNode;
    	while(circleNode !=null && circleNode.getNextNode()!=null && circleNode.getNextNode()!=firstNode){
    		circleNode = circleNode.getNextNode();
    	}
    	if(firstNode == null){
    		return targetNode;
    	}
    	circleNode.setNextNode(targetNode);
    	targetNode.setNextNode(firstNode);
    	return firstNode;
    }
    
    /**
     * 判断链表是否属于环形链表
     * @param node 链表的其中一个节点
     * @return
     * 思路：定义两个指针，遍历整个链表，一个遍历得快，一个遍历得慢，如果该链表属于环形链表
     * 那终有一天，快指针会追上慢指针，并对她说，你知道吗？这个链表，是个环形链表。。（你够了）
     * 
     */
    public static  boolean isCircleLinkedList(Node node){
    	Node collisionNode = getCollisionNode(node);
    	if(collisionNode !=null){
    		return true;
    	}
    	return false;
    }
    
    /**
     * 获取环链表中相碰的节点
     * @param node
     * @return 如果链表没有环，返回null;
     */
    public static Node getCollisionNode(Node node){
    	Node fastNode = node;
    	Node slowNode = node;
    	while(fastNode!=null && fastNode.getNextNode()!=null){
    		System.out.println("快节点"+fastNode.getData());
    		System.out.println("慢节点"+slowNode.getData());
    		fastNode = fastNode.getNextNode().getNextNode();
    		slowNode = slowNode.getNextNode();
    		if(fastNode == slowNode){
    			return fastNode;
    		}
    	}
    	return null;
    }
    
    /**
     * 输入一个单向链表，判断该链表是否属于环形链表，如果属于，返回该环形链表的入口节点。
     * @param headNode
     * @return
     * 思路是这样的，跟上面的一样，先定义两个指针-慢指针和快指针，如果追赶的上，就是有环链表。
     * 然后快指针回到头节点，换成一个一个节点走，慢指针按照原来计划。
     * 再次相遇的那个节点就是入口节点
     * 关于这种算法需要数据基础，通过算式得出，然而现在还是不懂，先码程序再说
     */
    public static Node getIntoNodeIfCircleLinkedList(Node headNode){
    	Node fastNode = headNode;
    	Node slowNode = headNode;
    	boolean isCircleLinkedList = false;
    	while(fastNode!=null && fastNode.getNextNode()!=null){
    		System.out.println("快节点"+fastNode.getData());
    		System.out.println("慢节点"+slowNode.getData());
    		fastNode = fastNode.getNextNode().getNextNode();
    		slowNode = slowNode.getNextNode();
    		if(fastNode == slowNode){
    			isCircleLinkedList = true;
    			break;
    		}
    	}
    	if(isCircleLinkedList){
    		fastNode=headNode;
    		while(fastNode!=slowNode){
    			System.out.println("快节点"+fastNode.getData());
        		System.out.println("慢节点"+slowNode.getData());
    			fastNode = fastNode.getNextNode();
    			slowNode = slowNode.getNextNode();
    		}
    		return slowNode;
    	}
    	throw new RuntimeException("该链表没有环");
    }
    /**
     * 判断两个链表是否相交，交叉不符合情况，因为交叉的节点会有三个引用指针，此时就不是单链表
     * @param node1
     * @param node2
     * 第一种思路：就是遍历其中一个链表，拿每个遍历的节点去比较第二个链表的每一个节点，有则相交。浪费效率，不予考虑
     * 第二种将其中一个链表映射为哈希表，同样遍历链表2，看链表2的节点是否在哈希表里面，有则相交。浪费效率，不予考虑
     * 第三种将第二个链表接在第一个链表里面，然后遍历第一个链表，如果合并后的链表有环，则必然相交
     * 第四种要知道，两个链表相交后的节点都是一样的，也就是说，相交的两个链表最后的节点都是一样的。
     * 所以只要遍历取得两个链表的最后节点，判断是否相同，即可
     */
	public static boolean  isIntersect(Node node1,Node node2){
	   node1 = (Node) LinkedListUitl.traverseLinkedList(node1, false);
	   node2 = (Node) LinkedListUitl.traverseLinkedList(node2, false);
	   if(node1 == node2){
		   return true;
	   }
	   return false;
	}
	
	/**
	 * 如果提供的链表是有环链表，要求判断是否相交
	 * 思路：先找到其中一个链表的环中节点，用追赶式找出快慢指针相逢的节点。
	 * 然后用判断环中节点是否在另一个链表里面，如果是，则相交
	 * @param node1
	 * @param node2
	 * @return
	 * 错误的思路：同样是快慢指针，但是两指针在不同的链表里，同样追赶式，判断是否相交。
	 * 确实可以判断相交，但是万一不相交的话，其中一个环链表的指针就会进入死循环。无药可救
	 */
	public static boolean isIntersectIfCircle(Node node1,Node node2){
		Node collisionNode = getCollisionNode(node1);
		//如果两个链表至少有一个是非回环链表的话，肯定不相交
		if(collisionNode == null || !isCircleLinkedList(node2)){
			return false;
		}
		while(node2.getNextNode()!=null){
			if(collisionNode == node2){
				return true;
			}
			node2 = node2.getNextNode();
		}
		return false;
	}
	
	/**
	 * 获取两个链表相交的节点（无环链表）
	 * @param node1
	 * @param node2
	 * 思路：设长链表长度为L1，短链表长度为L2,则让指针现在长链表走(L1-L2)的长度，使之长和短链表在同一个起点上
	 * 然后依次遍历长短链表，当遍历的两个节点相同时，此节点就是交点
	 */
	public static Node getIntersectNode(Node node1,Node node2){
		int length1 = LinkedListUitl.getLinkedListLength(node1);
		int length2 = LinkedListUitl.getLinkedListLength(node2);
		int tempInt=0;
		Node temp = null;
		//假设node1的链表长于node2，如果不是，那就强迫是
		if(length1<length2){
			temp = node1;
			node1 = node2;
			node2 = temp;
			tempInt = length1;
			length1 = length2;
			length2 = tempInt;
			tempInt =0;
		}
		while(node1 != null){
			if(tempInt==length1-length2){
				break;
			}
			node1 = node1.getNextNode();
			tempInt++;
		}
		while(node1!=null || node2 !=null){
			if(node1 == node2){
				return node1;
			}
			node1 = node1.getNextNode();
			node2 = node2.getNextNode();
		}
		throw new RuntimeException("两个链表无交点");
	}
}
