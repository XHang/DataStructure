# 数据结构
## 多叉树
### 名词解释
1. 根：多叉树的根节点
2. 父节点：略
3. 叶子结点：没有子节点的节点
4. 结点：指多叉树中一个个的点    
5. 度：指父结点下面有几个孩子结点  

      tree
      ----
       j    <-- root
     /   \
    f      k  
	/   \      \
	a     h      z    <-- leaves 


### 什么是树
1. 比如说计算机的文件系统
2.提供适度的访问/搜索（比链接列表更快并且比数组慢）。
3. 树提供适度的插入/删除（比数组更快，比无序链表慢）。
1. 没有节点数的限制

### 树的应用

2. 需要操作多层次的数据
3. 便于搜索（见树的遍历）
4. 需要排序数据列表
5. 路由算法

### 什么是二叉树
对于一个数，如果它的所有节点最多只有两个直接子节点。那么这个树就是二叉树


### 二叉树的遍历：  
前序：根结点第一个访问，然后访问左、右孩子；  
后序：根结点最后访问，开始先访问左、右孩子；  
中序：父结点第二个访问，最先访问左孩子，最后访问右孩子 

注：如果树是空的，那么根值就是null
### 树节点包含什么？
1. 数据
2. 指向左边的子节点
3. 指向右边的子节点

### 程序文档
1. Binary类描述了这么一个结构的二叉树

      tree
      ----
        1    <-- root
       /  \
      2    3  
     /   
    4
   
 2. BinaryTreeTraversalTest类的binaryTreeTraversalTest方法创建了形状如下所示的树

      tree
      ----
        1    <-- root
       /  \
      2    3  
     / \  
    4   5


### 二叉树的特点
1. 对于level（标记为L）确定的二叉树，它的最大节点数就是 `2^L -1`  
什么是level，就是深度，根节点到最底下的子节点和中间隔多少个节点数

2. 对于节点数为N的二叉树，其最小的高度为`[ Log_2(N+1)]-1`  

### 二叉树-满二叉树
定义：如果每个节点都有0或2个子节点，则该树为满二叉树

### 完整二叉树
所有层次的节点数都达到最大值，除了最后一层，最后一层的节点都靠左对齐


### 完美二叉树
所有节点都有两个子节点，所有叶子节点都在同一层次上

### 平衡二叉树
左右子数的的高度维持在1以内

### 遍历二叉树
附带的binaryTreeTraversal类的二叉树遍历采用了递归遍历方式。

以上。



# 哈希表

这是一种高级的数据结构，通过映射手段，把查询的时间复杂度降低到了`O(1)~O(n)`起。

试想一下，如果是链表或者数组，要查询某元素的话，得重复查找容器的每一个元素，所以这种数据结构的时间复杂度就是O(n)。

> 记容器的元素数量为n

使用哈希表可以直接定位到目标元素，不过可能因为哈希冲突，你可能还需要继续向下遍历链表。

所以，哈希表的时间复杂度最好的就是O(1)，最差的就是O(n)了



哈希表的底层数据结构

以java为例，java的HashMap的底层数据结构是数组+链表

插入的逻辑

1. 运算出key的hash值

2. (n - 1) & hash运算出数组的索引，存到数组对应索引的位置上去

   > n是数组的长度，由于一般运算出来的hash值很大，将其直接存进数组会浪费很多的数组空间
   >
   > 所以需要对hash再次执行运算，得到一个较小的数，用于实际存入的索引。
   >
   > 通常可以`hash % n`来得到分布比较密集的索引，但是算法实际上用的是`(n - 1) & hash`
   >
   > 有博客说，当n是2^m次幂时。（m任意正整数）
   >
   > 则(n - 1) & hash等价于(hash % n)
   >
   > 所以，扩充map的容量为2次方幂，就可以使用这个位移算法来保证数据的分布是密集的了

3. 如果数组对应的位置已经有元素，则索引对应元素的哈希和key与即将要存的数据进行比较。

   都一样，说明目标key已经存在，替换value就可以了

   hash一致，但key不相等，发生哈希冲突，取元素的next元素进行比较，以此类推，直至找到目标元素替换或者最后不存在，将新元素加在链表下面。

   hash不一致，依然用哈希冲突方式解决。

查询的逻辑

1. (n - 1) & hash运算出数组的索引
2. 该索引是否已有元素
3. 有，判断元素key和参数key是否完全一致

   	1. 是，找到目标元素
    2. 不是，哈希冲突，找下一个元素
4. 无，找不到元素

# 跳跃表

跳跃表是链表的改进，它改进了链表的查询效率，具体是这么实现的：

使用一段空间来保存链表的关键节点，通过对关键节点的查询而把查询限定在特定的小范围内，从而加快查询效率。

关键节点是分层的，也就是说，查询的时候，会先查询顶层的关键节点，找到范围后，再往下一层的关键节点继续寻找，一层层寻找直到抵达最底层。

而最底层，就是完整链表了。



通过一层层的查询，最终可以把查询范围限定在几个区域内。

这就是跳跃表的优势









 	
