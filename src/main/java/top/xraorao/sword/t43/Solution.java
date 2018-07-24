/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Solution.java
 * Date: 18-7-24 上午10:55
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t43;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

/**
 * n个骰子的点数--基于循环实现.
 *
 * @author Xiong Raorao
 * @since 2018-07-24-10:54
 */
public class Solution {

  public static void main(String[] args) {

  }

  /**
   * 2. 采用循环求骰子的点数
   *
   * @param n an integer
   * @return a list of Map.Entry<sum, probability>
   */
  public List<Entry<Integer, Double>> dicesSum(int n) {
    List<Entry<Integer, Double>> list = new ArrayList<>();

    if (n < 1) {
      return list;
    }
    int[][] probabilities = new int[2][6 * n + 1];
    int flag = 0;
    for (int i = 1; i <= 6; i++) {
      probabilities[flag][i] = 1;
    }
    for (int k = 2; k <= n; k++) {
      for (int i = 0; i < k; i++) {
        probabilities[1 - flag][i] = 0;
      }
      for (int i = k; i <= 6 * k; i++) {
        probabilities[1 - flag][i] = 0;
        for (int j = 1; j <= i && j <= 6; i++) {
          probabilities[1 - flag][i] += probabilities[flag][i - j];
        }
      }
      flag = 1 - flag;
    }
    int total = (int) Math.pow(6, n);
    for (int i = n; i <= 6 * n; i++) {
      double ratio = (double) probabilities[flag][i] / total;
      list.add(new SimpleEntry<>(i, ratio));
    }
    return list;
  }


}
