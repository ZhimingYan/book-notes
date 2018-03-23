/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Magic.java
 * Date: 18-3-23 下午9:23
 * Author: Xiong Raorao
 */

package top.xraorao.interview.tencent;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 魔法石.
 *
 * 题目描述：
 *
 * @author Xiong Raorao
 * @since 2018-03-23-21:23
 */
public class Magic {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int t = scanner.nextInt();
    int[] x = new int[4];
    int[] y = new int[4];
    boolean[] result = new boolean[t];
    for (int i = 0; i < t; i++) {
      for (int j = 0; j < 4; j++) {
        x[j] = scanner.nextInt();
      }
      for (int j = 0; j < 4; j++) {
        y[j] = scanner.nextInt();
      }
      result[i] = isSquare(x, y);
    }
    for (int i = 0; i < t; i++) {
      if (result[i]) {
        System.out.println("Yes");
      } else {
        System.out.println("No");
      }
    }

  }

  private static boolean isSquare(int[] x, int[] y) {
    if (x.length != 4 || y.length != 4) {
      return false;
    }
    Arrays.sort(x);
    Arrays.sort(y);
    return x[3] - x[1] == y[3] - y[1];
  }

}
