/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Queue.java
 * Date: 18-3-30 上午8:58
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t7;

import java.util.Stack;

/**
 * 用栈实现队列.
 *
 * @author Xiong Raorao
 * @since 2018-03-30-8:58
 */
public class Queue {

  Stack<Integer> stack1 = new Stack<>();
  Stack<Integer> stack2 = new Stack<>();

  public void push(int node) {
    stack1.push(node);
  }

  public int pop() {
    if (!stack2.empty()) {
      return stack2.pop();
    } else {
      while (!stack1.empty()) {
        int data = stack1.pop();
        stack2.push(data);
      }
      return stack2.pop();
    }
  }

}
