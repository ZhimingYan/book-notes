/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Solution42.java
 * Date: 18-7-23 下午4:55
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t42;

/**
 * 左旋转字符串.
 *
 * 描述：对于一个给定的字符序列 S，请你把其循环左移 K 位后的序列输出。例如，字符序列 S=”abcXYZdef”, 要求输出循环左移 3 位后的结果，即“XYZdefabc”。
 *
 * @author Xiong Raorao
 * @since 2018-07-23-16:55
 */
public class Solution42 {

  public static void main(String[] args) {
    String ss = "abcdefg";
    System.out.println(LeftRotateString(ss, 3));
  }

  public static String LeftRotateString(String str, int n) {
    if (n < 0 || n > str.length()) {
      return "";
    }
    String left = str.substring(0, n);
    String right = str.substring(n, str.length());
    return right + left;
  }


}
