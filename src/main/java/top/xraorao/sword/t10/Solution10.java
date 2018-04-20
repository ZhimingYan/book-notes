/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Solution10.java
 * Date: 18-4-17 下午8:12
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t10;

/**
 * 二进制中1的个数.
 *
 * @author Xiong Raorao
 * @since 2018-04-17-20:12
 */
public class Solution10 {

  public static void main(String[] args) {

  }

  /**
   * 1. 使用1作为游标，依次让1从右到左滑动，与输入整数每一位进行"与操作"
   */
  public int numberOfOne1(int n) {
    int count = 0;
    int flag = 1;
    while (flag != 0) {
      if ((n & flag) != 0) {
        count++;
      }
      flag = flag << 1;
    }
    return count;
  }

  /**
   * 2. 把一个整数减去1，再和原来的整数做与运算，会把该整数最右边的一个1变成0
   */
  public int numberOfOne2(int n) {
    int count = 0;
    while (n != 0) {
      if (n != 0) {
        count++;
        n = (n - 1) & n;
      }
    }
    return count;
  }

}
