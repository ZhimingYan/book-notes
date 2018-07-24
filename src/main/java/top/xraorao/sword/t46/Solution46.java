/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Solution46.java
 * Date: 18-7-24 下午12:02
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t46;

/**
 * 求1+2+...+n.
 *
 * @author Xiong Raorao
 * @since 2018-07-24-12:02
 */
public class Solution46 {

  public static void main(String[] args) {
  }

  /**
   * 解法一：利用&&的短路原理，玛德，简直是天才
   */
  public static int Sum_Solution(int n) {
    int ans = n;
    boolean hh = (n > 0) && ((ans += Sum_Solution(n - 1)) > 0);
    return ans;
  }
}
