/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Solution19.java
 * Date: 18-4-22 下午10:55
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t19;

import top.xraorao.sword.t6.TreeNode;

/**
 * 二叉树的镜像.
 *
 * @author Xiong Raorao
 * @since 2018-04-22-22:55
 */
public class Solution19 {

  public static void main(String[] args) {

  }

  public void Mirror(TreeNode root) {
    if (root == null) {
      return;
    }
    if (root.left == null && root.right == null) {
      return;
    }
    // 交换当前节点的左右子树
    TreeNode tmp = root.left;
    root.left = root.right;
    root.right = tmp;
    if (root.left != null) {
      Mirror(root.left);
    }
    if (root.right != null) {
      Mirror(root.right);
    }
  }
}