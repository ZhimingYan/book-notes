/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Stack.java
 * Date: 18-3-23 下午11:22
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t5;

/**
 * 实现栈的数据结构.
 *
 * @author Xiong Raorao
 * @since 2018-03-23-23:22
 */
public class Stack<T> {
  private ListNode<T> top = null;
  private int N = 0;

  public boolean isEmpty(){
    return N == 0;
  }

  public int size(){
    return N;
  }

  // 使用链表的头插法实现入栈
  public void push(T data){
    ListNode<T> newTop = new ListNode<>(data);
    newTop.next = top;
    top = newTop;
    N++;
  }

  public T pop(){
    T data = top.data;
    top = top.next;
    N--;
    return data;
  }

}
