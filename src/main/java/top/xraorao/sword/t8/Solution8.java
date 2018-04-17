/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Solution8.java
 * Date: 18-4-17 上午8:20
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t8;

/**
 * 旋转数组的最小数字.
 *
 * @author Xiong Raorao
 * @since 2018-04-17-8:20
 */
public class Solution8 {

  public static void main(String[] args) {
    int[] test = new int[] {3, 4, 5, 1, 2};
    Solution8 solution = new Solution8();
    System.out.println(solution.minNumberInRotateArray(test));
  }

  public int minNumberInRotateArray(int[] array) {
    if (array == null || array.length == 0) {
      return 0;
    } else {
      int leftIndex = 0;
      int rightIndex = array.length - 1;
      int midIndex = leftIndex;
      while (array[leftIndex] >= array[rightIndex]) {
        if (rightIndex - leftIndex == 1) {
          midIndex = rightIndex;// 终止条件，左右两个指针相邻
          break;
        }
        midIndex = (leftIndex + rightIndex) / 2;
        if (array[midIndex] >= array[leftIndex]) {
          leftIndex = midIndex;
        } else if (array[midIndex] <= array[rightIndex]) {
          rightIndex = midIndex;
        }
      }
      return array[rightIndex];
    }

  }

}
