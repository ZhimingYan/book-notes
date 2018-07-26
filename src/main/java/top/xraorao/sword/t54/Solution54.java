/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Solution54.java
 * Date: 18-7-26 下午4:01
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t54;

/**
 * 表示数值的字符串.
 *
 * 题目要求：请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 *
 * @author Xiong Raorao
 * @since 2018-07-26-16:00
 */
public class Solution54 {

  private int index = 0;

  public static void main(String[] args) {

  }

  /**
   * 解法一：正则表达式匹配
   */
  public boolean isNumeric(char[] str) {
    String pattern = "[\\+\\-]?\\d*(\\.\\d+)?([eE][\\-\\+]?\\d+)?";
    return String.valueOf(str).matches(pattern);
  }

  /**
   * 解法二：Double解析
   */
  public boolean isNumeric2(char[] str) {
    try {
      double re = Double.parseDouble(String.valueOf(str));
    } catch (NumberFormatException e) {
      return false;
    }
    return true;
  }

  /**
   * 解法三：慢慢判断
   * @param str
   * @return
   */
  public boolean isNumeric3(char[] str) {
    if (str.length < 1) {
      return false;
    }
    boolean flag = scanInteger(str);
    if (index < str.length && str[index] == '.') {
      index++;
      flag = scanUnsignedInteger(str) || flag;
    }

    if (index < str.length && (str[index] == 'E' || str[index] == 'e')) {
      index++;
      flag = flag && scanInteger(str);
    }

    return flag && index == str.length;

  }

  private boolean scanInteger(char[] str) {
    if (index < str.length && (str[index] == '+' || str[index] == '-')) {
      index++;
    }
    return scanUnsignedInteger(str);
  }

  private boolean scanUnsignedInteger(char[] str) {
    int start = index;
    while (index < str.length && str[index] >= '0' && str[index] <= '9') {
      index++;
    }
    return start < index; //是否存在整数
  }
}
