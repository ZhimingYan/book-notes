/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Solution14.java
 * Date: 18-4-19 下午8:07
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t14;

/**
 * 调整数组顺序使奇数位于偶数前面.
 *
 * @author Xiong Raorao
 * @since 2018-04-19-20:07
 */
public class Solution14 {

  public static void main(String[] args) {
    int[] array = new int[] {1, 2, 3, 4, 5, 6, 7};
    reOrderArray2(array);
    for (int i : array) {
      System.out.print(i + " ");
    }
  }

  /**
   * 该函数能够保证奇数在左边，偶数在右边，但是不能保证相对顺序不变
   */
  public static void reOrderArray(int[] array) {
    if (array == null || array.length == 0) {
      return;
    }
    int leftIndex = 0;
    int rightIndex = array.length - 1;
    while (leftIndex < rightIndex) {
      while (leftIndex < rightIndex && array[leftIndex] % 2 == 1) {
        leftIndex++;
      }
      while (leftIndex <= rightIndex && array[rightIndex] % 2 == 0) {
        rightIndex--;
      }
      if (leftIndex < rightIndex) {
        int temp = array[leftIndex];
        array[leftIndex] = array[rightIndex];
        array[rightIndex] = temp;
      } else {
        return;
      }
    }
  }

  public static void reOrderArray2(int[] array) {
    int n = array.length;
    for (int i = 0; i < n; i++) {
      if (array[i] % 2 == 0) {
        int nextOddIdx = i + 1;
        while (nextOddIdx < n && array[nextOddIdx] % 2 == 0) {
          nextOddIdx++;
        }
        if (nextOddIdx == n) {
          break;
        }
        int nextOddVal = array[nextOddIdx];
        for (int j = nextOddIdx; j > i; j--) {
          array[j] = array[j - 1];
        }
        array[i] = nextOddVal;
      }
    }
  }


}
