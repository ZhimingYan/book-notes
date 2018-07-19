/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Solution31.java
 * Date: 18-7-19 下午4:55
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t31;

/**
 * 连续子数组的最大和.
 *
 * 问题描述：输入一个整型数组，数组里面有正数和负数。数组中一个或连续的多个正数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为O(n)
 *
 * @author Xiong Raorao
 * @since 2018-07-19-16:54
 */
public class Solution31 {

  public static void main(String[] args) {
    int[] array = new int[] {1, -2, 3, 10, -4, 7, 2, -5};
    System.out.println(FindGreatestSumOfSubArray(array));
    array = new int[] {-2, -8, -1, -5, -9};
    System.out.println(FindGreatestSumOfSubArray(array));
  }

  /**
   * 解法一：数据规律
   */
  public static int FindGreatestSumOfSubArray(int[] array) {
    if (array == null || array.length == 0) {
      return 0;
    }

    int sum = 0;
    int maxValue = 0x80000000; // 最小的负数
    for (int i = 0; i < array.length; i++) {
      if (sum <= 0) {
        sum = array[i];
      } else {
        sum += array[i];
      }
      if (sum > maxValue) {
        maxValue = sum;
      }

    }
    return maxValue;
  }

  /**
   * 解法二：动态规划法
   */
  public static int FindGreatestSumOfSubArray2(int[] array) {
    int res = array[0];
    int max = array[0];
    for (int i = 1; i < array.length; i++) {
      max = Math.max(max + array[i], array[i]);
      res = Math.max(max, res);
    }
    return res;
  }
}
