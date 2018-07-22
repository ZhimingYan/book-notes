/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: BinarySearchOrderedST.java
 * Date: 18-7-22 下午3:50
 * Author: Xiong Raorao
 */

package top.xraorao.datastruct.find;

import java.util.ArrayList;
import java.util.List;

/**
 * 二分查找实现有序符号表.
 *
 * 使用一对平行数组，一个存储键一个存储值。
 *
 * @author Xiong Raorao
 * @since 2018-07-22-15:50
 */
public class BinarySearchOrderedST<Key extends Comparable<Key>, Value> implements
    OrderedST<Key, Value> {

  private Key[] keys;
  private Value[] values;
  private int N = 0;

  public BinarySearchOrderedST(int capacity) {
    keys = (Key[]) new Comparable[capacity];
    values = (Value[]) new Object[capacity];
  }

  @Override
  public int size() {
    return N;
  }

  @Override
  public void put(Key key, Value value) {
    int index = rank(key);
    // 如果找到已经存在的节点键为 key，就更新这个节点的值为 value
    if (index < N && keys[index].compareTo(key) == 0) {
      values[index] = value;
      return;
    }
    // 否则在数组中插入新的节点，需要先将插入位置之后的元素都向后移动一个位置
    for (int j = N; j > index; j--) {
      keys[j] = keys[j - 1];
      values[j] = values[j - 1];
    }
    keys[index] = key;
    values[index] = value;
    N++;
  }

  @Override
  public Value get(Key key) {
    int index = rank(key);
    if (index < N && keys[index].compareTo(key) == 0)
      return values[index];
    return null;
  }

  @Override
  public Key min() {
    return keys[0];
  }

  @Override
  public Key max() {
    return keys[N - 1];
  }

  /**
   * 二分查找获取中间的位置
   */
  @Override
  public int rank(Key key) {
    int l = 0, h = N - 1;
    while (l <= h) {
      int m = l + (h - l) / 2;
      int cmp = key.compareTo(keys[m]);
      if (cmp == 0) {
        return m;
      } else if (cmp < 0) {
        h = m - 1;
      } else {
        l = m + 1;
      }
    }
    return l;
  }

  @Override
  public List<Key> keys(Key l, Key h) {
    int index = rank(l);
    List<Key> list = new ArrayList<>();
    while (keys[index].compareTo(h) <= 0) {
      list.add(keys[index]);
      index++;
    }
    return list;
  }
}
