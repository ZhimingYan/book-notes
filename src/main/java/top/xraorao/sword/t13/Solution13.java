/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Solution13.java
 * Date: 18-4-19 下午7:46
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t13;

import top.xraorao.sword.t5.ListNode;

/**
 * 在O(1)时间内删除链表节点.
 *
 * @author Xiong Raorao
 * @since 2018-04-19-19:46
 */
public class Solution13 {

  public static void main(String[] args) {

  }

  public ListNode<Integer> deleteNode(ListNode<Integer> head, ListNode<Integer> targetNode) {
    if (head == null || head.next == null || targetNode == null) {
      return null;
    }
    // 非尾节点,直接将target节点的下一个节点赋值给该节点
    if (targetNode.next != null) {
      ListNode<Integer> next = targetNode.next;
      targetNode.data = next.data;
      targetNode.next = next.next;
    } else {
      // 尾节点
      ListNode<Integer> cur = head;
      while (cur.next != targetNode) {
        cur = cur.next;
      }
      cur.next = null;
    }
    return head;
  }

}
