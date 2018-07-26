/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Solution57.java
 * Date: 18-7-26 下午7:11
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t57;


/**
 * 删除链表中重复的结点.
 *
 * 题目描述：在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 *
 * @author Xiong Raorao
 * @since 2018-07-26-19:11
 */
public class Solution57 {

  public static void main(String[] args) {

  }

  public static ListNode deleteDuplication(ListNode pHead) {
    if (pHead == null || pHead.next == null) {
      return pHead;
    }
    if (pHead.val == pHead.next.val) {
      ListNode pNode = pHead.next;
      while (pNode != null && pNode.val == pHead.val) {
        pNode = pNode.next;
      }
      return deleteDuplication(pNode);
    } else {
      pHead.next = deleteDuplication(pHead.next);
      return pHead;
    }
  }

  class ListNode {

    int val;
    ListNode next = null;

    ListNode(int val) {
      this.val = val;
    }
  }

}
