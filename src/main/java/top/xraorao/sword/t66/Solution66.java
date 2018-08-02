/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Solution66.java
 * Date: 18-7-30 上午10:15
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t66;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * 滑动窗口的最大值.
 *
 * 题目描述： 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}，
 * {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}，
 * {2,3,4,2,6,[2,5,1]}。
 *
 * 思路： 用一个双端队列，队列第一个位置保存当前窗口的最大值，当窗口滑动一次
 *
 * 1.判断当前最大值是否过期
 *
 * 2.新增加的值从队尾开始比较，把所有比他小的值丢掉
 *
 * @author Xiong Raorao
 * @since 2018-07-30-10:15
 */
public class Solution66 {

  public static void main(String[] args) {
    int[] test = {2, 3, 4, 2, 6, 2, 5, 1};
    ArrayList<Integer> res = maxInWindows(test, 3);
    for (Integer i : res) {
      System.out.print(i + " ");
    }
  }

  public static ArrayList<Integer> maxInWindows(int[] num, int size) {
    ArrayDeque<Integer> deque = new ArrayDeque<>();
    ArrayList<Integer> list = new ArrayList<>();
    if (num == null || num.length < size || size == 0) {
      return list;
    }
    int begin;
    for (int i = 0; i < num.length; i++) {
      begin = i - size + 1;
      if (deque.isEmpty()) {
        deque.add(i);
      } else if (begin > deque.peekFirst()) {
        // 判断当前最大值是否过期
        deque.pollFirst();
      }
      // 新增加的值从队尾开始比较，把所有比他小的值丢掉
      while (!deque.isEmpty() && num[deque.peekLast()] <= num[i]) {
        deque.pollLast();
      }
      deque.add(i);
      if (begin >= 0) {
        list.add(num[deque.peekFirst()]);
      }
    }
    return list;
  }
}
