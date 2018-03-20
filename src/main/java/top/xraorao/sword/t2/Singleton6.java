/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Singleton6.java
 * Date: 18-3-17 下午7:13
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t2;

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
