/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: LockTest.java
 * Date: 18-7-16 下午10:35
 * Author: Xiong Raorao
 */

package top.xraorao.test;

import java.util.Date;

/**
 * 死锁.
 *
 * @author Xiong Raorao
 * @since 2018-07-16-22:35
 */
public class LockTest {
  public static String obj1 = "obj1";
  public static String obj2 = "obj2";
  public static void main(String[] args) {
    LockA la = new LockA();
    new Thread(la).start();
    LockB lb = new LockB();
    new Thread(lb).start();
  }

  static class LockA implements Runnable{
    public void run() {
      try {
        System.out.println(new Date().toString() + "LockA 开始执行");
        while(true){
          synchronized (LockTest.obj1) {
            System.out.println(new Date().toString() + " LockA 锁住 obj1");
            Thread.sleep(3000); // 此处等待是给B能锁住机会
            synchronized (LockTest.obj2) {
              System.out.println(new Date().toString() + " LockA 锁住 obj2");
              Thread.sleep(60 * 1000); // 为测试，占用了就不放
            }
          }
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
  static class LockB implements Runnable{
    public void run() {
      try {
        System.out.println(new Date().toString() + " LockB 开始执行");
        while(true){
          synchronized (LockTest.obj2) {
            System.out.println(new Date().toString() + " LockB 锁住 obj2");
            Thread.sleep(3000); // 此处等待是给A能锁住机会
            synchronized (LockTest.obj1) {
              System.out.println(new Date().toString() + " LockB 锁住 obj1");
              Thread.sleep(60 * 1000); // 为测试，占用了就不放
            }
          }
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

}