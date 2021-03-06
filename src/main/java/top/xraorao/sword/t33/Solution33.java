/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Solution33.java
 * Date: 18-7-20 上午9:12
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t33;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 把数组排成最小的数.
 *
 * 题目：输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 *
 * 基本思路：对两个元素m,n,比较mn和nm的大小即可
 *
 * @author Xiong Raorao
 * @since 2018-07-20-9:12
 */
public class Solution33 {

  public static void main(String[] args) {

  }

  public String PrintMinNumber(int[] numbers) {
    if (numbers == null || numbers.length == 0) {
      return "";
    }
    ArrayList<String> list = new ArrayList<>();
    for (int i = 0; i < numbers.length; i++) {
      list.add(String.valueOf(numbers[i]));
    }
    Collections.sort(list, (o1, o2) -> {
      String s1 = o1 + o2;
      String s2 = o2 + o1;
      return s1.compareTo(s2);
    });

    StringBuilder sb = new StringBuilder();
    for (String s : list) {
      sb.append(s);
    }
    return sb.toString();
  }
}
