/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Solution12.java
 * Date: 18-4-19 上午8:23
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t12;

/**
 * 打印1到最大的n位数.
 *
 * @author Xiong Raorao
 * @since 2018-04-19-8:22
 */
public class Solution12 {

  public static void main(String[] args) {
    Solution12 solution12 = new Solution12();
    solution12.print1ToMaxOfNDigits(2);
  }

  public void print1ToMaxOfNDigits(int n) {
    if (n < 0) {
      return;
    }
    char[] number = new char[n];
    print1ToMaxOfNDigits(number, -1);
  }

  /**
   * 每个十位就打印一次，终止条件就是游标到达number的最左边.
   */
  private void print1ToMaxOfNDigits(char[] number, int digit) {
    if (digit == number.length - 1) {
      printNumber(number);
      return;
    }
    for (int i = 0; i < 10; i++) {
      number[digit + 1] = (char) (i + '0');
      print1ToMaxOfNDigits(number, digit + 1);
    }
  }

  /**
   * 打印字符数组，首位是0的字符就不打印.
   *
   * @param numbers 数组
   */
  private void printNumber(char[] numbers) {
    if (numbers == null || numbers.length == 0) {
      return;
    }
    int index = 0;
    while (index < numbers.length && numbers[index] == '0') {
      index++;
    }
    while (index < numbers.length) {
      System.out.print(numbers[index++]);
    }
    System.out.println();
  }

}
