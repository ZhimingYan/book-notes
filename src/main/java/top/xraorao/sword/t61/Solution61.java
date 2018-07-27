/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Solution61.java
 * Date: 18-7-27 上午9:20
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t61;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * 按之字形顺序打印二叉树.
 *
 * 题目描述：请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 *
 * @author Xiong Raorao
 * @since 2018-07-27-9:20
 */
public class Solution61 {
  static int i = 1;

  static {
    i = 0;                // 给变量赋值可以正常编译通过
    System.out.print(i);  // 这句编译器会提示“非法向前引用”
  }

  public static void main(String[] args) {
  }

  public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
    return null;
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
