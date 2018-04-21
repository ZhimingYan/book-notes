/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Solution17.java
 * Date: 18-4-21 下午8:54
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t17;

import top.xraorao.sword.t5.ListNode;

/**
 * 合并两个排序的链表.
 *
 * @author Xiong Raorao
 * @since 2018-04-21-20:54
 */
public class Solution17 {

  public static void main(String[] args) {

  }

  /**
   * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则.
   */
  public ListNode<Integer> merge(ListNode<Integer> list1, ListNode<Integer> list2) {
    if (list1 == null) {
      return list2;
    }
    if (list2 == null) {
      return list1;
    }
    if (list1.data <= list2.data) {
      list1.next = merge(list1.next, list2);
      return list1;
    } else {
      list2.next = merge(list1, list2.next);
      return list2;
    }

  }

}
