/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Solution.java
 * Date: 18-7-23 下午4:53
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t41;

import java.util.ArrayList;

/**
 * 和为S的两个数字.
 *
 * 描述：输入一个递增排序的数组和一个数字 S，在数组中查找两个数，使得他们的和正好是 S，如果有多对数字的和等于 S，输出两个数的乘积最小的。
 *
 * @author Xiong Raorao
 * @since 2018-07-23-16:52
 */
public class Solution {

  public static void main(String[] args) {
    int[] arr = new int[] {1, 2, 4, 7, 11, 15};
    ArrayList<Integer> list = FindNumbersWithSum(arr, 15);
    System.out.println(list.size());
  }

  public static ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
    ArrayList<Integer> res = new ArrayList<>();
    if (array == null || array.length == 0) {
      return res;
    }
    int left = 0;
    int right = array.length - 1;
    while (left <= right) {
      int total = array[left] + array[right];
      if (total == sum) {
        res.add(array[left]);
        res.add(array[right]);
        return res;
      } else if (total < sum) {
        left++;
      } else {
        right--;
      }
    }
    return res;
  }
}
