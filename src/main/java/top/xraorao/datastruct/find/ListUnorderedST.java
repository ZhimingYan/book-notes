/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: ListUnorderedST.java
 * Date: 18-7-22 下午3:37
 * Author: Xiong Raorao
 */

package top.xraorao.datastruct.find;

/**
 * 链表实现无序符号表.
 *
 * @author Xiong Raorao
 * @since 2018-07-22-15:37
 */
public class ListUnorderedST<Key, Value> implements UnorderedST<Key, Value> {

  private Node first;
  private int N = 0;

  @Override
  public int size() {
//    int cnt = 0;
//    Node cur = first;
//    while (cur != null) {
//      cnt++;
//      cur = cur.next;
//    }
//    return cnt;
    return N;
  }

  @Override
  public Value get(Key key) {
    Node cur = first;
    while (cur != null) {
      if (cur.key.equals(key)) {
        return cur.value;
      }
      cur = cur.next;
    }
    return null;
  }

  @Override
  public void put(Key key, Value value) {
    Node cur = first;
    // 如果在链表中找到节点的键等于 key 就更新这个节点的值为 value
    while (cur != null) {
      if (cur.key.equals(key)) {
        cur.value = value;
        return;
      }
      cur = cur.next;
    }
    // 否则使用头插法插入一个新节点
    first = new Node(key, value, first);
    N++;
  }

  @Override
  public void delete(Key key) {
    if (first == null) {
      return;
    }
    if (first.key.equals(key)) {
      first = first.next;
    }
    Node pre = first, cur = first.next;
    while (cur != null) {
      if (cur.key.equals(key)) {
        pre.next = cur.next;
        return;
      }
      pre = pre.next;
      cur = cur.next;
    }
  }

  private class Node {

    Key key;
    Value value;
    Node next;

    Node(Key key, Value value, Node next) {
      this.key = key;
      this.value = value;
      this.next = next;
    }
  }
}
