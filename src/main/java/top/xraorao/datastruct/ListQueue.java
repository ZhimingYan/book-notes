/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: ListQueue.java
 * Date: 18-7-22 下午3:07
 * Author: Xiong Raorao
 */

package top.xraorao.datastruct;

import java.util.Iterator;

/**
 * 链表实现队列，FIFO.
 *
 * @author Xiong Raorao
 * @since 2018-07-22-15:06
 */
public class ListQueue<Item> implements MyQueue<Item> {

  int N = 0;
  private Node first;
  private Node last;

  @Override
  public boolean isEmpty() {
    return N == 0;
  }

  @Override
  public int size() {
    return N;
  }

  @Override
  public MyQueue<Item> add(Item item) {
    Node newNode = new Node();
    newNode.item = item;
    newNode.next = null;
    if (isEmpty()) {
      last = newNode;
      first = newNode;
    } else {
      last.next = newNode;
      last = newNode;
    }
    N++;
    return this;
  }

  @Override
  public Item remove() throws Exception {
    if (isEmpty()) {
      throw new Exception("queue is empty");
    }
    Node node = first;
    first = first.next;
    N--;
    if (isEmpty()) {
      last = null;
    }
    return node.item;
  }

  @Override
  public Iterator<Item> iterator() {
    return new Iterator<Item>() {
      Node cur = first;

      @Override
      public boolean hasNext() {
        return cur != null;
      }

      @Override
      public Item next() {
        Item item = cur.item;
        cur = cur.next;
        return item;
      }
    };
  }

  private class Node {

    Item item;
    Node next;
  }
}
