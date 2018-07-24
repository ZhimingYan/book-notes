/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Solution44.java
 * Date: 18-7-23 下午4:58
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t44;

import java.util.Arrays;

/**
 * 扑克牌的顺子.
 *
 * 题目描述：五张牌，其中大小鬼为癞子，牌面大小为 0。判断是否能组成顺子。
 *
 * @author Xiong Raorao
 * @since 2018-07-23-16:57
 */
public class Solution44 {

  public static void main(String[] args) {

  }

  public boolean isContinuous(int[] numbers) {
    if (numbers.length < 5) {
      return false;
    }

    Arrays.sort(numbers);
    int kings = 0;
    for (int i = 0; i < 5; i++) {
      if (numbers[i] == 0) {
        kings++;
      }
    }

    for (int i = kings; i < numbers.length - 1; i++) {
      if (numbers[i + 1] == numbers[i]) {
        return false;
      }
      kings -= numbers[i + 1] - numbers[i] - 1;  /* 使用癞子去补全不连续的顺子 */
    }
    return kings >= 0;
  }
}
