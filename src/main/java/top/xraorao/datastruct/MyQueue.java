/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: MyQueue.java
 * Date: 18-7-22 下午3:05
 * Author: Xiong Raorao
 */

package top.xraorao.datastruct;

/**
 * 队列.
 *
 * @author Xiong Raorao
 * @since 2018-07-22-15:05
 */
public interface MyQueue<Item> extends Iterable<Item> {

  int size();

  boolean isEmpty();

  MyQueue<Item> add(Item item);

  Item remove() throws Exception;
}
