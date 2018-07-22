/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Utils.java
 * Date: 18-7-22 上午10:55
 * Author: Xiong Raorao
 */

package top.xraorao.datastruct;

/**
 * 静态工具类.
 *
 * @author Xiong Raorao
 * @since 2018-07-22-10:55
 */
public class Utils {

  private Utils() {
  }

  public static void printArr(int[] arr) {
    for (int i : arr) {
      System.out.print(i + ", ");
    }
    System.out.println();
  }

  /**
   * 不用辅助内存实现数组的交换
   */
  public static void swap(int[] num, int i, int j) {
    if (num == null || num.length < 2) {
      return;
    }

    num[i] = num[i] ^ num[j];
    num[j] = num[i] ^ num[j];
    num[i] = num[i] ^ num[j];
  }

}
