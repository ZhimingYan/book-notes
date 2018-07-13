# java 基础

[Interview-notebook java基础](https://github.com/CyC2018/Interview-Notebook/blob/master/notes/Java%20%E5%9F%BA%E7%A1%80.md)

## 1.牛客网

1. [java 存根(stub)的作用：动态加载](https://www.nowcoder.com/questionTerminal/8b992ee9de5e40bb84f6fd29e69d842d?orderByHotValue=1&difficulty=11000&mutiTagIds=607_640&page=1&onlyReference=false)  

2. [Hibernate延迟加载的机制](https://blog.csdn.net/zhushuai1221/article/details/51737062)

> 1.当调用session上的load()加载一个实体时，会采用延迟加载。
2.当session加载某个实体时，会对这个实体中的集合属性值采用延迟加载
3.当session加载某个实体时，会对这个实体所有单端关联的另一个实体对象采用延迟加载。

3. equals 和"=="的区别

> 对于基本类型，没有equals函数，直接使用==来判断
对于引用类型，==判断两个实例是否引用同一个对象，equals()判断引用的对象是否等价。

4. 等价关系

自反性、对称性、传递性、一致性、非null性

## 2. Object的几个方法：

- 1. equals()方法的实现

> 检查是否为同一个对象的引用，如果是直接返回 true；
> 检查是否是同一个类型，如果不是，直接返回 false；
> 将 Object 实例进行转型；
> 判断每个关键域是否相等。

- 2. hashcode()

该方法返回散列值, equals()返回true的对象实例的hashcode()一定相同，反之不一定。

- 3. toString()
该方法返回类名@hashcode16进制b表示

- 4. clone()
该方法是Object类的一个protected方法，如果不显示覆盖也不实现Clonable接口的话，调用该方法就会抛出异常`java.lang.CloneNotSupportedException`  

- 5. 深拷贝与浅拷贝：

> 浅拷贝：拷贝实例和原始实例的引用类型引用同一个对象
> 深拷贝：拷贝实例和原始实例的引用类型引用不同对象

note: 使用 clone() 方法来拷贝一个对象即复杂又有风险，它会抛出异常，并且还需要类型转换。Effective Java 书上讲到，最好不要去使用 clone()，可以使用拷贝构造函数或者拷贝工厂来拷贝一个对象。

## 3. 继承

访问权限:
- private: 类访问权限，限于类内部访问
- protected: 继承访问权限，子类可见，通常修饰成员变量，对类没有意义
- 默认: 包级访问权限，同一个包内可见
- public: 公开访问权限，全部可见

使用权限控制是为了对模块进行封装，不过多暴露类的设计细节。

如果子类的方法覆盖了父类的方法，那么子类中该方法的访问级别不允许低于父类的访问级别。这是为了确保可以使用父类实例的地方都可以使用子类实例，也就是确保满足里氏替换原则。

抽象类与接口：

抽象类和抽象方法都使用 abstract 进行声明。抽象类一般会包含抽象方法，抽象方法一定位于抽象类中。
抽象类和普通类最大的区别是，抽象类不能被实例化，需要继承抽象类才能实例化其子类。

接口是抽象类的延伸，在 Java 8 之前，它可以看成是一个完全抽象的类，也就是说它不能有任何的方法实现。
从 Java 8 开始，接口也可以拥有默认的方法实现，这是因为不支持默认方法的接口的维护成本太高了。在 Java 8
之前，如果一个接口想要添加新的方法，那么要修改所有实现了该接口的类。

接口的成员（字段 + 方法）默认都是 public 的，并且不允许定义为 private 或者 protected。
接口的字段默认都是 static 和 final 的。

抽象类和接口的比较
  |    | 抽象类 | 接口
  --- | ---| ---
  设计| IS-A, 满足里式替换原则| LIKE-A, 提供一个方法实现契约
  使用| 单继承| 多实现
  字段| 无限制| static or final
  方法| 无限制| public

如何使用：

使用抽象类：

需要在几个相关的类中共享代码。
需要能控制继承来的方法和域的访问权限，而不是都为 public。
需要继承非静态（non-static）和非常量（non-final）字段。

使用接口：

需要让不相关的类都实现一个方法，例如不相关的类都可以实现 Compareable 接口中的 compareTo() 方法；
需要使用多重继承，例如Runnable接口实现线程类

## Super:

- 访问父类的构造函数：可以使用 super() 函数访问父类的构造函数，从而完成一些初始化的工作。
- 访问父类的成员：如果子类覆盖了父类的中某个方法的实现，可以通过使用 super 关键字来引用父类的方法实现。

## String

| | 是否可变| 是否线程安全
---| ---| ---
String | 否 | 是
StringBuffer | 是 | 是（内部通过synchronized来同步）
StringBuilder | 是 | 否

String 不可变的原因：
- 可以缓存hash值
- 常量池需要
- 线程安全

使用 String.intern() 可以保证相同内容的字符串实例引用相同的内存对象。

## 基本类型的封装类型
自动拆装箱，直接使用赋值

boolean/1
byte/8
char/16
short/16
int/32
float/32
long/64
double/64

## 反射机制

Class 类和java.lang.reflect类库

Field ：可以使用 get() 和 set() 方法读取和修改 Field 对象关联的字段；
Method ：可以使用 invoke() 方法调用与 Method 对象关联的方法；
Constructor ：可以用 Constructor 创建新的对象。

通过java的反射机制也可以创建对象，操作类或者对象的内部属性。

用法：
1.在运行时判断任意一个对象所属的类；
2.在运行时构造任意一个类的对象；
3.在运行时判断任意一个类所具有的成员变量和方法（通过反射甚至可以调用private方法）；
4.在运行时调用任意一个对象的方法


## Synchronized 和 volitate区别

[volatile与synchronized的区别](https://www.cnblogs.com/tf-Y/p/5266710.html)

1) volatile本质是在告诉jvm当前变量在寄存器中的值是不确定的,需要从主存中读取,synchronized则是锁定当前变量,只有当前线程可以访问该变量,其他线程被阻塞住.
2) volatile仅能使用在变量级别,synchronized则可以使用在变量,方法.
3) volatile仅能实现变量的修改可见性,而synchronized则可以保证变量的修改可见性和原子性.
　　《Java编程思想》上说，定义long或double变量时，如果使用volatile关键字，就会获得（简单的赋值与返回操作）原子性
4) volatile不会造成线程的阻塞,而synchronized可能会造成线程的阻塞.
5) 当一个域的值依赖于它之前的值时，volatile就无法工作了，如n=n+1,n++等。如果某个域的值受到其他域的值的限制，那么volatile也无法工作，如Range类的lower和upper边界，必须遵循lower<=upper的限制。
6) 使用volatile而不是synchronized的唯一安全的情况是类中只有一个可变的域。

