/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Solution11.java
 * Date: 18-4-18 上午8:38
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t11;

/**
 * 描述：求数值的整数次方.
 *
 * @author Xiong Raorao
 * @since 2018-04-18-8:38
 */
public class Solution11 {

  public static void main(String[] args) {

  }

  /**
   * 一般解法.
   *
   * @param base 底数
   * @param exponent 指数
   */
  public double power(double base, int exponent) {
    double result = 1.0;
    if (base == 0.0 && exponent == 0) {
      return 0.0;
    }
    if (exponent == 0) {
      return 1.0;
    }
    if (exponent < 0) {
      exponent = 0 - exponent;
      for (int i = 0; i < exponent; i++) {
        result *= base;
      }
      return 1.0 / result;
    } else {
      for (int i = 0; i < exponent; i++) {
        result *= base;
      }
      return result;
    }
  }

  public double power2(double base, int exponent) {
    if (exponent == 0) {
      return 1;
    }
    if (exponent == 1) {
      return base;
    }
    double result = power2(base, exponent >> 1);
    result *= result;
    if ((exponent & 0x1) == 1) {
      // 表示奇数
      result *= base;
    }
    return result;
  }


}
