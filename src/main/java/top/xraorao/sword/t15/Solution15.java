/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Solution15.java
 * Date: 18-4-20 上午8:04
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t15;

import top.xraorao.sword.t5.LinkedList;
import top.xraorao.sword.t5.ListNode;

/**
 * 链表中倒数第K个节点.
 *
 * @author Xiong Raorao
 * @since 2018-04-20-8:04
 */
public class Solution15 {

  public static void main(String[] args) {
    LinkedList<Integer> list = new LinkedList<>();
    list.addTail(1);
    list.addTail(2);
    list.addTail(3);
    list.addTail(4);
    list.addTail(5);
    ListNode<Integer> listHead = list.getHead();

    ListNode<Integer> result = findKthToTail2(listHead, 2);
    System.out.println(result.data);
  }

  /**
   * 方法1. 两次遍历
   */
  public static ListNode<Integer> findKthToTail(ListNode<Integer> head, int k) {
    if (head == null) {
      return null;
    }
    // 第一次遍历得到链表长度
    int length = 0;
    ListNode<Integer> origin = head;//此处是值传递
    while (head != null) {
      length++;
      head = head.next;
    }
    System.out.println("length: " + length);
    if (k > length) {
      return null;
    }
    for (int i = 1; i < length - k + 1; i++) {
      origin = origin.next;
    }
    return origin;
  }

  /**
   * 方法2. 双指针，一次遍历，保证指针间隔为k-1
   */
  public static ListNode<Integer> findKthToTail2(ListNode<Integer> head, int k) {
    if (head == null) {
      return null;
    }
    ListNode<Integer> p1 = head;
    ListNode<Integer> p2 = head;
    while (p1 != null && k-- > 0) {
      p1 = p1.next;
    }
    // k 大于链表长度的情况
    if (k > 0) {
      return null;
    }
    while (p1 != null) {
      p1 = p1.next;
      p2 = p2.next;
    }
    return p2;
  }
}
