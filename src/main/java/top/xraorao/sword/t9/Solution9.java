/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Solution9.java
 * Date: 18-4-17 下午7:50
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t9;

import java.util.Arrays;

/**
 * 菲波那切数列.
 *
 * @author Xiong Raorao
 * @since 2018-04-17-19:50
 */
public class Solution9 {

  /**
   * 1.最简单的递归实现
   */
  public int fibonacci(int n) {
    if (n == 0) {
      return 0;
    } else if (n == 1) {
      return 1;
    } else {
      return fibonacci(n - 1) + fibonacci(n - 2);
    }
  }

  /**
   * 2. 使用数组保存中间结果，降低复杂度到O(n)
   */
  public int fibonacci2(int n) {
    if (n == 0) {
      return 0;
    } else if (n == 1) {
      return 1;
    } else {
      int fibonacciOne = 0;
      int fibonacciTwo = 1;
      int fibonacciN = 0;
      for (int i = 1; i < n; i++) {
        fibonacciN = fibonacciOne + fibonacciTwo;
        //fibonacciTwo = fibonacciOne;
        //fibonacciOne = fibonacciN;
        fibonacciOne = fibonacciTwo;
        fibonacciTwo = fibonacciN;
      }
      return fibonacciN;
    }
  }

  /**
   * 跳台阶
   *
   * 描述：一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
   */
  public int jumpFloor(int target) {
    if (target <= 1) {
      return target;
    }

    int pre2 = 0;
    int pre1 = 1;
    int result = 0;
    for (int i = 1; i <= target; i++) {
      result = pre2 + pre1;
      pre2 = pre1;
      pre1 = result;
    }
    return result;
  }

  /**
   * 变态跳台阶
   *
   * 描述： 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
   */
  public int jumpFloor2(int n) {
    int[] dp = new int[n];
    Arrays.fill(dp, 1);
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {
        dp[i] += dp[j];
      }
    }
    return dp[n - 1];
  }
}
