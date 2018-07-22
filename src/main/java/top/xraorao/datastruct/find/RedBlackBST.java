/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: RedBlackBST.java
 * Date: 18-7-22 下午4:57
 * Author: Xiong Raorao
 */

package top.xraorao.datastruct.find;

/**
 * 红黑树.
 *
 * 2-3 查找树需要用到 2- 节点和 3- 节点，红黑树使用红链接来实现 3- 节点。
 * 指向一个节点的链接颜色如果为红色，那么这个节点和上层节点表示的是一个 3- 节点，而黑色则是普通链接。
 *
 * 红链接都为左链接； 完美黑色平衡，即任意空链接到根节点的路径上的黑链接数量相同。
 *
 * @author Xiong Raorao
 * @since 2018-07-22-16:57
 */
public class RedBlackBST<Key extends Comparable<Key>, Value> extends BST<Key, Value> {

  private static final boolean RED = true;
  private static final boolean BLACK = false;

  private boolean isRed(Node x) {
    if (x == null) {
      return false;
    }
    return x.color == RED;
  }

  /**
   * 因为合法的红链接都为左链接，如果出现右链接为红链接，那么就需要进行左旋转操作。
   */
  public Node rotateLeft(Node h) {
    Node x = h.right;
    h.right = x.left;
    x.left = h;
    x.color = h.color;
    h.color = RED;
    x.N = h.N;
    recalculateSize(h);
    return x;
  }

  /**
   * 进行右旋转是为了转换两个连续的左红链接，这会在之后的插入过程中探讨。
   */
  public Node rotateRight(Node h) {
    Node x = h.left;
    h.left = x.right;
    x.color = h.color;
    h.color = RED;
    x.N = h.N;
    recalculateSize(h);
    return x;
  }

  /**
   * 颜色转换
   *
   * 一个 4- 节点在红黑树中表现为一个节点的左右子节点都是红色的。 分裂 4- 节点除了需要将子节点的颜色由红变黑之外，同时需要将父节点的颜色由黑变红， 从 2-3
   * 树的角度看就是将中间节点移到上层节点。
   */
  void flipColors(Node h) {
    h.color = RED;
    h.left.color = BLACK;
    h.right.color = BLACK;
  }

  /**
   * 先将一个节点按二叉查找树的方法插入到正确位置，然后再进行如下颜色操作：
   *
   * 如果右子节点是红色的而左子节点是黑色的，进行左旋转；
   *
   * 如果左子节点是红色的，而且左子节点的左子节点也是红色的，进行右旋转；
   *
   * 如果左右子节点均为红色的，进行颜色转换。
   */
  @Override
  public void put(Key key, Value value) {
    root = put(root, key, value);
    root.color = BLACK;
  }

  private Node put(Node x, Key key, Value value) {
    if (x == null) {
      Node node = new Node(key, value, 1);
      node.color = RED;
      return node;
    }
    int cmp = key.compareTo(x.key);
    if (cmp == 0) {
      x.val = value;
    } else if (cmp < 0) {
      x.left = put(x.left, key, value);
    } else {
      x.right = put(x.right, key, value);
    }

    if (isRed(x.right) && !isRed(x.left)) {
      x = rotateLeft(x);
    }
    if (isRed(x.left) && isRed(x.left.left)) {
      x = rotateRight(x);
    }
    if (isRed(x.left) && isRed(x.right)) {
      flipColors(x);
    }

    recalculateSize(x);
    return x;
  }
}
