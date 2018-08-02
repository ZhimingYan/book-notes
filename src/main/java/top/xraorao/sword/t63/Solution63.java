/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Solution23.java
 * Date: 18-7-30 上午8:40
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t63;

/**
 * 二叉搜索树的第K个节点.
 *
 * 题目描述：给定一棵二叉搜索树，请找出其中的第k小的结点。例如，（5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
 *
 * @author Xiong Raorao
 * @since 2018-07-30-8:39
 */
public class Solution63 {

  private static int K = 0;

  public static void main(String[] args) {
    TreeNode root = new TreeNode(5);
    TreeNode left = new TreeNode(3);
    left.left = new TreeNode(2);
    left.right = new TreeNode(4);
    TreeNode right = new TreeNode(7);
    right.left = new TreeNode(6);
    right.right = new TreeNode(8);
    root.left = left;
    root.right = right;

    System.out.println(read(root));
    System.out.println(KthNode(root, 3).val);
  }

  /**
   * 二叉树的中序遍历
   */
  private static String read(TreeNode root) {
    String res = "";
    if (root == null) {
      return null;
    } else if (root.left != null) {
      res += read(root.left) + ",";
    }
    res += root.val + ",";
    if (root.right != null) {
      res += read(root.right) + ",";
    }
    return res;
  }

  static TreeNode KthNode(TreeNode pRoot, int k) {
    K = k;
    return KthNode(pRoot);
  }

  static TreeNode KthNode(TreeNode pRoot) {
    if (pRoot == null || K == 0) {
      return null;
    }
    TreeNode target = null;
    if (pRoot.left != null) {
      target = KthNode(pRoot.left, K);
    }
    if (target == null) {
      if (K == 1) {
        target = pRoot;
      }
      K--;
    }
    if (target == null && pRoot.right != null) {
      target = KthNode(pRoot.right, K);
    }
    return target;
  }

  public static class TreeNode {

    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
      this.val = val;

    }

  }

}
