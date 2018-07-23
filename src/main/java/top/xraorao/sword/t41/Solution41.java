/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Solution41.java
 * Date: 18-7-23 下午4:51
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t41;

import java.util.ArrayList;

/**
 * 和为S的连续正数序列.
 *
 * 描述：输出所有和为 S 的连续正数序列。
 *
 * 例如和为 100 的连续序列有： [9, 10, 11, 12, 13, 14, 15, 16] [18, 19, 20, 21, 22]。
 *
 * 思路：定义两个指针，small, big,初始化为1和2。首先移动big，直到small和big之间的和等于给定数字，如果大于给定数字，增加small，
 * 直到small到big的和等于给定数字，这是一个结果。
 *
 * @author Xiong Raorao
 * @since 2018-07-23-16:51
 */
public class Solution41 {

  public static void main(String[] args) {
    ArrayList<ArrayList<Integer>> res = FindContinuousSequence(10);
    System.out.println(res.size());
  }

  public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
    ArrayList<ArrayList<Integer>> resultLists = new ArrayList<>();
    int small = 1;
    int big = 2;
    int mid = (1 + sum) / 2;
    int curSum = small + big;
    while (small < mid) {
      if (curSum == sum) {
        ArrayList<Integer> temp = getList(small, big + 1);
        resultLists.add(temp);
      }
      while (curSum > sum && small < mid) {
        curSum -= small++;
        if (curSum == sum) {
          ArrayList<Integer> temp = getList(small, big + 1);
          resultLists.add(temp);
        }
      }
      curSum += ++big;
    }
    return resultLists;
  }

  private static ArrayList<Integer> getList(int i, int j) {
    ArrayList<Integer> res = new ArrayList<>();
    for (int index = i; index < j; index++) {
      res.add(index);
    }
    return res;
  }

}
