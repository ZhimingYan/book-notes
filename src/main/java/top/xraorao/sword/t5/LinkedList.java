/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: LinkedList.java
 * Date: 18-3-24 上午12:28
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t5;

import java.util.ArrayList;
import java.util.List;

/**
 * 链表结构-无头结点的实现.
 *
 * @author Xiong Raorao
 * @since 2018-03-24-0:28
 */
public class LinkedList<T> {

  private ListNode<T> head = null;
  private int N = 0;

  public ListNode<T> getHead() {
    return head;
  }

  public List<T> getAll(){
    List<T> list = new ArrayList<>();
    ListNode<T> start = head;
    while(start != null){
      list.add(start.data);
      start = start.next;
    }
    return list;
  }

  // 尾插法
  public void addTail(T data) {
    ListNode<T> newNode = new ListNode<>(data);
    // 第一个元素
    if (head == null) {
      head = newNode;
      N++;
      return;
    }
    ListNode<T> tmp = head;
    while (tmp.next != null) {
      tmp = tmp.next;
    }
    tmp.next = newNode;
    N++;
  }

  // 头插法
  public void addHead(T data) {
    ListNode<T> newNode = new ListNode<>(data);
    // 第一个元素
    if (head == null) {
      head = newNode;
      N++;
      return;
    }
    newNode.next = head;
    head = newNode;
    N++;
  }

  public int length() {
    return N;
  }

  public boolean delete(int index) {
    if (index < 1 || index > length()) {
      return false;
    }
    if (index == 1) {
      head = head.next;
      return true;
    }
    int i = 1;
    ListNode<T> preNode = head;
    ListNode<T> curNode = preNode.next;
    while (curNode != null) {
      if (i == index) {
        preNode.next = curNode.next;
        return true;
      }
      preNode = curNode;
      curNode = curNode.next;
      i++;
    }
    return false;
  }


}
