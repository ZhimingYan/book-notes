/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Solution45.java
 * Date: 18-7-23 下午4:58
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t45;


import java.util.LinkedList;

/**
 * 圆圈中最后剩下的数字（约瑟夫环）.
 *
 * 题目描述: 让小朋友们围成一个大圈。然后，他随机指定一个数 m，让编号为 0 的小朋友开始报数。 每次喊到 m-1 的那个小朋友要出列唱首歌，然后可以在礼品箱中任意的挑选礼物，并且不再回到圈中，
 * 从他的下一个小朋友开始，继续 0...m-1 报数 .... 这样下去 .... 直到剩下最后一个小朋友，可以不用表演。
 *
 * @author Xiong Raorao
 * @since 2018-07-23-16:58
 */
public class Solution45 {

  public static void main(String[] args) {

  }

  /**
   * 解法一：链表模拟游戏
   */
  public int LastRemaining_Solution(int n, int m) {
    LinkedList<Integer> list = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      list.add(i);
    }
    int bt = 0;
    while (list.size() > 1) {
      bt = (bt + m - 1) % list.size();
      list.remove(bt);
    }
    return list.size() == 1 ? list.get(0) : -1;
  }

  /**
   * 解法二：数学归纳法
   */
  public int LastRemaining_Solution2(int n, int m) {
    if (n < 1 || m < 1) {
      return -1;
    }
    if (n == 1) {
      return 0;
    } else {
      return (LastRemaining_Solution(n - 1, m) + m) % n;
    }
  }
}
