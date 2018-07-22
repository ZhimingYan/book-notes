/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: ListStack.java
 * Date: 18-7-22 上午11:57
 * Author: Xiong Raorao
 */

package top.xraorao.datastruct;

import java.util.Iterator;

/**
 * 链表实现栈（头插法）.
 *
 * @author Xiong Raorao
 * @since 2018-07-22-11:57
 */
public class ListStack<Item> implements MyStack<Item> {

  private Node top = null;
  private int N = 0;

  @Override
  public MyStack<Item> push(Item item) {
    Node node = new Node(item);
    node.next = top;
    top = node;
    N++;
    return this;
  }

  @Override
  public Item pop() throws Exception {
    if (isEmpty()) {
      throw new Exception("Stack is null!");
    }
    Item item = top.item;
    top = top.next;
    N--;
    return item;
  }

  @Override
  public boolean isEmpty() {
    return N == 0;
  }

  @Override
  public int size() {
    return N;
  }

  @Override
  public Iterator<Item> iterator() {
    return new Iterator<Item>() {
      private Node cur = top;

      @Override
      public boolean hasNext() {
        return cur != null;
      }

      @Override
      public Item next() {
        Item item = (Item) cur.item;
        top = cur.next;
        return item;
      }
    };
  }

  private class Node {

    Item item;
    Node next;

    public Node(Item item) {
      this.item = item;
    }
  }
}
