/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: 包含min函数的栈.java
 * Date: 18-5-6 下午4:27
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t21;

import java.util.Stack;

/**
 * .
 *
 * @author Xiong Raorao
 * @since 2018-05-06-16:26
 */
public class Solution21 {

  private static Stack<Integer> dataStack = new Stack<>();
  private static Stack<Integer> minStack = new Stack<>();

  public static void main(String[] args) {

  }

  public void push(int node) {
    dataStack.push(node);
    if (minStack.size() == 0 || node < minStack.peek()) {
      // 如果min栈为空或者节点比栈顶元素小，则直接压入
      minStack.push(node);
    } else {
      // 如果待压入的栈顶元素小于待压入的节点，则重新压入一个栈顶的元素
      minStack.push(minStack.peek());
    }
  }

  public void pop() {
    dataStack.pop();
    minStack.pop();
  }

  public int top() {
    return dataStack.peek();
  }

  public int min() {
    return minStack.peek();
  }

}
