/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Solution.java
 * Date: 18-7-23 下午4:56
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t42;


/**
 * 翻转单词顺序列.
 *
 * @author Xiong Raorao
 * @since 2018-07-23-16:55
 */
public class Solution {

  public static void main(String[] args) {
    String s = " ";
    System.out.println(ReverseSentence(s));
  }

  public static String ReverseSentence(String str) {
    if (str.trim().equals("")) {
      return str;
    }
    String[] ss = str.split(" ");
    StringBuilder sb = new StringBuilder();
    for (int i = ss.length - 1; i >= 0; i--) {
      sb.append(ss[i]);
      if (i > 0) {
        sb.append(" ");
      }
    }
    return sb.toString();
  }

}
