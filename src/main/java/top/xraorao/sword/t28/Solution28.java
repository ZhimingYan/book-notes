/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Solution28.java
 * Date: 18-7-17 下午10:55
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t28;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * 字符串的排列.
 *
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *
 * @author Xiong Raorao
 * @since 2018-07-17-22:55
 */
public class Solution28 {

  public static void main(String[] args) {
    String ss = "abc";
    Solution28 solution28 = new Solution28();
    List<String> res = solution28.Permutation(ss);

    Iterator<String> iterator = res.iterator();
    while (iterator.hasNext()) {
      System.out.print(iterator.next()+" ");
    }

  }

  public ArrayList<String> Permutation(String str) {
    ArrayList<String> res = new ArrayList<>();
    if (str != null && str.length() > 0) {
      PermutationHelper(str.toCharArray(), 0, res);
      //Collections.sort(res);
    }
    return res;
  }

  /**
   * 使用回溯法
   */
  private void PermutationHelper(char[] cs, int i, List<String> list) {
    if (i == cs.length - 1) {
      String val = String.valueOf(cs);
      if (!list.contains(val)) {
        list.add(val);
      }
    } else {
      for (int j = i; j < cs.length; j++) {
        swap(cs, i, j);
        PermutationHelper(cs, i + 1, list);
        swap(cs, i, j);
      }
    }
  }

  private void swap(char[] cs, int i, int j) {
    char temp = cs[i];
    cs[i] = cs[j];
    cs[j] = temp;
  }
}
