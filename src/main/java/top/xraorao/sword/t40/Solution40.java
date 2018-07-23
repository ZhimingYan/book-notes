/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Solution40.java
 * Date: 18-7-23 下午4:02
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t40;

import top.xraorao.sword.t39.Solution;

/**
 * 数组中只出现一次的数字.
 *
 * 题目描述：一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。请写程序找出这两个只出现一次的数字。
 *
 * 思路：从头到尾，依次异或数组元素，偶数的元素会在两次异或中抵消。
 *
 * @author Xiong Raorao
 * @since 2018-07-23-16:02
 */
public class Solution40 {

  public static void main(String[] args) {
    Solution40 solution = new Solution40();
    boolean bool =  solution.isBit1(4,2);
    System.out.println(bool);
  }

  public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
    if (array == null || array.length < 2) {
      return;
    }
    int temp = 0;
    for (int i = 0; i < array.length; i++) {
      temp ^= array[i];
    }

    int indexOf1 = findFirstBitIs1(temp);
    for (int i = 0; i < array.length; i++) {
      if (isBit1(array[i], indexOf1)) {
        num1[0] ^= array[i];
      } else {
        num2[0] ^= array[i];
      }
    }
  }

  /**
   * 在整数num的二进制表示中找到最右边是1的位。
   * @param num
   * @return
   */
  public int findFirstBitIs1(int num) {
    int indexBit = 0;
    while (((num & 1) == 0) && (indexBit) < 8 * 4) {
      num = num >> 1;
      indexBit++;
    }
    return indexBit;
  }

  /**
   * 判断num的二进制中从右边数起的indexBit位是不是1
   * @param num
   * @param indexBit
   * @return
   */
  public boolean isBit1(int num, int indexBit) {
    num = num >> indexBit;
    return (num & 1) == 1;
  }

}
