/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Singleton4.java
 * Date: 18-3-17 下午7:12
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t2;

/**
 * 4. 静态内部类.
 *
 * <p>实现了延迟加载功能，利用class loader 的机制同时避免了多线程问题</p>
 *
 * @author Xiong Raorao
 * @since 2018-03-17-19:11
 */
public class Singleton4 {

  private Singleton4() {
  }

  public static Singleton4 getInstance() {
    return SingletonHolder.INSTANCE;
  }

  private static class SingletonHolder {

    private static Singleton4 INSTANCE = new Singleton4();
  }

}
