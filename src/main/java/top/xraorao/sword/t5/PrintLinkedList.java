/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: PrintLinkedList.java
 * Date: 18-3-23 下午11:04
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t5;

import java.util.ArrayList;

/**
 * t5-打印链表.
 *
 * @author Xiong Raorao
 * @since 2018-03-23-23:04
 */
public class PrintLinkedList {

  /**
   * 使用递归实现
   */
  public static ArrayList<Integer> printList(ListNode<Integer> list) {
    ArrayList<Integer> ret = new ArrayList<>();
    if (list != null) {
      ret.addAll(printList2(list.next));
      ret.add(list.data);
    }
    return ret;
  }

  /**
   * 使用栈实现
   */
  public static ArrayList<Integer> printList2(ListNode<Integer> list) {
    Stack<ListNode<Integer>> stack = new Stack<>();
    ListNode<Integer> listNode = list;
    ArrayList<Integer> resultList = new ArrayList<>();
    // 链表节点入栈
    while (listNode != null) {
      stack.push(listNode);
      listNode = listNode.next;
    }
    // 链表节点出栈
    while (!stack.isEmpty()) {
      listNode = stack.pop();
      resultList.add(listNode.data);
    }
    return resultList;
  }

  /**
   * 使用链表的头插法实现
   */
  public static ArrayList<Integer> printList3(ListNode<Integer> list) {
    ArrayList<Integer> ret = new ArrayList<>();
    // 先用头插法把链表逆序
    ListNode<Integer> head = list;
    LinkedList<Integer> linkedList = new LinkedList<>();
    while (head != null) {
      linkedList.addHead(head.data);
      head = head.next;
    }

    head = linkedList.getHead();
    while (head != null) {
      ret.add(head.data);
      head = head.next;
    }
    return ret;
  }
}
