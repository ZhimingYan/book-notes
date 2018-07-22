/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: ArrayStack.java
 * Date: 18-7-22 上午11:08
 * Author: Xiong Raorao
 */

package top.xraorao.datastruct;

import java.util.Iterator;
import java.util.Stack;

/**
 * 数组实现栈.
 *
 * @author Xiong Raorao
 * @since 2018-07-22-11:08
 */
public class ArrayStack<Item> implements MyStack<Item> {

  private static final int DEFAULT_SIZE = 5;
  private Item[] items;
  private int N = 0;

  public ArrayStack(Item[] items) {
    this.items = items;
  }

  public ArrayStack() {
    items = (Item[]) new Object[DEFAULT_SIZE];
  }

  private void check() {
    if (N >= items.length) {
      resize(2 * items.length);
    } else if (N > 0 && N <= items.length / 4) {
      resize(items.length / 2);
    }
  }

  private void resize(int size) {
    Item[] temp = (Item[]) new Object[size];
    for (int i = 0; i < N; i++) {
      temp[i] = items[i];
    }
    items = temp;
  }

  @Override
  public MyStack<Item> push(Item item) {
    check();
    items[N++] = item;
    return this;
  }

  @Override
  public Item pop() throws Exception {
    if (isEmpty()) {
      throw new Exception("Stack is null!");
    }
    Item item = items[--N];
    check();
    items[N] = null; //避免对象游离(保存一个不需要的对象的引用)，便于JVM的回收。
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
      private int i = N;

      @Override
      public boolean hasNext() {
        return i > 0;
      }

      @Override
      public Item next() {
        return items[--i];
      }
    };
  }
}
