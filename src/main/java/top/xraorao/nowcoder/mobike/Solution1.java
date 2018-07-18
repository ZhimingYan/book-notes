/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Solution1.java
 * Date: 18-7-18 下午2:59
 * Author: Xiong Raorao
 */

package top.xraorao.nowcoder.mobike;

import java.util.Scanner;

/**
 * 倒着输出整数.
 *
 * 例子: 输入 -1563, 输出 -3651
 *
 * @author Xiong Raorao
 * @since 2018-07-18-14:59
 */
public class Solution1 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    StringBuilder builder = new StringBuilder();
    invert(input, 0, builder);
    //去掉数字头部的零
    int temp = Integer.parseInt(builder.toString());
    String res = String.valueOf(temp);
    System.out.println(res);
  }

  public static void invert(String s, int left, StringBuilder dst) {
    boolean isMinus = false;
    if (s.lastIndexOf("-") > -1) {
      s = s.substring(1, s.length());
      isMinus = true;
    }

    if (left < s.length()) {
      invert(s, ++left, dst);
      dst.append(s.substring(left - 1, left));
    }

    if (isMinus) {
      dst.insert(0,'-');
    }
    return;
  }
}
