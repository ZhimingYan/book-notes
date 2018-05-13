/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Solution23.java
 * Date: 18-5-6 下午5:43
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t23;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import top.xraorao.sword.t6.TreeNode;

/**
 * 从上往下打印二叉树.
 *
 * @author Xiong Raorao
 * @since 2018-05-06-17:43
 */
public class Solution23 {

  public static void main(String[] args) {

  }

  public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    ArrayList<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    queue.add(root);
    while (!queue.isEmpty()) {
      int queueSize = queue.size();
      while (queueSize-- > 0) {
        TreeNode t = queue.poll();
        if (t.left != null) {
          queue.add(t.left);
        }
        if (t.right != null) {
          queue.add(t.right);
        }
        result.add(t.val);
      }
    }
    return result;
  }
}
