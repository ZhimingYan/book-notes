/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Solution52.java
 * Date: 18-7-24 下午4:23
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t52;

/**
 * 构建乘积数组.
 *
 * 题目描述：给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 *
 * @author Xiong Raorao
 * @since 2018-07-24-16:22
 */
public class Solution52 {

  public static void main(String[] args) {
    int[] t = new int[]{1,2,3,4,5};
    int[] res = multiply(t);
  }

  public static int[] multiply(int[] A) {
    if (A == null || A.length == 0) {
      return new int[] {};
    }
    int length = A.length;
    int[] C = new int[length];
    int[] D = new int[length];
    C[0] = 1;
    D[length - 1] = 1;
    for (int i = 1; i < length; i++) {
      C[i] = C[i - 1] * A[i-1];
    }
    for (int i = length - 2; i >= 0; i--) {
      D[i] = D[i + 1] * A[i + 1];
    }
    int[] res = new int[length];
    for (int i = 0; i < length; i++) {
      res[i] = C[i] * D[i];
    }
    return res;
  }

}