## 异常

Throwable 可以用来表示任何可以作为异常抛出的类，分为两种： Error 和 Exception。其中 Error 用来表示 JVM 无法处理的错误，Exception 分为两种：

受检异常 ：需要用 try...catch... 语句捕获并进行处理，并且可以从异常中恢复；
非受检异常 ：是程序运行时错误，例如除 0 会引发 Arithmetic Exception，此时程序奔溃并且无法恢复。
![throwable](img/Throwable.png)  

[java入门之异常处理](https://www.tianmaying.com/tutorial/Java-Exception)

## 泛型

[java 泛型详解](http://www.importnew.com/24029.html)

## 注解

Java 注解是附加在代码中的一些元信息，用于一些工具在编译、运行时进行解析和使用，起到说明、配置的功能。注解不会也不能影响代码的实际逻辑，仅仅起到辅助性的作用。

[注解 Annotation 实现原理与自定义注解例子](https://www.cnblogs.com/acm-bingzi/p/javaAnnotation.html)

注解利用了java的反射机制来实现对对象的动态配置

## 面向对象

[封装、继承、多态 三大特性](https://github.com/CyC2018/Interview-Notebook/blob/master/notes/%E9%9D%A2%E5%90%91%E5%AF%B9%E8%B1%A1%E6%80%9D%E6%83%B3.md#%E5%B0%81%E8%A3%85%E7%BB%A7%E6%89%BF%E5%A4%9A%E6%80%81)

[面向对象编程三大特性------封装、继承、多态](https://blog.csdn.net/jianyuerensheng/article/details/51602015)

### 封装

尽可能的隐藏类的设计细节，只保留部分对外开放的接口，有利于减少模块间的耦合，减轻维护负担，有效调节性能，提高软件的重用性，降低构建大型系统的风险（整体不可用，部分模块可用）

### 继承

继承应该遵循里氏替换原则，子类对象必须能够替换掉所有父类对象。

当超类对象引用变量引用子类对象时，被引用对象的类型而不是引用变量的类型决定了调用谁的成员方法，但是这个被调用的方法必须是在超类中定义过的，也就是说被子类覆盖的方法。（但是如果强制把超类转换成子类的话，就可以调用子类中新添加而超类没有的方法了。）

在继承链中对象方法的调用存在一个优先级：this.show(O)、super.show(O)、this.show((super)O)、super.show((super)O)。

### 多态

多态分为编译时多态和运行时多态。编译时多态主要指方法的重载，运行时多态指程序中定义的对象引用所指向的具体类型在运行期间才确定。

运行时多态有三个条件：

- 继承
- 覆盖（重写）
- 向上转型（父类引用指向子类对象）

## 设计原则

S.O.L.I.D 原则  
|简写 |	全拼	| 中文翻译 | 简述
--- | --- | --- | ---
SRP|	The Single Responsibility Principle |	单一责任原则 | 一个类制作一件事，解耦合 
OCP|	The Open Closed Principle	 | 开放封闭原则 | 添加新功能的时候，不需要修改代码，典型的就是装饰者模式 
LSP|	The Liskov Substitution Principle	|里氏替换原则 | 子类能够当成父类用，需要比父类更加特殊 
ISP|	The Interface Segregation Principle	|接口分离原则 | 不强迫客户实现不需要用的接口，即接口功能上的分离 
DIP|	The Dependency Inversion Principle | 依赖倒置原则 | 高层模块不应该依赖于低层模块，二者都应该依赖于抽象

## 类图

[看懂UML类图](http://design-patterns.readthedocs.io/zh_CN/latest/read_uml.html#generalization)

### 设计模式

[创建型模式](http://xraorao.top/2017/04/07/java%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F%EF%BC%88%E4%B8%80%EF%BC%89%EF%BC%9A%E5%88%9B%E5%BB%BA%E5%9E%8B%E6%A8%A1%E5%BC%8F/)  
[结构型模式](http://xraorao.top/2017/04/07/java%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F%EF%BC%88%E4%BA%8C%EF%BC%89%EF%BC%9A%E7%BB%93%E6%9E%84%E5%9E%8B%E6%A8%A1%E5%BC%8F/)  
[行为型模式](http://xraorao.top/2017/04/07/java%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F%EF%BC%88%E4%B8%89%EF%BC%89%EF%BC%9A%E8%A1%8C%E4%B8%BA%E5%9E%8B%E6%A8%A1%E5%BC%8F/)  

# java 知音（面试集锦）

## 1. java基础

1. .java 源文件只有一个public 类，且public文件名和类名必须一致
2. goto 是java的保留关键字，但是没有被使用
3. switch 语句的表达式中，只能使用`整数、String`或者`枚举常量`
4. final 修饰的变量时，是指引用变量不能变，引用变量所指向的内容是可以改变的。
``` java
final StringBuffer aa =  new StringBuffer("aa");
aa = new StringBuffer("dd"); // error
aa.append("bb"); // no error
```
5. Integer 默认null, int 默认0
6. override 和 overload 区别？

- override, 重写

用于子类继承父类或者实现接口的时候，子类方法名和方法参数完全和父类相同，且覆盖的返回值必须和被覆盖的方法返回一致，覆盖的方法所抛出的一场和被覆盖的方法的返回一致，或者其子类。被覆盖的方法不能是private类型。

- overload, 重载

函数的重载，不同的参数样式可以重载一个相同的函数名的函数

7. 接口和抽象类区别？

- 1. 继承

接口可以继承接口，可以被抽象类实现。抽象类可以继承具体类，抽象类也可以有静态的main方法,但是抽象类不能被实例化。

- 2. 区别

 |抽象类 | 接口
---|--- | ---
构造函数| 有| 无
普通成员变量| 有 | 无
非abstract 方法 | 有  | 无
访问修饰符 | public, protected | 默认也只能是public
静态方法 | 有 | 无
静态成员变量 | 访问类型任意 | 默认也只能是public static final
其他| 单继承 | 多实现

8. java 实现多态机制

靠的是父类或接口定义的引用变量可以指向子类或具体实现类的实例对象，而程序调用的方法在运行期才动态绑定，就是引用变量所指向的具体实例对象的方法，也就是内存里正在运行的那个对象的方法，而不是引用变量的类型中定义的方法。

9. 内部类的访问

内部类可以访问包含类的成员，如果是静态内部类的话，就只能访问外部类的静态成员。

## 2. java 集合类

10. ArrayList 和 Vector的区别

 项 | ArrayList | Vector 
 --- | --- | ---
同步性 | 线程不安全 | 线程安全
数据增长| 默认增长为原来的两倍 | 默认增长为原来的1.5倍

11. HashMap 和 HashTable 区别

- hashmap

hashmap 是 HashTable 的轻量级实现，线程不安全，允许空键值对（null), 单线程下，效率比hashtable高

- hashtable

继承自Directionary类， 线程安全，使用Synchronized 同步方法。hashtable是一个废弃的类，java5 以上，可以使用ConcurrentHashMap来代替使用

12. == 和 "equals" 区别

== 在基本数据类型的时候，比较的是值，在对象对的时候，比较的是两个对象的地址值，除非是同一个new出来的对象，不然==结果为false

equals 是Object类的一个方法，在复合数据类型下被覆盖掉，如果没有覆盖用的还是比较地址的方法，和"=="等价

13. List Map Set 接口区别 

- List：

有序的集合

- Map:

双列元素的集合

- set:

无序元素的集合，且无法拥有重复元素

14. LinkedList

双向链表实现的存储，插入速度快，但是随机读取就慢了很多

15.  String 、 StringBuffer和StringBuilder的区别

- 运行速度：

StingBuilder > StringBuffer > String

String为字符串常量，而StringBuilder和StringBuffer均为字符串变量，即String对象一旦创建之后该对象是不可更改的，但后两者的对象是变量，是可以更改的

``` java
String str = "abc";
str = str + "de";// 原来的"abc"没了，下次GC会被回收掉，创建了一个新的str变量

```

- 线程安全

在线程安全上，StringBuilder是线程不安全的，而StringBuffer是线程安全的

如果一个StringBuffer对象在字符串缓冲区被多个线程使用时，StringBuffer中很多方法可以带有synchronized关键字，所以可以保证线程是安全的，但StringBuilder的方法则没有该关键字，所以不能保证线程安全，有可能会出现一些错误的操作。所以如果要进行的操作是多线程的，那么就要使用StringBuffer，但是在单线程的情况下，还是建议使用速度比较快的StringBuilder。

- 总结

String：适用于少量的字符串操作的情况

StringBuilder：适用于单线程下在字符缓冲区进行大量操作的情况

StringBuffer：适用多线程下在字符缓冲区进行大量操作的情况

16. final finally finalize 区别

final 用于声明属性，方法和类，分别表示属性不可变，方法不可覆盖，类不可继承。内部类要访问局部变量，局部变量必须定义成final类型。

finally是异常处理语句结构的一部分，表示总是执行。

finalize是Object类的一个方法，在垃圾收集器执行的时候会调用被回收对象的此方法，可以覆盖此方法提供垃圾收集时的其他资源回收，例如关闭文件等。但是JVM不保证此方法总被调用

17. java 序列化的实现方法是什么？解释Serializable的作用

OutputStream.writeObject方法可以实现java对象的序列化，如果想要java自动实现，则需要实现Serializable接口


18. heap 和 stack 的区别

java的内存分为两类，一类是栈内存，一类是堆内存。栈内存是指程序进入一个方法时，会为这个方法单独分配一块私属存储空间，用于存储这个方法内部的局部变量，当这个方法结束时，分配给这个方法的栈会释放，这个栈中的变量也将随之释放。

堆是与栈作用不同的内存，一般用于存放不在当前方法栈中的那些数据，例如，使用new创建的对象都放在堆里，所以，它不会随方法的结束而消失。方法中的局部变量使用final修饰后，放在堆中，而不是栈中。

19. Java 中，throw 和 throws 有什么区别

throw 用于抛出 java.lang.Throwable 类的一个实例化对象，意思是说你可以通过关键字 throw 抛出一个Exception，如：
throw new IllegalArgumentException(“XXXXXXXXX″)

而throws 的作用是作为方法声明和签名的一部分，方法被抛出相应的异常以便调用者能处理。Java 中，任何未处理的受检查异常强制在 throws 子句中声明。

## java web 

20. servlet 的生命周期

Servlet有良好的生存期的定义，包括加载和实例化、初始化、处理请求以及服务结束。这个生存期由javax.servlet.Servlet接口的init(),service()和destroy方法表达。

Servlet被服务器实例化后，容器运行其init方法，请求到达时运行其service方法，service方法自动派遣运行与请求对应的doXXX方法（doGet，doPost）等，当服务器决定将实例销毁的时候调用其destroy方法。

web容器加载servlet，生命周期开始。通过调用servlet的init()方法进行servlet的初始化。通过调用service()方法实现，根据请求的不同调用不同的do***()方法。结束服务，web容器调用servlet的destroy()方法。

21. Servlet API中forward()与redirect()的区别？

1.从地址栏显示来说
forward是服务器请求资源,服务器直接访问目标地址的URL,把那个URL的响应内容读取过来,然后把这些内容再发给浏览器.浏览器根本不知道服务器发送的内容从哪里来的,所以它的地址栏还是原来的地址.
redirect是服务端根据逻辑,发送一个状态码,告诉浏览器重新去请求那个地址.所以地址栏显示的是新的URL.所以redirect等于客户端向服务器端发出两次request，同时也接受两次response。
2.从数据共享来说
forward:转发页面和转发到的页面可以共享request里面的数据.
redirect:不能共享数据.
redirect不仅可以重定向到当前应用程序的其他资源,还可以重定向到同一个站点上的其他应用程序中的资源,甚至是使用绝对URL重定向到其他站点的资源.
forward方法只能在同一个Web应用程序内的资源之间转发请求.forward 是服务器内部的一种操作.
redirect 是服务器通知客户端,让客户端重新发起请求.
所以,你可以说 redirect 是一种间接的请求, 但是你不能说”一个请求是属于forward还是redirect ”
3.从运用地方来说
forward:一般用于用户登陆的时候,根据角色转发到相应的模块.
redirect:一般用于用户注销登陆时返回主页面和跳转到其它的网站等.
4.从效率来说
forward:高.
redirect:低

22. request.getAttribute()和 request.getParameter()有何区别?

1，request.getParameter()取得是通过容器的实现来取得通过类似post，get等方式传入的数据。

request.setAttribute()和getAttribute()只是在web容器内部流转，仅仅是请求处理阶段。

2，getAttribute是返回对象,getParameter返回字符串

3，getAttribute()一向是和setAttribute()一起使用的，只有先用setAttribute()设置之后，才能够通过getAttribute()来获得值，它们传递的是Object类型的数据。而且必须在同一个request对象中使用才有效。,而getParameter()是接收表单的get或者post提交过来的参数

23. jsp静态包含和动态包含的区别

1、<%@include file=”xxx.jsp”%>为jsp中的编译指令，其文件的包含是发生在jsp向servlet转换的时期，而<jsp:include page=”xxx.jsp”>是jsp中的动作指令，其文件的包含是发生在编译时期，也就是将java文件编译为class文件的时期

2、使用静态包含只会产生一个class文件，而使用动态包含会产生多个class文件

3、使用静态包含，包含页面和被包含页面的request对象为同一对象，因为静态包含只是将被包含的页面的内容复制到包含的页面中去；而动态包含包含页面和被包含页面不是同一个页面，被包含的页面的request对象可以取到的参数范围要相对大些，不仅可以取到传递到包含页面的参数，同样也能取得在包含页面向下传递的参数

24. MVC的各个部分都有那些技术来实现?如何实现?

MVC是Model－View－Controller的简写。Model代表的是应用的业务逻辑（通过JavaBean，EJB组件实现），View是应用的表示面（由JSP页面产生），Controller是提供应用的处理过程控制（一般是一个Servlet），通过这种设计模型把应用逻辑，处理过程和显示逻辑分成不同的组件实现。这些组件可以进行交互和重用

25. jsp有哪些内置对象?作用分别是什么?

JSP共有以下9个内置的对象：

1，request 用户端请求，此请求会包含来自GET/POST请求的参数

2，response 网页传回用户端的回应

3，pageContext 网页的属性是在这里管理

4，session 与请求有关的会话期

5，application servlet 正在执行的内容

6，out 用来传送回应的输出

7，config  servlet的构架部件

8，page JSP网页本身

9，exception 针对错误网页，未捕捉的例外

26. Http中，get和post方法的区别

1，Get是向服务器发索取数据的一种请求，而Post是向服务器提交数据的一种请求

2，Get是获取信息，而不是修改信息，类似数据库查询功能一样，数据不会被修改

3，Get请求的参数会跟在url后进行传递，请求的数据会附在URL之后，以?分割URL和传输数据，参数之间以&相连,％XX中的XX为该符号以16进制表示的ASCII，如果数据是英文字母/数字，原样发送，如果是空格，转换为+，如果是中文/其他字符，则直接把字符串用BASE64加密。
4，Get传输的数据有大小限制，因为GET是通过URL提交数据，那么GET可提交的数据量就跟URL的长度有直接关系了，不同的浏览器对URL的长度的限制是不同的。

5，GET请求的数据会被浏览器缓存起来，用户名和密码将明文出现在URL上，其他人可以查到历史浏览记录，数据不太安全。

在服务器端，用Request.QueryString来获取Get方式提交来的数据
Post请求则作为http消息的实际内容发送给web服务器，数据放置在HTML Header内提交，Post没有限制提交的数据。Post比Get安全，当数据是中文或者不敏感的数据，则用get，因为使用get，参数会显示在地址，对于敏感数据和不是中文字符的数据，则用post。
6，POST表示可能修改变服务器上的资源的请求，在服务器端，用Post方式提交的数据只能用Request.Form来获取。

27. 什么是cookie？Session和cookie有什么区别？

Cookie是会话技术,将用户的信息保存到浏览器的对象.

区别：

(1)cookie数据存放在客户的浏览器上，session数据放在服务器上
(2)cookie不是很安全，别人可以分析存放在本地的COOKIE并进行COOKIE欺骗,如果主要考虑到安全应当使用session
(3)session会在一定时间内保存在服务器上。当访问增多，会比较占用你服务器的性能，如果主要考虑到减轻服务器性能方面，应当使用COOKIE
(4)单个cookie在客户端的限制是3K，就是说一个站点在客户端存放的COOKIE不能3K。

结论：

将登陆信息等重要信息存放为SESSION;其他信息如果需要保留，可以放在COOKIE中。

28. jsp和servlet的区别、共同点、各自应用的范围？

JSP是Servlet技术的扩展，本质上就是Servlet的简易方式。JSP编译后是“类servlet”。

Servlet和JSP最主要的不同点在于：Servlet的应用逻辑是在Java文件中，并且完全从表示层中的HTML里分离开来。而JSP的情况是Java和HTML可以组合成一个扩展名为.jsp的文件。

JSP侧重于视图，Servlet主要用于控制逻辑。在struts框架中,JSP位于MVC设计模式的视图层,而Servlet位于控制层.

29. tomcat容器是如何创建servlet类实例？用到了什么原理？

当容器启动时，会读取在webapps目录下所有的web应用中的web.xml文件，然后对xml文件进行解析，并读取servlet注册信息。然后，将每个应用中注册的servlet类都进行加载，并通过反射的方式实例化。（有时候也是在第一次请求时实例化）
在servlet注册时加上<load-on-startup>1</load-on-startup>如果为正数，则在一开始就实例化，如果不写或为负数，则第一次请求实例化。

30. JDBC 访问数据库的步骤

1. 加载驱动
2. 获取Connection
3. 获取回话
4. 通过回话进行数据的增删查改，封装对象
5. 关闭资源

31. preparedStatement和statement的区别

预编译效率高，对相同的sql语句不会再次编译，并且可以有效的避免sql注入攻击

32. 事务的概念

单个逻辑工作单元执行的一系列操作，单个逻辑工作单元必须有四个属性，原子性，一致性，隔离性和持久性（ACID)的属性，只有这样才能成为一个事务

- 1. 原子性（Atomicity）
事务被视为不可分割的最小单元，事务的所有操作要么全部提交成功，要么全部失败回滚。

回滚可以用日志来实现，日志记录着事务所执行的修改操作，在回滚时反向执行这些修改操作即可。

- 2. 一致性（Consistency）
数据库在事务执行前后都保持一致性状态。

在一致性状态下，所有事务对一个数据的读取结果都是相同的。

- 3. 隔离性（Isolation）
一个事务所做的修改在最终提交以前，对其它事务是不可见的。

- 4. 持久性（Durability）
一旦事务提交，则其所做的修改将会永远保存到数据库中。即使系统发生崩溃，事务执行的结果也不能丢失。

可以通过数据库备份和恢复来实现，在系统发生崩溃时，使用备份的数据库进行数据恢复。

事务的 ACID 特性概念简单，但不是很好理解，主要是因为这几个特性不是一种平级关系：

只有满足一致性，事务的执行结果才是正确的。
在无并发的情况下，事务串行执行，隔离性一定能够满足。此时要只要能满足原子性，就一定能满足一致性。
在并发的情况下，多个事务并发执行，事务不仅要满足原子性，还需要满足隔离性，才能满足一致性。
事务满足持久化是为了能应对数据库崩溃的情况。

33. JDBC的脏读和幻影读

脏读： 指的是一行数据刚更新，另外一个查询读到了这个刚更新的值，这样就导致了脏读，因为更新的数据还没哟持久化，有可能进行回滚。

幻影读： 指的是一个事务多次执行一条查询，返回的却是不同的值。例如，当一个事务正在根据某个条件进行数据查询，然后另一个事务插入了一行满足条件的数据，之后事务再次执行了这条查询，返回的结果会包含刚插入的新数据，这行新数据成为幻行，这种现象就叫做幻读。


34. execute，executeQuery，executeUpdate的区别是什么？
1，Statement的execute(String query)方法用来执行任意的SQL查询，如果查询的结果是一个ResultSet，这个方法就返回true。如果结果不是ResultSet，比如insert或者update查询，它就会返回false。我们可以通过它的getResultSet方法来获取ResultSet，或者通过getUpdateCount()方法来获取更新的记录条数。
2，Statement的executeQuery(String query)接口用来执行select查询，并且返回ResultSet。即使查询不到记录返回的ResultSet也不会为null。我们通常使用executeQuery来执行查询语句，这样的话如果传进来的是insert或者update语句的话，它会抛出错误信息为 “executeQuery method can not be used for update”的java.util.SQLException。 ,
3，Statement的executeUpdate(String query)方法用来执行insert或者update/delete（DML）语句，或者 什么也不返回，对于DDL语句，返回值是int类型，如果是DML语句的话，它就是更新的条数，如果是DDL的话，就返回0。
只有当你不确定是什么语句的时候才应该使用execute()方法，否则应该使用executeQuery或者executeUpdate方法。

35. 数据库的三范式

第一范式：数据库表的每一个字段都是不可分割的

第二范式：数据库表中的非主属性只依赖于主键

第三范式：不存在非主属性对关键字的传递函数依赖关系

## java 多线程

1. 进程和线程区别  

- 定义：

进程：具有一定的独立功能的程序关于某个数据集合上的一次运行活动，进程是系统进行资源分配和调度的一个独立的单位

线程：进程的一个实体，是CPU调度和分派的基本单位,它是比进程更小的能独立运行的基本单位.线程自己基本上不拥有系统资源,只拥有一点在运行中必不可少的资源(如程序计数器,一组寄存器和栈),但是它可与同属一个进程的其他的线程共享进程所拥有的全部资源。

- 关系：

一个线程可以创建和撤销另一个线程;同一个进程中的多个线程之间可以并发执行.

相对进程而言，线程是一个更加接近于执行体的概念，它可以与同进程中的其他线程共享数据，但拥有自己的栈空间，拥有独立的执行序列。

- 区别：
进程和线程的主要差别在于它们是不同的操作系统资源管理方式。进程有独立的地址空间，一个进程崩溃后，在保护模式下不会对其它进程产生影响，而线程只是一个进程中的不同执行路径。线程有自己的堆栈和局部变量，但线程之间没有单独的地址空间，一个线程死掉就等于整个进程死掉，所以多进程的程序要比多线程的程序健壮，但在进程切换时，耗费资源较大，效率要差一些。但对于一些要求同时进行并且又要共享某些变量的并发操作，只能用线程，不能用进程。

1) 简而言之,一个程序至少有一个进程,一个进程至少有一个线程.

2) 线程的划分尺度小于进程，使得多线程程序的并发性高。

3) 另外，进程在执行过程中拥有独立的内存单元，而多个线程共享内存，从而极大地提高了程序的运行效率。

4) 线程在执行过程中与进程还是有区别的。每个独立的线程有一个程序运行的入口、顺序执行序列和程序的出口。但是线程不能够独立执行，必须依存在应用程序中，由应用程序提供多个线程执行控制。

5) 从逻辑角度来看，多线程的意义在于一个应用程序中，有多个执行部分可以同时执行。但操作系统并没有将多个线程看做多个独立的应用，来实现进程的调度和管理以及资源分配。这就是进程和线程的重要区别。

- 优缺点：
线程和进程在使用上各有优缺点：

线程执行开销小，但不利于资源的管理和保护；

而进程正相反。

同时，线程适合于在SMP机器上运行，而进程则可以跨机器迁移。

2.  [java volatile 和 synchronized 作用和区别](http://xraorao.top/2016/10/24/%E8%BD%AC-Java%E7%BA%BF%E7%A8%8B%E5%90%8C%E6%AD%A5%EF%BC%8Csynchronized%E9%94%81%E4%BD%8F%E7%9A%84%E6%98%AF%E4%BB%A3%E7%A0%81%E8%BF%98%E6%98%AF%E5%AF%B9%E8%B1%A1/)

- volatile

在Java内存模型中，有main memory，每个线程也有自己的memory (例如寄存器)。为了性能，一个线程会在自己的memory中保持要访问的变量的副本。这样就会出现同一个变 量在某个瞬间，在一个线程的memory中的值可能与另外一个线程memory中的值，或者main memory中的值不一致的情况。 一个变量声明为volatile，就意味着这个变量是随时会被其他线程修改的，因此不能将它cache在线程memory中

- synchronized

当它用来修饰一个方法或者一个代码块的时候，能够保证在同一时刻最多只有一个线程执行该段代码。

一、当两个并发线程访问同一个对象object中的这个synchronized(this)同步代码块时，一个时间内只能有一个线程得到执行。另一个线程必须等待当前线程执行完这个代码块以后才能执行该代码块。

二、然而，当一个线程访问object的一个synchronized(this)同步代码块时，另一个线程仍然可以访问该object中的非synchronized(this)同步代码块。

三、尤其关键的是，当一个线程访问object的一个synchronized(this)同步代码块时，其他线程对object中所有其它synchronized(this)同步代码块的访问将被阻塞。

四、当一个线程访问object的一个synchronized(this)同步代码块时，它就获得了这个object的对象锁。结果，其它线程对该object对象所有同步代码部分的访问都被暂时阻塞。

五、以上规则对其它对象锁同样适用.


3. 线程之间通信的机制

共享内存和消息传递

[共享内存的并发模型](http://ifeve.com/java-memory-model-0/)

4. 如何避免死锁

死锁的发生必须满足以下四个条件：

互斥条件：一个资源每次只能被一个进程使用。

请求与保持条件：一个进程因请求资源而阻塞时，对已获得的资源保持不放。

不剥夺条件：进程已获得的资源，在末使用完之前，不能强行剥夺。

循环等待条件：若干进程之间形成一种头尾相接的循环等待资源关系。

三种用于避免死锁的技术：

加锁顺序（线程按照一定的顺序加锁）

加锁时限（线程尝试获取锁的时候加上一定的时限，超过时限则放弃对该锁的请求，并释放自己占有的锁）

死锁检测

（死锁原因及如何避免更深理解移步：http://blog.csdn.net/ls5718/article/details/51896159）

## java 算法

