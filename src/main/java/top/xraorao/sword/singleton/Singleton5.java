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

  public  enum SingletonHander {
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
