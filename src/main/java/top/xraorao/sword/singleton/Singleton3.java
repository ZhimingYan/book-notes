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