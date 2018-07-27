/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Solution59.java
 * Date: 18-7-27 上午9:15
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t59;

/**
 * 对称的二叉树.
 *
 * 题目描述：请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 *
 * 基本思路：构造一个新的遍历方法，中，右，左，刚好和前序遍历对称，为了去除节点值都相同的情况，遍历的时候带上NULL节点
 *
 * @author Xiong Raorao
 * @since 2018-07-27-9:15
 */
public class Solution59 {

  public static void main(String[] args) {

  }

  boolean isSymmetrical(TreeNode pRoot) {
    return isSymmetrical(pRoot, pRoot);
  }

  boolean isSymmetrical(TreeNode node1, TreeNode node2) {
    if (node1 == null && node2 == null) {
      return true;
    }
    if (node1 == null || node2 == null) {
      return false;
    }
    if (node1.val != node2.val) {
      return false;
    }
    return isSymmetrical(node1.left, node2.right) && isSymmetrical(node1.right, node2.left);
  }

  public class TreeNode {

    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
      this.val = val;

    }

  }


}
