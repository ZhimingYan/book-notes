/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: CQueue.java
 * Date: 18-4-14 下午9:15
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t7;

import java.util.Stack;

/**
 * 使用两个栈来实现队列.
 *
 * @author Xiong Raorao
 * @since 2018-04-14-21:15
 */
public class CQueue {

  private Stack<Integer> stack1 = new Stack<>();
  private Stack<Integer> stack2 = new Stack<>();

  public void push(Integer node) {
    stack1.push(node);
  }

  public Integer pop() {
    if (stack2.isEmpty()) {
      //将stack1的元素依次弹出并压入 stack2
      while (!stack1.isEmpty()) {
        int data = stack1.pop();
        stack2.push(data);
      }
      return stack2.pop();
    } else {
      return stack2.pop();
    }
  }

}
