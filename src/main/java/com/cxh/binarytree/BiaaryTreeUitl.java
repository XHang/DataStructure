package com.cxh.binarytree;

public class BiaaryTreeUitl {
	
	
	/**
	 * 求二叉树的深度<br/>
	 * 深度定义：根节点到最底下的子节点和中间隔多少个节点数
	 * @param tree
	 * @return
	 */
	public int getTreeDepth(BinaryTree tree){
		return getTreeDepth(tree.rootNode,1);
	}
	
	/**
	 * 当前节点的层数
	 * @param node
	 * @param level
	 * @return
	 * TODO 未完成
	 */
	private int getTreeDepth(Node node,int level){
		if(node == null){
			return level;
		}
		getTreeDepth(node.leftChildNode,level);
		level++;
		return getTreeDepth(node.leftChildNode,level);
		
	}

}
