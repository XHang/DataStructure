package com.cxh.linked;

import java.util.*;

/**
 * 跳表的实现
 */
public class SkipLinked<T extends Comparable> {
    /**
     * 该链表的头元素
     */
    private Node<T> head;
    /**
     * 链表的大小，用于决定该链表应该有多大
     */
    private int size;

    /**
     * 存每一层的链表的头一个元素
     * 使用迭代器，迭代的第一个对象就是顶层首元素
     */
    private LinkedList<Node> levelHeadNode = new LinkedList<>();

    //抛硬币，true或者false两种可能性，各占1/2
    private boolean flipCoin() {
        Random random = new Random();
        int r = random.nextInt(2);
        return r == 1;
    }

    /**
     * 添加节点
     *
     * @param nearNode  临近的节点
     * @param t         要添加的节点值
     * @param direction 方向，相对于临近的节点而言，新添加的节点在临近的节点的哪个方向
     * @return
     */
    private Node add(Node nearNode, T t, direction direction) {
        Node newNode = new Node();
        newNode.setValue(t);
        switch (direction) {
            case RIGHT:
                newNode.setRightNode(nearNode.getRightNode());
                nearNode.setRightNode(newNode);
                break;
            case LEFT:
                newNode.setRightNode(nearNode);
                break;
            case UP:
                newNode.setNextNode(nearNode);
                break;
            default:
                throw new IllegalArgumentException("direction 方向错误：" + direction);
        }
        return newNode;
    }

    //添加节点
    public void add(T t) {
        Node<T> near = findRecent(t);
        Node<T> newNode = new Node<>();
        if (near == null) {
            //添加到底层链表的头结点了
            newNode = add(head, t, direction.LEFT);
            head = newNode;
        } else if (equals(near, t)) {
            return;
        } else {
            newNode = add(near, t, direction.RIGHT);
        }
        size++;
        adjustLevel(newNode);
    }

    private void adjustLevel(Node<T> newNode) {
        //该链表允许的最长层数
        int maxLevel = getLevel();
        //链表如此之短乃至不用分层，则中止函数执行
        if (maxLevel == 0) {
            return;
        }
        int level = 1;
        ListIterator<Node> iterator = levelHeadNode.listIterator();
        while (flipCoin() && level <= maxLevel) {
            level++;
            //如果分层容器还未存任何东西,或者向上提升是新的一层
            if (!iterator.hasNext()) {
                Node firstNode = add(newNode, newNode.getValue(), direction.UP);
                iterator.add(firstNode);
                newNode = firstNode;
            } else {
                Node<T> firstNode = iterator.next();
                Node nearNode = findRecent(firstNode, newNode.getValue());
                //该层的头元素要易主了
                if (nearNode == null) {
                    newNode = add(firstNode, newNode.getValue(), direction.LEFT).setNextNode(newNode);
                    iterator.set(newNode);
                } else if (equals(nearNode, newNode.getValue())) {
                    throw new IllegalStateException("此处不应该出现新添加的节点和分层的某节点一致，因为这种情况早就应该在前面的过滤掉了");
                }else{
                    newNode = add(nearNode,newNode.getValue(),direction.RIGHT).setNextNode(newNode);
                }
            }
        }
    }

    //链表的层数根据链表长度而定
    private int getLevel() {
        return size / 10;
    }

    /**
     * 根据目标值查找左边最近的底层链表节点
     * 如果底层链表有目标值匹配的话，返回它
     * 如果目标节点比底层链表的头个元素还要小，返回空
     */
    private Node findRecent(T t) {
        Node<T> target = layeringFind(t);
        if (target == null) {
            return findRecent(head, t);
        }
        return target;
    }

    private boolean equals(Node<T> target, T t) {
        if (target == null){
            return false;
        }
        return target.getValue().compareTo(t) == 0;
    }

    /**
     * 分层查找
     * 如果通过分层能查找到目标值，返回该目标值
     * 否则返回左边最近的底层链表节点
     * 如果无法通过分层限定范围，返回空
     *
     * @param t
     * @return
     */
    private Node layeringFind(T t) {
        if (levelHeadNode == null || levelHeadNode.isEmpty()) {
            return null;
        }
        ListIterator<Node> iterable = levelHeadNode.listIterator(levelHeadNode.size());
        Node thisNode = iterable.previous();
        while (true) {
            Node<T> target = findRecent(thisNode, t);
            //说明在该层链表找不到最近的元素，目标元素比该层链表的头节点还要小
            if (target == null) {
                //分层已经抵达最底层的链表了
                if (!iterable.hasPrevious()) {
                    return null;
                }
                //从下一层的头一个节点继续查找
                thisNode = iterable.previous();
                //如果在分层节点找到目标节点了，就取实际链表的节点返回
            } else if (equals(target, t)) {
                return target;
            } else {
                //target 已经是实际链表的节点了
                if (target.getNextNode() == null) {
                    return target;
                }
                thisNode = target.getNextNode();
            }
        }
    }

    //遍历参数节点最后的一个next节点
    @Deprecated
    private Node getLastNextNode(Node node) {
        while (node.getNextNode() == null) {
            node = node.getNextNode();
        }
        return node;
    }

    /**
     * 从链表头节点开始查找左边离目标节点最近的节点，
     *
     * @param node
     * @param t
     * @return 1. 左边离目标节点最近的节点<br/>
     * 2. 可能就是目标节点，如果有的话<br/>
     * 3. 可能返回空，如果目标节点比头结点还要小的话<br/>
     */
    private Node<T> findRecent(Node<T> node, T t) {
        Node preNode = null;
        while (node!=null) {
            T value = node.getValue();
            int result = value.compareTo(t);
            //说明当前节点的值比目标值要大
            if (result == 1) {
                return preNode;
            }
            else if (result == 0) {
                return node;
            }
            //说明当前节点的值比目标值要小
            preNode = node;
            node = node.getRightNode();
        }
        return preNode;
    }

    public String ToString() {
        //边界条件：如果底层链表是空的,返回空串
        if (head == null || head.getValue() == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int level = 0;
        ListIterator<Node> iterator = levelHeadNode.listIterator(levelHeadNode.size());
        while (iterator.hasPrevious()) {
            sb.append(String.format("第%d层", level++));
            sb.append(System.lineSeparator());
            sb.append(getSingleLinkedStr(iterator.previous()));
            sb.append(System.lineSeparator());
        }
        sb.append(String.format("第%d层",levelHeadNode.size() ) );
        sb.append(System.lineSeparator());
        sb.append(getSingleLinkedStr(head));
        sb.append(System.lineSeparator());
        return sb.toString();
    }

    private String getSingleLinkedStr(Node<T> node) {
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(node.getValue() + "->");
            node = node.getRightNode();
        }
        return sb.toString();
    }


    public Node serach(T t){
        Node nearNode = findRecent(t);
        return equals(nearNode,t)?nearNode:null;
    }

}


enum direction {
    LEFT, RIGHT, UP,
}

class Node<T> {
    private T value;
    private Node<T> nextNode;
    private Node<T> rightNode;


    public Node() {

    }

    public Node(T t) {
        this.value = t;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getNextNode() {
        return nextNode;
    }

    public Node<T> setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
        return this;
    }

    public Node<T> getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node<T> rightNode) {
        this.rightNode = rightNode;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
