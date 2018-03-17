# 实现Singleton模式
---
## 题目要求

设计一个类，我们只能生成该类的一个实例

## 1. 懒汉模式(线程不安全)

说明：调用时加载，减少内存占用，但线程不安全
``` java
/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Singleton1.java
 * Date: 18-3-17 下午7:09
 * Author: Xiong Raorao
 */

package top.xraorao.sword.singleton;

/**
 * 1. 懒汉式（线程不安全）.
 *
 * @author Xiong Raorao
 * @since 2018-03-17-19:09
 */
public class Singleton1 {

  private static Singleton1 instance;

  private Singleton1() {
  }

  public static Singleton1 getInstance() {
    if (instance == null) {
      instance = new Singleton1();
    }
    return instance;
  }

}
```
---
## 2. 懒汉模式（线程安全）

说明：给getInstance()函数加一个同步锁，保证线程安全
``` java
/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Singleton2.java
 * Date: 18-3-17 下午7:08
 * Author: Xiong Raorao
 */

package top.xraorao.sword.singleton;

/**
 * 2. 懒汉式（线程安全）
 *
 * @author Xiong Raorao
 * @since 2018-03-17-19:08
 */
public class Singleton2 {
  private static Singleton2 instance;

  private Singleton2() {
  }

  public static synchronized Singleton2 getInstance() {
    if (instance == null) {
      instance = new Singleton2();
    }
    return instance;
  }

}
```
---
## 3. 饿汉式

说明：在jvm加载该类的时候就初始化，利用jvm的类加载机制，避免多线程问题，但是会增加内存占用

``` java
/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Singleton3.java
 * Date: 18-3-17 下午7:11
 * Author: Xiong Raorao
 */

package top.xraorao.sword.singleton;

/**
 * 3. 饿汉式.
 *
 * <p>避免多线程的问题，但是会导致类在加载的时候就实例化了，增大内存占用</p>
 *
 * @author Xiong Raorao
 * @since 2018-03-17-19:10
 */
public class Singleton3 {

  private static Singleton3 instance = new Singleton3();

  private Singleton3() {
  }

  public static Singleton3 getInstance() {
    return instance;
  }

}
```
---
## 4. 静态内部类方法

说明： 在饿汉式的基础上，利用静态内部类实现lazy loading模式，同时避免了多线程问题
``` java
/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Singleton4.java
 * Date: 18-3-17 下午7:12
 * Author: Xiong Raorao
 */

package top.xraorao.sword.singleton;

/**
 * 4. 静态内部类.
 *
 * <p>实现了延迟加载功能，利用class loader 的机制同时避免了多线程问题</p>
 *
 * @author Xiong Raorao
 * @since 2018-03-17-19:11
 */
public class Singleton4 {

  private static class SingletonHolder {

    private static final Singleton4 INSTANCE = new Singleton4();
  }

  private Singleton4() {
  }

  public static final Singleton4 getInstance() {
    return SingletonHolder.INSTANCE;
  }

}
```
---
## 5. 枚举类型

说明：使用枚举类型，不仅能避免多线程同步问题，而且还能防止反序列化重新创建新的对象
``` java
/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Singleton5.java
 * Date: 18-3-17 下午7:12
 * Author: Xiong Raorao
 */

package top.xraorao.sword.singleton;

/**
 * 5. 枚举方法
 *
 * <p>effective java 推荐方法,非lazy load, 线程安全，可以防止反序列化</p>
 *
 * @author Xiong Raorao
 * @since 2018-03-17-19:12
 */
public class Singleton5 {

  public static enum SingletonHander {
    INSTANCE;
    private Singleton5 singleton;

    // jvm will assure this method called only once.
    SingletonHander() {
      singleton = new Singleton5();
    }

    public Singleton5 getInstance() {
      return singleton;
    }
  }

}
```
---
## 6. 双重锁机制

说明： 方式2的增强版
```
/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Singleton6.java
 * Date: 18-3-17 下午7:13
 * Author: Xiong Raorao
 */

package top.xraorao.sword.singleton;

/**
 * 6. 双重校验锁.
 *
 * @author Xiong Raorao
 * @since 2018-03-17-19:13
 */
public class Singleton6 {

  private volatile static Singleton6 singleton;

  private Singleton6() {
  }

  public static Singleton6 getInstatnce() {
    if (singleton == null) {
      synchronized (Singleton6.class) {
        if (singleton == null) {
          singleton = new Singleton6();
        }
      }
    }
    return singleton;
  }

}
```
---
## 总结

注意：
有两个问题需要注意：

1.如果单例由不同的类装载器装入，那便有可能存在多个单例类的实例。假定不是远端存取，例如一些servlet容器对每个servlet使用完全不同的类装载器，这样的话如果有两个servlet访问一个单例类，它们就都会有各自的实例。

2.如果Singleton实现了java.io.Serializable接口，那么这个类的实例就可能被序列化和复原。不管怎样，如果你序列化一个单例类的对象，接下来复原多个那个对象，那你就会有多个单例类的实例。

问题1的修复方法：
``` java
private static Class getClass(String classname)      
                                         throws ClassNotFoundException {     
      ClassLoader classLoader = Thread.currentThread().getContextClassLoader();     

      if(classLoader == null)     
         classLoader = Singleton.class.getClassLoader();     

      return (classLoader.loadClass(classname));     
   }     
}
```

问题2的修复方法：
``` java
public class Singleton implements java.io.Serializable {     
   public static Singleton INSTANCE = new Singleton();     

   protected Singleton() {     

   }     
   private Object readResolve() {     
            return INSTANCE;     
      }    
}
```
