/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Solution51.java
 * Date: 18-7-24 下午4:21
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t51;

import java.util.HashSet;

/**
 * 数组中重复的数字.
 *
 * 题目描述：在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。
 *
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 *
 * @author Xiong Raorao
 * @since 2018-07-24-16:21
 */
public class Solution51 {

  public static void main(String[] args) {

  }

  // Parameters:
  //    numbers:     an array of integers
  //    length:      the length of array numbers
  //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
  //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
  //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
  // Return value:       true if the input is valid, and there are some duplications in the array number
  //                     otherwise false
  public boolean duplicate(int numbers[], int length, int[] duplication) {
    if (numbers == null || numbers.length == 0) {
      duplication[0] = -1;
      return false;
    }
    HashSet<Integer> set = new HashSet<>();
    for (int i = 0; i < numbers.length; i++) {
      if (set.contains(numbers[i])) {
        duplication[0] = numbers[i];
        return true;
      } else {
        set.add(numbers[i]);
      }
    }
    duplication[0] = -1;
    return false;
  }
}