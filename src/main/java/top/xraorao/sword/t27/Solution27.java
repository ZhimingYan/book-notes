/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Solution27.java
 * Date: 18-7-4 上午9:09
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t27;

import java.util.Stack;
import top.xraorao.sword.t12.Solution12;
import top.xraorao.sword.t6.TreeNode;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向.
 *
 * @author Xiong Raorao
 * @since 2018-07-04-9:09
 */
public class Solution27 {

  public static void main(String[] args) {
    //构造一个平衡的二叉排序树测试，4,6,8,10,12,14,16
    TreeNode root = new TreeNode(10);
    TreeNode left = new TreeNode(6);
    left.setLeft(new TreeNode(4));
    left.setRight(new TreeNode(8));
    TreeNode right = new TreeNode(14);
    right.setLeft(new TreeNode(12));
    right.setRight(new TreeNode(16));
    root.setLeft(left);
    root.setRight(right);

    Solution27 solution27 = new Solution27();
    //solution27.Convert(root);
    solution27.Covert2(root);
  }

  /**
   * 递归版本：
   *
   * 链接：https://www.nowcoder.com/questionTerminal/947f6eb80d944a84850b0538bf0ec3a5 来源：牛客网
   *
   * 1.将左子树构造成双链表，并返回链表头节点。
   *
   * 2.定位至左子树双链表最后一个节点。
   *
   * 3.如果左子树链表不为空的话，将当前root追加到左子树链表。
   *
   * 4.将右子树构造成双链表，并返回链表头节点。
   *
   * 5.如果右子树链表不为空的话，将该链表追加到root节点之后。
   *
   * 6.根据左子树链表是否为空确定返回的节点。
   */
  public TreeNode Convert(TreeNode pRootOfTree) {
    if (pRootOfTree == null) {
      return null;
    }

    // 递归终止条件
    if (pRootOfTree.left == null && pRootOfTree.right == null) {
      return pRootOfTree;
    }

    // 1. 左子树构建双向链表，返回链表头结点
    TreeNode left = Convert(pRootOfTree.left);
    TreeNode p = left;

    // 2. 定位到左子树双链表的最后一个节点
    while (p != null && p.right != null) {
      p = p.right;
    }

    // 3. 如果左子树链表不为空的话，将当前root追加到左子树链表
    if (left != null) {
      p.right = pRootOfTree;
      pRootOfTree.left = p;
    }

    // 4. 将右子树构造成双链表，返回链表头
    TreeNode right = Convert(pRootOfTree.right);

    if (right != null) {
      right.left = pRootOfTree;
      pRootOfTree.right = right;
    }

    return left != null ? left : pRootOfTree;
  }

  /**
   * 核心是中序遍历的非递归算法
   *
   * 修改当前遍历节点与前一遍历节点的指针指向。
   *
   * @param root
   * @return
   */
  public TreeNode Covert2(TreeNode root) {
    if (root == null) {
      return null;
    }
    Stack<TreeNode> stack = new Stack<>();
    TreeNode p = root;
    TreeNode pre = null;// 用于保存中序遍历序列的上一节点
    boolean isFirst = true;
    while (p != null || !stack.isEmpty()) {
      while (p != null) {
        stack.push(p);
        p = p.left;
      }
      p = stack.pop();
      if (isFirst) {
        root = p;// 将中序遍历序列中的第一个节点记为root
        pre = root;
        isFirst = false;
      } else {
        pre.right = p;
        p.left = pre;
        pre = p;
      }
      p = p.right;
    }
    return root;
  }
}
