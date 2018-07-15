/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: FinallyTest.java
 * Date: 18-7-12 下午5:28
 * Author: Xiong Raorao
 */

package top.xraorao.test;

/**
 * .
 *
 * @author Xiong Raorao
 * @since 2018-07-12-17:28
 */
public class FinallyTest {

  public static void main(String[] args) {
    System.out.println(finalTest());
  }

  public static int finalTest() {

    int x = 1;
    try {
      return x;
    } finally {
      x++;
      return x;
    }
  }

}
