/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Solution40.java
 * Date: 18-7-23 下午3:54
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t39;

/**
 * 平衡二叉树
 *
 * 题目描述：输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 *
 * 思路: 二叉树左右子树的高度相差不能超过1，否则不平衡
 *
 * @author Xiong Raorao
 * @since 2018-07-23-15:52
 */
public class Solution {

  public static void main(String[] args) {

  }

  public boolean IsBalanced_Solution(TreeNode root) {
    if (root == null) {
      return true;
    }
    int left = Solution39.TreeDepth(root.left);
    int right = Solution39.TreeDepth(root.right);
    int diff = left - right;
    if (diff > 1 || diff < -1) {
      return false;
    }

    return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
  }
}
