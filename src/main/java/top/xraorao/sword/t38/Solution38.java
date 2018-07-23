/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Solution38.java
 * Date: 18-7-23 下午2:29
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t38;

/**
 * 数字在排序数组中出现的次数.
 *
 * 题目要求：统计一个数字在排序数组中出现的次数。
 *
 * @author Xiong Raorao
 * @since 2018-07-23-14:29
 */
public class Solution38 {

  public static void main(String[] args) {
    int[] arr = new int[] {1, 2, 3, 3, 3, 3, 5};
    System.out.println(GetNumberOfK2(arr, 3));
  }

  /**
   * 解法一：找到相同的K，然后分别找到最左边的和最右边的index，相减得到值
   */
  public static int GetNumberOfK(int[] array, int k) {
    return findIndex(array, k, 0, array.length - 1);
  }

  /**
   * 解法二：题目要求是整数序列，因此采用浮点数也是可以完成目的，条条大路通罗马
   */
  public static int GetNumberOfK2(int[] array, int k) {
    return biSearch(array, k + 0.5) - biSearch(array, k - 0.5);
  }

  public static int biSearch(int[] array, double num) {
    int low = 0;
    int high = array.length - 1;
    while (low <= high) {
      int mid = (low + high) >> 1;
      if (num < array[mid]) {
        high = mid - 1;
      } else if (num > array[mid]) {
        low = mid + 1;
      }
    }
    return low;
  }

  public static int findIndex(int[] array, int key, int low, int high) {
    int mid = (low + high) >> 1;
    if (array == null || array.length == 0) {
      return 0;
    }
    if (low == high) {
      if (key == array[mid]) {
        return 1;
      }
      return 0;
    }
    if (key == array[mid]) {
      int leftKeyIndex = mid - 1;
      int rightKeyIndex = mid + 1;
      while (leftKeyIndex >= 0 && array[leftKeyIndex] == array[mid]) {
        leftKeyIndex--;
      }
      while (rightKeyIndex <= array.length - 1 && array[rightKeyIndex] == array[mid]) {
        rightKeyIndex++;
      }
      return rightKeyIndex - leftKeyIndex - 1;
    } else if (key < array[mid]) {
      return findIndex(array, key, low, mid - 1);
    } else {
      return findIndex(array, key, mid + 1, high);
    }
  }
}
