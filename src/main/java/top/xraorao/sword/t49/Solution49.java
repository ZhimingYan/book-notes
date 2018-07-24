/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Solution49.java
 * Date: 18-7-24 下午3:30
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t49;

/**
 * 把字符串换成整数.
 *
 * 题目描述：将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为 0 或者字符串不是一个合法的数值则返回 0。
 *
 * @author Xiong Raorao
 * @since 2018-07-24-15:30
 */
public class Solution49 {

  public static void main(String[] args) {
    String ss = "-2147483648";
    System.out.println(StrToInt(ss));
  }

  public static int StrToInt(String str) {
    if (str == null || str.equals("")) {
      return 0;
    }
    char[] chars = str.toCharArray();
    int res = 0;
    boolean isPositive = true;
    for (int i = 0; i < chars.length; i++) {
      if (chars[i] < 48 || chars[i] > 57) {
        if (chars[0] == '-') {
          isPositive = false;
        } else if (chars[0] == '+') {
          isPositive = true;
        } else {
          return 0;
        }
      } else {
        if (isPositive) {
          res += (chars[i] - 48) * Math.pow(10, (chars.length - 1 - i));
        } else {
          res += -(chars[i] - 48) * Math.pow(10, (chars.length - 1 - i));
        }
      }
    }
    return res;
  }
}
