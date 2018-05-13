/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Solution22.java
 * Date: 18-5-6 下午5:42
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t22;

import java.util.Stack;

/**
 * 栈的压入弹出序列.
 *
 * @author Xiong Raorao
 * @since 2018-05-06-16:44
 */
public class Solution22 {

  public static void main(String[] args) {

  }

  public static boolean IsPopOrder(int[] pushA, int[] popA) {
    int n = pushA.length;
    Stack<Integer> stack = new Stack<>();
    for (int pushIndex = 0, popIndex = 0; pushIndex < n; pushIndex++) {
      stack.push(pushA[pushIndex]);
      while (popIndex < n && stack.peek() == popA[popIndex]) {
        stack.pop();
        popIndex++;
      }
    }
    return stack.isEmpty();
  }
}
