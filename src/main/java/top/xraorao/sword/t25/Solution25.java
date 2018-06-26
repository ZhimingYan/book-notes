/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Solution25.java
 * Date: 18-6-26 上午8:36
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t25;

import java.util.ArrayList;
import top.xraorao.sword.t6.TreeNode;

/**
 * 二叉树和为某一值的路径.
 *
 * 分析：路径是根节点触发到叶子节点，因此需要现需遍历访问根节点
 *
 * @author Xiong Raorao
 * @since 2018-06-26-8:35
 */
public class Solution25 {

  private ArrayList<ArrayList<Integer>> result = new ArrayList<>();

  public static void main(String[] args) {
    TreeNode tree = new TreeNode(10);
    tree.left = new TreeNode(5);
    tree.right = new TreeNode(12);
    tree.left.left = new TreeNode(4);
    tree.left.right = new TreeNode(7);

    Solution25 solution25 = new Solution25();
    solution25.FindPath(tree, 22);
  }

  public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
    ArrayList<Integer> path = new ArrayList<>();
    if (root == null) {
      return result;
    }
    int currentSum = 0;
    FindPath(root, target, path, currentSum);
    return result;
  }

  public void FindPath(TreeNode root, int target, ArrayList<Integer> path,
      int currentSum) {
    currentSum += root.val;
    path.add(root.val);
    boolean isLeaf = root.left == null && root.right == null;
    if (currentSum == target && isLeaf) {
      // 输出路径
      result.add(new ArrayList<>(path));
    }

    if (root.left != null) {
      FindPath(root.left, target, path, currentSum);
    }

    if (root.right != null) {
      FindPath(root.right, target, path, currentSum);
    }

    path.remove(path.size() - 1);

  }

}
