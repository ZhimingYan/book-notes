/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Solution47.java
 * Date: 18-7-24 下午12:03
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t47;

/**
 * 不用加减乘除做加法.
 *
 * @author Xiong Raorao
 * @since 2018-07-24-12:03
 */
public class Solution47 {

  public static void main(String[] args) {
    int a = 5;
    int b = 9;
    System.out.println(Add(a,b));
  }

  public static int Add(int num1, int num2) {
    int sum, carry;
    do {
      sum = num1 ^ num2;
      carry = (num1 & num2) << 1;
      num1 = sum;
      num2 = carry;
    } while (num2 != 0);
    return num1;
  }
}
