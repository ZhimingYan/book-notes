/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Solution56.java
 * Date: 18-7-26 下午5:40
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t56;

import java.util.HashMap;

/**
 * 链表中环的入口结点.
 *
 * 题目描述：给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 *
 * @author Xiong Raorao
 * @since 2018-07-26-17:40
 */
public class Solution56 {

  public static void main(String[] args) {

  }

  /**
   * 解法一：使用两个指针，一个快指针，一个慢指针，如果链表存在环的话，快指针肯定会
   */
  public ListNode EntryNodeOfLoop(ListNode pHead) {
    ListNode loopNode = getLoopNode(pHead);
    if (loopNode == null) {
      return null;
    }
    // 计算环的节点数量
    int loopCount = 1;
    ListNode loopNode1 = loopNode;
    while (loopNode1.next != loopNode) {
      loopNode1 = loopNode1.next;
      loopCount++;
    }

    // 使用两个前后指针，相距loopCount，第二个指针达到的位置就是环的入口
    ListNode forward = pHead;
    ListNode behind = pHead;
    for (int i = 0; i < loopCount; i++) {
      forward = forward.next;
    }
    while (forward != behind) {
      forward = forward.next;
      behind = behind.next;
    }
    return behind;
  }

  /**
   * 得到链表环中的任意一个节点
   */
  private ListNode getLoopNode(ListNode pHead) {
    ListNode head = pHead;
    if (pHead == null) {
      return null;
    }
    ListNode slow = head.next;
    if (slow == null) {
      return null;
    }
    ListNode fast = slow.next;
    while (fast != null && slow != null) {
      if (fast == slow) {
        return fast;
      }
      slow = slow.next;
      fast = fast.next;
      if (fast != null) {
        fast = fast.next;
      }
    }
    return null;
  }

  /**
   * 解法二：存储Node的地址
   */
  public ListNode EntryNodeOfLoop2(ListNode pHead) {
    HashMap<ListNode, Integer> map = new HashMap<>();
    if (pHead == null || pHead.next == null) {
      return null;
    }
    ListNode node = pHead;
    while (node != null) {
      if (map.containsKey(node)) {
        return node;
      } else {
        map.put(node, 1);
      }
      node = node.next;
    }
    return null;
  }


  static class ListNode {

    int val;
    ListNode next = null;

    ListNode(int val) {
      this.val = val;
    }
  }
}
