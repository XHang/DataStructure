# 队列数据结构

## 第一章 :什么是队列

队列跟栈一样也是一种操作受限的线性表.但跟栈相反,队列只允许先进先出.

也就是说,最先进队列的,也是最先出队列的.

想想这跟排队是不是很像,没错,所以它起名为队列,不是没有道理的

有一个特性: ** 队列只允许在表的一端进行插入操作,在另一端进行删除操作 **

允许被插入的一端称为队尾

允许被删除的一端被称为队头

队列这种数据结构也有两种对应的物理结构

一种就是顺序,一种就是链式

## 第二种:顺序队列的建立

详细过程请看原代码

这里讲一下顺序队列的一个老毛病:   ** 假溢出 **

产生的条件.

比如一条队列是这样的

`1,2,3,4,5,6,7, , ,`

这个时候,队首指针就指向1这个位置,队尾指针就指向7这个位置

还查三个元素就补全了,可以召唤神龙了(大雾)

好,这个时候呢?我们就补全它吧.召唤神龙(有完没完)

`1,2,3,4,5,6,7,8,9,10 `

这个时候,队首指针还是指向1,队尾指针指向了10,此时队列满了

这个时候,1,2要溜了.于是,这个队列就变成了这个样子

`,,3,4,5,6,7,8,9,10`

此时,队首指针指向了3,队尾指针指向了10.

虽然此时队列还是有空位,但是却无法再插入了.

因为插入的一段只能在队尾,而队尾指针,已经到尾了.

这种情况就是** 假溢出 **

解决假溢出的方法就是创建循环顺序队列

具体的做法就是

当添加元素使队尾指针指向最大值时.如果想在添加元素,就需要将队尾指针指向0

当队头指针指向最大值时,如果想再移除元素,就要将队头指针指向0

但是还是有一个问题.

队列一开始初始化时,队首指针不变,然后一直添加元素,直至充满队列.

此时队尾指针指向末尾,然后想再添加元素,这时候,队尾指针又回到0这个位置了

跟队首指针重叠了.

这种情况叫什么来着,没错,队满,但是一开始队空也是这种重叠的情况.

那么,重叠的情况到底是队满还是队空呢?

各位朋友,你能猜到吗?







