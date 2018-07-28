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

  /**
   * 解法一：利用队列的思想来打印。
   * @param pRoot
   * @return
   */
  ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
    ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
    if (pRoot == null) {
      return lists;
    }
    LinkedList<TreeNode> layer = new LinkedList<>();
    ArrayList<Integer> layerList = new ArrayList<>();
    layer.add(pRoot);
    int start = 0, end = 1;
    while (!layer.isEmpty()) {
      TreeNode cur = layer.remove();
      layerList.add(cur.val);
      start++;
      if (cur.left != null) {
        layer.add(cur.left);
      }
      if (cur.right != null) {
        layer.add(cur.right);
      }
      if (start == end) {
        end = layer.size();
        start = 0;
        lists.add(layerList);
        layerList = new ArrayList<>();
      }
    }
    return lists;
  }

  /**
   * 解法二：
   * @param pRoot
   * @return
   */
  ArrayList<ArrayList<Integer>> Print2(TreeNode pRoot) {

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
