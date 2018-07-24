/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Solution43.java
 * Date: 18-7-23 下午4:57
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t43;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

/**
 * n个骰子的点数.
 *
 * 描述：把 n 个骰子仍在地上，求点数和为 s 的概率。
 *
 * @author Xiong Raorao
 * @since 2018-07-23-16:57
 */
public class Solution43 {

  public static void main(String[] args) {
    Solution43 solution43 = new Solution43();
    List<Entry<Integer, Double>> list = solution43.dicesSum(2);
    System.out.println(list.size());
  }

  /**
   *
   * 1. 采用递归的方法解答，但是时间复杂度太高，无法通过
   *
   * @param n an integer
   * @return a list of Map.Entry<sum, probability>
   */
  public List<Entry<Integer, Double>> dicesSum(int n) {
    List<Entry<Integer, Double>> list = new ArrayList<>();
    int size = 6 * n - n + 1; // 可能的值的长度
    int[] probabilities = new int[size];
    probability(n, probabilities);
    int total = (int) Math.pow(6, n);
    for (int i = n; i <= 6 * n; i++) {
      double ratio = (double) probabilities[i - n] / total;
      list.add(new SimpleEntry<>(i, ratio));
    }
    return list;
  }

  private void probability(int number, int[] probabilities) {
    for (int i = 1; i <= 6; i++) {
      probability(number, number, i, probabilities);
    }
  }

  /**
   * 递归实现统计点数
   * @param original 骰子的总个数
   * @param current 当前还剩几个骰子
   * @param sum 骰子面值
   * @param probabilities 统计的和的出现次数
   */
  private void probability(int original, int current, int sum, int[] probabilities) {
    if (current == 1) {
      probabilities[sum - original]++;
    } else {
      for (int i = 1; i <= 6; i++) {
        probability(original, current - 1, i + sum, probabilities);
      }
    }
  }
}
