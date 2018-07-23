/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Solution37.java
 * Date: 18-7-23 上午10:27
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t37;

import java.util.Stack;

/**
 * 两个链表的第一个公共结点.
 *
 * 题目：输入两个链表，找出它们的第一个公共结点。
 *
 * @author Xiong Raorao
 * @since 2018-07-23-10:26
 */
public class Solution37 {

  public static void main(String[] args) {
    ListNode top1 = new ListNode(1);
    addTail(top1, 2);
    addTail(top1, 3);
    addTail(top1, 6);
    addTail(top1, 7);
    ListNode top2 = new ListNode(4);
    addTail(top2, 5);
    addTail(top2, 6);
    addTail(top2, 7);
    ListNode node = FindFirstCommonNode2(top1, top2);
    System.out.println(node.val);
  }

  /**
   * 解法一：使用栈的数据结构。
   *
   * 分别把两个链表的节点放入两个栈里面，这样两个链表的为节点就位于两个栈的栈顶，接下来比较两个栈顶的元素是否相同， 相同则弹出，依次比较，直到找到不相同的节点
   *
   * 时间复杂度O(m+n)空间复杂度也是O(m+n)
   */
  public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    while (pHead1 != null) {
      s1.push(pHead1.val);
      pHead1 = pHead1.next;
    }
    while (pHead2 != null) {
      s2.push(pHead2.val);
      pHead2 = pHead2.next;
    }

    ListNode res = null;
    while (!s1.isEmpty() && !s2.isEmpty()) {
      int temp = s1.pop();
      int temp2 = s2.pop();
      if (temp == temp2) {
        res = addHead(res, temp);
      } else {
        return res;
      }
    }
    return res;
  }

  /**
   * 解法2: 找出2个链表的长度，然后让长的先走两个链表的长度差，然后再一起走
   */
  public static ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
    ListNode current1 = pHead1;// 链表1
    ListNode current2 = pHead2;// 链表2
    if (pHead1 == null || pHead2 == null) {
      return null;
    }
    int length1 = getLength(current1);
    int length2 = getLength(current2);

    if (length1 >= length2) {
      int len = length1 - length2;
      while (len > 0) {
        current1 = current1.next;
        len--;
      }

    } else if (length1 < length2) {
      int len = length2 - length1;

      while (len > 0) {
        current2 = current2.next;
        len--;
      }
    }
    while (current1 != current2) {
      current1 = current1.next;
      current2 = current2.next;
    }
    return current1;
  }

  private static ListNode addHead(ListNode top, int val) {
    if (top == null) {
      top = new ListNode(val);
      return top;
    }
    ListNode newNode = new ListNode(val);
    newNode.next = top;
    top = newNode;
    return top;
  }

  private static ListNode addTail(ListNode top, int val) {
    if (top == null) {
      top = new ListNode(val);
    }
    ListNode tmp = top;
    ListNode newNode = new ListNode(val);
    while (tmp.next != null) {
      tmp = tmp.next;
    }
    tmp.next = newNode;
    return top;
  }

  private static ListNode walk(ListNode node, int step) {
    ListNode top = node;
    for (int i = 0; i < step; i++) {
      if (top != null) {
        top = top.next;
      }
    }
    return top;
  }

  private static int getLength(ListNode listNode) {
    int count = 0;
    ListNode top = listNode;
    while (top != null) {
      count++;
      top = top.next;
    }
    return count;
  }

  private static class ListNode {

    int val;
    ListNode next = null;

    ListNode(int val) {
      this.val = val;
    }
  }

}
