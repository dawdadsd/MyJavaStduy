1. 基本介绍:
- ArrayList是List接口的可变长数组实现
- 支持所有可选的列表操作
- 允许存储所有元素(包括null)
- 提供了操作内部数组大小的方法
- 类似于Vector,但是非同步的

2. 性能特点:
- size()、isEmpty()、get()、set()、iterator()和listIterator()操作是常数时间O(1)
- add()操作是平摊常数时间,即添加n个元素需要O(n)时间
- 其他操作是线性时间O(n)
- 相比LinkedList实现,常数因子较小

3. 容量(capacity)机制:
- 每个ArrayList实例都有一个容量概念
- 容量是用于存储元素的内部数组的大小
- 容量始终大于等于列表的实际大小
- 添加元素时容量会自动增长
- 可以通过ensureCapacity操作提前增加容量,减少频繁扩容

4. 线程安全性警告:
- ArrayList不是线程安全的
- 如果多线程同时访问且至少有一个线程进行结构性修改,必须在外部同步
- 建议使用Collections.synchronizedList包装实现线程安全:
  ```java
  List list = Collections.synchronizedList(new ArrayList(...));
  ```

5. 快速失败(fail-fast)机制:
- iterator和listIterator方法返回的迭代器是快速失败的
- 如果在迭代过程中列表被结构性修改(除了通过迭代器自己的方法),会抛出ConcurrentModificationException
- 这种快速失败机制用于及早发现并发修改问题
- 这个机制不能保证绝对可靠,只应该用于检测bug

这些特性使ArrayList成为Java集合框架中最常用的List实现之一,特别适合于需要随机访问和动态增长的场景。

