/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Solution62.java
 * Date: 18-7-27 下午8:00
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t62;

/**
 * 序列化二叉树.
 *
 * @author Xiong Raorao
 * @since 2018-07-27-19:58
 */
public class Solution62 {

  public int index = -1;

  public static void main(String[] args) {

  }

  String Serialize(TreeNode root) {
    StringBuffer sb = new StringBuffer();
    if (root == null) {
      sb.append("#,");
      return sb.toString();
    }
    sb.append(root.val + ",");
    sb.append(Serialize(root.left));
    sb.append(Serialize(root.right));
    return sb.toString();
  }

  TreeNode Deserialize(String str) {
    index++;
    int len = str.length();
    if (index >= len) {
      return null;
    }
    String[] strr = str.split(",");
    TreeNode node = null;
    if (!strr[index].equals("#")) {
      node = new TreeNode(Integer.valueOf(strr[index]));
      node.left = Deserialize(str);
      node.right = Deserialize(str);
    }
    return node;
  }

  static class TreeNode {

    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
      this.val = val;

    }

  }

}
