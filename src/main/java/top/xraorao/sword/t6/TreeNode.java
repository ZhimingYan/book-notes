/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: TreeNode.java
 * Date: 18-3-26 下午9:48
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t6;

import java.util.HashMap;
import java.util.Map;

/**
 * 二叉树节点.
 *
 * @author Xiong Raorao
 * @since 2018-03-26-21:48
 */
public class TreeNode {

  private static Map<Integer, Integer> inOrderIndexMap = new HashMap<>();
  public int val;
  public TreeNode left;
  public TreeNode right;

  public TreeNode(int x) {
    val = x;
  }

  /**
   * 重建二叉树.
   *
   * @param preOrder 先序遍历
   * @param inOrder 中序遍历
   */
  public static TreeNode reconstruct(int[] preOrder, int[] inOrder) {
    if (preOrder == null || inOrder == null || preOrder.length == 0 || inOrder.length == 0
        || preOrder.length != inOrder.length) {
      return null;
    } else {
      // 存储中序遍历的数组值到index的map
      for (int i = 0; i < inOrder.length; i++) {
        inOrderIndexMap.put(inOrder[i], i);
      }
      return reconstruct(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
    }
  }

  private static TreeNode reconstruct(int[] preOrder, int preLeftIndex, int preRightIndex,
      int[] inOrder, int inLeftIndex, int inRightIndex) {
    if (preLeftIndex == preRightIndex) {
      return new TreeNode(preLeftIndex); // 单节点的树,递归终止条件
    }
    if (preLeftIndex > preRightIndex || inLeftIndex > inRightIndex) {
      return null;
    }
    TreeNode root = new TreeNode(preOrder[preLeftIndex]);//前序遍历的第一个节点的位置是根节点
    int rootIndex = inOrderIndexMap.get(root.val);//得到root的值在中序遍历序列的index位置
    int leftTreeSize = rootIndex - preLeftIndex;
    root.left = reconstruct(preOrder, preLeftIndex + 1, preLeftIndex + rootIndex - inLeftIndex,
        inOrder, inLeftIndex, rootIndex - 1);
    root.right = reconstruct(preOrder, preLeftIndex + rootIndex - inLeftIndex + 1, preRightIndex,
        inOrder, rootIndex + 1, inRightIndex);
    return root;
  }

  public static void main(String[] args) {
    int[] pre = new int[] {1, 2, 4, 7, 3, 5, 6, 8};
    int[] in = new int[] {4, 7, 2, 1, 5, 3, 8, 6};
    TreeNode node = reconstruct(pre, in);
  }

  public void setVal(int val) {
    this.val = val;
  }

  public void setLeft(TreeNode left) {
    this.left = left;
  }

  public void setRight(TreeNode right) {
    this.right = right;
  }
}
