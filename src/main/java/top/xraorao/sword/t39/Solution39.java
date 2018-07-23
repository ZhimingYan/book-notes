/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Solution39.java
 * Date: 18-7-23 下午3:38
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t39;

/**
 * 二叉树的深度.
 *
 * 题目：输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 *
 * 思路：树的深度等于左子树的深度和右子树的深度中最大的值+1；
 *
 * @author Xiong Raorao
 * @since 2018-07-23-15:38
 */
public class Solution39 {

  public static void main(String[] args) {

  }

  public static int TreeDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int nLeft = TreeDepth(root.left);
    int nRight = TreeDepth(root.right);

    return nLeft > nRight ? nLeft + 1 : nRight + 1;
  }
}
