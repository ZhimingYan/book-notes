/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Solution16.java
 * Date: 18-4-21 下午8:06
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t16;

import top.xraorao.sword.t5.ListNode;

/**
 * 反转链表.
 *
 * @author Xiong Raorao
 * @since 2018-04-21-20:05
 */
public class Solution16 {

  public static void main(String[] args) {

  }

  public ListNode<Integer> reverseList(ListNode<Integer> head) {
    if (head == null) {
      return null;
    }
    ListNode<Integer> reverseHead = null;
    ListNode<Integer> currenteNode = head;
    ListNode<Integer> preNode = null;
    while (currenteNode != null) {
      ListNode<Integer> next = currenteNode.next;
      if (next == null) {
        reverseHead = currenteNode;
      }
      currenteNode.next = preNode;
      preNode = currenteNode;
      currenteNode = next;
    }
    return reverseHead;

  }

}
