/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Solution50.java
 * Date: 18-7-24 下午4:05
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t50;

/**
 * 树中两个节点的最低公共祖先.
 *
 * @author Xiong Raorao
 * @since 2018-07-24-16:05
 */
public class Solution50 {

  public static void main(String[] args) {

  }

  /**
   * 对于二叉查找树的解法
   * @param root
   * @param p
   * @param q
   * @return
   */
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) {
      return root;
    }
    if (root.val > p.val && root.val > q.val) {
      return lowestCommonAncestor(root.left, p, q);
    }
    if (root.val < p.val && root.val < q.val) {
      return lowestCommonAncestor(root.right, p, q);
    }
    return root;
  }

  /**
   * 对于普通二叉树的解法
   * @param root
   * @param p
   * @param q
   * @return
   */
  public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q)
      return root;
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);
    return left == null ? right : right == null ? left : root;
  }

  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
  }

}
