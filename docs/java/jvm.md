## 1 Java技术体系

组成部分：java程序设计语言、java virtual machine(JVM)、class文件的格式、java api 类库、第三方类库

其中java语言、JVM、JAVA API类库称为JDK，JDK是支持java程序的最小开发环境。JAVA API类库中的JAVA SE API子集和JVM统称为JRE（java runtime environment)，JRE是支持java程序运行的标准环境

JAVA ME: 移动库  
JAVA SE: 标准库  
JAVA EE：企业库  

### JVM

jvm版本众多，使用范围较广的有SUN JDK(Oracle JDK)和 OpenJDK。也有其他的如，Apache Harmony VM、Microsoft JVM 

## 2 java 自动内存管理机制

java 虚拟机运行时的数据分区如下：

<div align="center"> <img src="img/jvm-data.png" width=""/> </div><br>

**线程私有：**

- 虚拟机栈(jvm stack)： 

jvm stack 的生命周期和线程相同，虚拟机栈描述的是java方法执行的内存模型：每个方法执行的同时都会创建一个栈帧,用于存储 **局部变量表**，**操作数栈**，**动态链接**， **方法出口** 等信息，每一个方法从调用到完成的过程就对应着一个栈帧在虚拟机栈中入栈到出栈的过程。

通常所说的`栈内存`指的是虚拟机栈中的**局部变量表**部分，存放了编译期间可知的各种基本数据类型、对象引用。其中long和double类型的数据会占用2个局部变量空间，其他只占1个。

局部变量表的空间大小在编译期间就已经完成分配，运行期间不会改变局部变量表的大小。

在jvm规范中，对这个区域规定了两种异常情况：  

1. 如果线程请求的栈深度大于虚拟机所允许的深度，则抛出StackOverflowError异常
2. 如果jvm设置了动态扩展虚拟机栈的话，则会抛出OutOfMemoryError异常

例如在函数递归调用深度过深的话可能导致栈溢出异常。

- 本地方法栈(native method statck):

和虚拟机栈非常相似，区别在于虚拟机栈为虚拟机执行Java方法，而本地方法栈执行的是Java Native 方法服务。

- 程序计数器(program counter register):

当前线程所执行的字节码的行号指示器，记录正在执行的虚拟机字节码指令的地址（如果正在执行的是本地方法则为空）

**线程共享：**

- 堆(Heap)

Java 堆是被所有`线程共享`的一块内存区域，唯一目的是存放对象实例，是jvm中内存最大的一块。也是java GC的主要区域。

java堆也称为"GC"堆，现在的垃圾收集器大多采用分代收集。

- 方法区(Method Area):

  方法区和java堆一样，是各个`线程共享`的内存区域，用来存储被虚拟机加载的类信息、常量、静态变量、即时编译后的代码数据
  - 运行时常量池

直接内存(Direct Memory)：

