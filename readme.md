# 数据结构

## 简介

数据结构即数据的组成形式，指数据元素之间存在的一种或多种特定关系的元素集合

## 数据结构的分类

1. 数据结构分为两类：一类是逻辑结构，一类是存储结构

### 逻辑结构

逻辑结构指的是数据集合中各个数据元素之间的相互关系。

根据数据元素之间存在着不同的逻辑关系构成了一下四种结构类型

1. 集合：集合中的元素除了都属于同一个集合外，他们之间并没有其他联系了。

2. 线性结构：该结构中的元素之间是一对一的关系。比如说链表集合

   链表中的每一个元素都存有对另一个元素的引用

3. 树结构：该数据结构中的元素是一对多的关系。比如说二叉树。看看二叉树的数据结构图片，就很容易理解了

4. 图结构：图结构中的元素是多对多的关系。

   > 笔者注：其实说到底，数据元素中的元素之间的关系就分为四种：无联系，一对一，一对多，多对多

### 存储结构

存储结构，顾名思义，就是数据结构在计算机的存储形式，又叫物理结构

一般说来，数据的存储结构应该能正确反映数据的逻辑结构

那么，其实存储结构也是分为两种的

1. 顺序存储：其实就是数据结构中的每一个元素的存储地址都是连续的。其逻辑结构和存储结构的关系是一致的

2. 链式存储：链式存储中的元素不是存储在连续的地址中。其存储结构不能反映逻辑结构。

   因此需要用指针来表示数据元素之间的逻辑关系                                        

## 抽象数据类型

一听到抽象就头大？没必要的。首先它只是一种数据类型，其次这种数据类型于计算机的内部实现无关

使用者不需要知道各个平台对于这种数据类型是如何实现的，因为抽象数据类型的使用，在任何平台上，都应该是一样的。

比如说，整数类型，windows有整数类型吧，linux也有整数类型吧。它们都可以进行加减乘除。

但是不同的处理器对其处理的方式不同。当然啦，我们拿来用就行了，不用管太多



## 算法

### 什么是算法

算法是解决特定问题步骤的描述

算法在计算机表现为有限的操作序列。操作序列包含了一组操作

每一个操作都完成了特定的功能

### 算法和数据结构的关系

有一句话说的好

`程序=算法+结构`

数据结构是算法实现的基础。

简单的说，算法设计就是对问题的数据选择一个恰当的数据结构并存储，然后在选定的数据结构设计一个好的算法

算法总是要依赖于算法进行实现的

### 算法的五大特性

1. 有穷性 ：有穷性是指算法在执行有限的步骤之后，自动结束而不会出现死循环
2. 确定性：算法的每一步骤都有明确的含义，不会出现歧义。算法相同的输入只能有一个唯一的输出结果
3. 可行性：算法的每一步都是可行的，也就是，每一步都能通过执行有限次数完成
4. 输入：算法具有零个或者多个输入
5. 输出：算法至少有一个或者多个输出

### 算法设计的四大目标

1. 正确性：包括四个层次

   1. 算法对应的程序没有语法吹无
   2. 对于几组输入的数据能得到满足规格的要求
   3. 对于特别准备的输入能得到满足规格的要求
   4. 对于一切合法的输入能得到满足规格的要求

2. 可读性：算法对应的程序一般能被人读懂，可读性有助于其他人对算法的理解。难懂的程序可能会隐含BUG不易被发现，难以调试和修改

3. 健壮性：算法对于输入数据不合法的情况下，也应该能进行反应和处理，而不会产生异常或者莫名其妙的错误

4. 高效率和低存储量

   这个指的当然就是算法的执行效率和所花费的内存空间了

## 链表数据结构

### 简介

链表是一种数据元素的线性集合

其顺序不是根据索引来确定的，而是通过每个元素的指向来确定的。

它是由一堆节点组成的数据结构。

链表更复杂的变体甚至允许添加额外的链表

链表通常可用来实现其他数据结构，如`lists`  `stacks`  `queues`   `associative arrays`    `S-expressions` 

注：

1. 每一个节点由数据和下一个节点的引用组成。

2. 链表结构可以高效的在迭代过程中插入或者删除元素

3. 链表不允许随机访问。

4. 最后一个节点的下一个节点的引用是表示链表结尾的终止符

5. 没必要为链表设置初始大小

### 链表的优缺点

#### 优点

1. 链表是一种动态结构，可以在程序过程中增长或者删除，来释放程序内存
2. 在链表中插入，删除操作非常简单
3. 动态数据结构（堆栈或者队列）可以用链表来实现
4. 可能可以在双向链表中进行反向遍历

### 缺点

1. 存储下一个节点的引用需要更多的内存

2. 链表的节点必须从头开始访问按顺序访问

3. 节点存储不规则，大大增加访问各个元素所需要的时间，尤其是在cpu高速缓存的情况下

4. 当是单向链表时，反向遍历比较麻烦。如果是双向链表，反向遍历会简单一点，但是会消耗更多的内存

### 基本概念和术语

1. 链表的每一个记录被称为元素或者节点
2. 每一个节点的中，包含下一个链接的数据被称为`next link` 或者`next pointer` 其他数据被称为`Data`

   `information`  `value`  `cargo（货物）`  `payload(有效载荷)`

### 单链表

单链表的每个节点都包含自身数据和指向下一个节点的链接

单链表能做的事有

1. 遍历

2. 删除

3. 插入

   > 代码已经包含如何创建一个单链表以及对链表进行遍历

### 双链表

在双链表中，每一个节点中，除了有指向下一节点的引用外，通常还有一个指向上一个节点的引用。

当然还会有数据。

前者被称为`forward` ,后者被成为`backwards` 或者`next` 以及`prev`

> 现代操作系统中，通常用双链表来维持对活动进程、线程，和其他动态对象的引用。
>
> 有一种攻击系统的手段就是把这些引用从链表中释放出来，用来逃避检测

### XOR-linking

这也是一种双链表，但是这种链表允许节点只有一个指向下一个节点引用的情况下，用这种节点创建双链表。

这是一种骚操作，需要对地址进行位操作，所以在一些高级语言不可用。java的话。。洗洗睡吧

### 链表应用：一元多项式的相加

什么是一元多项式？

一元：指的是表达式只有一个未知数

多项：指的是这个表达式有多个项相加，所以被称为多项

举例：$$3x^3+4x^2+5$$

在这个例子中，只有一个未知数X，有三个子项相加

另外，指数指的是未知数的幂，系数指的是未知数前面的常数

一元多项式相加的规则：

其实就是合并同类项了，把相同项（指数一致）的系数相加，其他不同项的保留下来

就是这么简单

那么用链表怎么实现多项式的加法呢？

任务：使用链表表达一个多项式，并设计两个多项式相加的程序

