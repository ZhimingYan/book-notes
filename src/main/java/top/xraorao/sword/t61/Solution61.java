/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Solution61.java
 * Date: 18-7-27 上午9:20
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t61;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 按之字形顺序打印二叉树.
 *
 * 题目描述：请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 *
 * @author Xiong Raorao
 * @since 2018-07-27-9:20
 */
public class Solution61 {

  public static void main(String[] args) {
  }

  /**
   * 在60题的基础上，把偶数行的顺序调换一下就可以了。
   */
  public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
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
        if (lists.size() % 2 == 0) {
          lists.add(layerList);
        } else {
          ArrayList<Integer> tmp = invert(layerList);
          lists.add(tmp);
        }
        layerList = new ArrayList<>();
      }
    }
    return lists;
  }

  private ArrayList<Integer> invert(ArrayList<Integer> list) {
    ArrayList<Integer> res = new ArrayList<>();
    for (int i = list.size() - 1; i >= 0; i--) {
      res.add(list.get(i));
    }
    return res;
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
