/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Solution18.java
 * Date: 18-4-22 上午8:29
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t18;


import top.xraorao.sword.t6.TreeNode;

/**
 * 树的子结构.
 *
 * @author Xiong Raorao
 * @since 2018-04-22-8:29
 */
public class Solution18 {

  public static void main(String[] args) {

  }

  public boolean hasSubtree(TreeNode root1, TreeNode root2) {
    boolean result = false;
    if (root1 != null && root2 != null) {
      if (root1.val == root2.val) {
        result = doesTree1HaveTree2(root1, root2);
      }
      if (!result) {
        result = hasSubtree(root1.left, root2);
      }
      if (!result) {
        result = hasSubtree(root1.right, root2);
      }
    }
    return result;
  }

  // 当两个树的根节点相同的时候，两个树
  private boolean doesTree1HaveTree2(TreeNode root1, TreeNode root2) {
    if (root1 == null && root2 == null) {
      return true;
    }
    if (root1 == null) {
      return false;// 空节点不会包含其他子节点
    }
    if (root2 == null) {
      return true; // 空节点是任何节点的子节点
    }
    if (root1.val != root2.val) {
      return false;
    }

    return doesTree1HaveTree2(root1.left, root2.left) && doesTree1HaveTree2(root1.right,
        root2.right);
  }

}
