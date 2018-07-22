/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: UnorderedST.java
 * Date: 18-7-22 下午3:35
 * Author: Xiong Raorao
 */

package top.xraorao.datastruct.find;

/**
 * 无需符号表.
 *
 * @author Xiong Raorao
 * @since 2018-07-22-15:34
 */
public interface UnorderedST<Key, Value> {

  int size();

  Value get(Key key);

  void put(Key key, Value value);

  void delete(Key key);
}
