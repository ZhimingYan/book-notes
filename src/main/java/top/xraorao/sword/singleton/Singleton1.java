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
