/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: ArrayFind.java
 * Date: 18-3-20 下午7:52
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t3;

/**
 * 二维数组的查找.
 *
 * @author Xiong Raorao
 * @since 2018-03-20-19:52
 */
public class ArrayFind {

  /**
   * 按行优先扫描，从左下角往上扫描
   *
   * @param matrix 输入矩阵
   * @param number 待查找目标
   */
  public static boolean find2(int[][] matrix, int number) {
    boolean result = false;
    if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
      return false;
    }
    int rows = matrix.length;
    int columns = matrix[0].length;
    int row = rows - 1;
    int column = 0;
    while (row >= 0 && column < columns) {
      if (matrix[row][column] == number) {
        result = true;
        break;
      } else if (matrix[row][column] < number) {
        column++;
      } else {
        row--;
      }
    }
    return result;
  }

  /**
   * 按列优先扫描,从右上角开始往左扫描
   *
   * @param matrix 输入矩阵
   * @param number 待查找目标
   */
  public static boolean find1(int[][] matrix, int number) {
    boolean result = false;
    if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
      return false;
    }
    int rows = matrix.length;
    int columns = matrix[0].length;
    int row = 0; // initial paramer
    int column = columns - 1;// initial paramer
    while (row < rows && column >= 0) {
      if (matrix[row][column] == number) {
        result = true;
        break;
      } else if (matrix[row][column] > number) {
        column--;
      } else {
        row++;
      }
    }
    return result;
  }

}
