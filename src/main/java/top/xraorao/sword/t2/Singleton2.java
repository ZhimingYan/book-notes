/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Singleton2.java
 * Date: 18-3-17 下午7:08
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t2;

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
