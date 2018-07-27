/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Solution58.java
 * Date: 18-7-26 下午7:12
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t58;

/**
 * 二叉树的下一个结点 .
 *
 * 题目描述：给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 *
 * @author Xiong Raorao
 * @since 2018-07-26-19:12
 */
public class Solution58 {

  public static void main(String[] args) {

  }

  public TreeLinkNode GetNext(TreeLinkNode pNode) {
    if (pNode == null) {
      return null;
    }
    TreeLinkNode pNext = null;
    if (pNode.right != null) {
      TreeLinkNode right = pNode.right;
      while (right.left != null) {
        right = right.left;
      }
      pNext = right;
    } else if (pNode.next != null) {
      TreeLinkNode pCurrent = pNode;
      TreeLinkNode pParent = pNode.next;
      while (pParent != null && pCurrent == pParent.right) {
        pCurrent = pParent;
        pParent = pParent.next;
      }
      pNext = pParent;
    }
    return pNext;
  }

  static class TreeLinkNode {

    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
      this.val = val;
    }
  }
}
