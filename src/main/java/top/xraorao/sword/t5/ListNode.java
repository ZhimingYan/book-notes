/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Node.java
 * Date: 18-3-23 下午11:11
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t5;

/**
 * 链表节点.
 *
 * @author Xiong Raorao
 * @since 2018-03-23-23:10
 */
public class ListNode<T> {

  public ListNode<T> next = null;
  public T data;

  public ListNode(T data) {
    this.data = data;

  }

}
