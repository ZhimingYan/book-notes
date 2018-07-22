/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: OrderedST.java
 * Date: 18-7-22 下午3:35
 * Author: Xiong Raorao
 */

package top.xraorao.datastruct.find;

import java.util.List;

/**
 * 有序符号表.
 *
 * @author Xiong Raorao
 * @since 2018-07-22-15:35
 */
public interface OrderedST<Key extends Comparable<Key>, Value> {

  int size();

  void put(Key key, Value value);

  Value get(Key key);

  Key min();

  Key max();

  int rank(Key key);

  List<Key> keys(Key l, Key h);
}
