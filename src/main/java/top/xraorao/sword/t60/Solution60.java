/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Solution60.java
 * Date: 18-7-27 上午9:17
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t60;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;


/**
 * 把二叉树打印成多行.
 *
 * 题目描述：从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 *
 * @author Xiong Raorao
 * @since 2018-07-27-9:17
 */
public class Solution60 {

  public static void main(String[] args) {

  }

  ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
    ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
    if (pRoot == null) {
      return lists;
    }

    LinkedList<TreeNode> nodes = new LinkedBlockingQueue<>();
    nodes.push(pRoot);
    int nexLevel = 0;
    int toBePrinted = 1;
    while (nodes.push(); != null) {
      ArrayList<Integer> tempList = new ArrayList<>();
      tempList.add(node.val);
      if (node.left != null) {
        tempList.add(node.left.val);
        nexLevel++;
      } else if (node.right != null) {
        tempList.add(node.right.val);
        nexLevel++;
      }

      lists.add(tempList);
    }
  }

  class TreeNode {

    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
      this.val = val;

    }
  }
}
