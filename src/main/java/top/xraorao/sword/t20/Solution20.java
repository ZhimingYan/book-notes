/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Solution20.java
 * Date: 18-5-5 下午10:01
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t20;

import java.util.ArrayList;

/**
 * 顺时针打印矩阵.
 *
 * @author Xiong Raorao
 * @since 2018-05-05-22:01
 */
public class Solution20 {

  public static void main(String[] args) {
    int[][] a = new int[][] {{1, 2, 3}, {4, 5, 6}};
    System.out.println(a.length);
    System.out.println(a[0].length);
  }

  public static ArrayList<Integer> printMatrix(int[][] matrix) {
    if (matrix == null) {
      return null;
    }
    int start = 0;
    int rows = matrix.length;
    int cols = matrix[0].length;
    ArrayList<Integer> result = new ArrayList<>();
    while (cols > start * 2 && rows > start * 2) {
      result.addAll(printMatrixCircle(matrix, cols, rows, start));
      ++start;
    }
    return result;
  }

  private static ArrayList<Integer> printMatrixCircle(int[][] matrix, int cols, int rows,
      int start) {
    ArrayList<Integer> result = new ArrayList<>();
    int endX = cols - 1 - start;
    int endY = rows - 1 - start;
    for (int i = start; i <= endX; i++) {
      int number = matrix[start][i];
      result.add(number);
    }

    if (start < endY) {
      for (int i = start + 1; i <= endY; i++) {
        int number = matrix[i][endX];
        result.add(number);
      }
    }

    if (start < endX && start < endY) {
      for (int i = endX - 1; i >= start; --i) {
        int number = matrix[endY][i];
        result.add(number);
      }
    }

    if (start < endX && start < endY - 1) {
      for (int i = endY - 1; i >= start + 1; --i) {
        int number = matrix[i][start];
        result.add(number);
      }
    }
    return result;

  }

}
