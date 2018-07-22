/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: MyStack.java
 * Date: 18-7-22 上午11:04
 * Author: Xiong Raorao
 */

package top.xraorao.datastruct;


/**
 * 栈的实现.
 *
 * @author Xiong Raorao
 * @since 2018-07-22-11:04
 */
public interface MyStack<Item> extends Iterable<Item> {
  MyStack<Item> push(Item item);

  Item pop() throws Exception;

  boolean isEmpty();

  int size();
}
