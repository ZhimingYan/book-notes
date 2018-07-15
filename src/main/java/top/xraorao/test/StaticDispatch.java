/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: StaticDispatch.java
 * Date: 18-7-13 上午8:45
 * Author: Xiong Raorao
 */

package top.xraorao.test;

/**
 * .
 *
 * @author Xiong Raorao
 * @since 2018-07-13-8:45
 */
public class StaticDispatch {

  public static void main(String[] args) {
    Human man = new Man();
    Human woman = new Woman();
    StaticDispatch sr = new StaticDispatch();
    sr.sayHello(man);
    sr.sayHello(woman);

    // 修改静态类型
    sr.sayHello((Man) man);
    sr.sayHello((Woman) woman);
  }

  public void sayHello(Human guy) {
    System.out.println("hello, guy");
  }

  public void sayHello(Man guy) {
    System.out.println("hello, man");
  }

  public void sayHello(Woman guy) {
    System.out.println("hello, woman");
  }

  static abstract class Human {

  }

  static class Man extends Human {

  }

  static class Woman extends Human {

  }

}
