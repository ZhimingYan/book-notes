/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Solution34.java
 * Date: 18-7-20 上午9:31
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t34;

/**
 * 丑数.
 *
 * 题目：把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 *
 * 基本思路： 解法一：逐个判断每个证书是不是丑数。（直观，但不是很高效）
 *
 * 解法二：创建数组保存已经找到的丑数，时间换空间。一个丑数必然是另一个丑数和2 3 5的乘积所得。
 *
 * @author Xiong Raorao
 * @since 2018-07-20-9:30
 */
public class Solution34 {

  public static void main(String[] args) {
    //System.out.println(isUglyNumber(12));
    System.out.println(GetUglyNumber_Solution2(12));
  }

  /**
   * 解法一：牛客网无法通过，时间复杂度过高。
   */
  public static int GetUglyNumber_Solution(int index) {
    int current = 1;
    for (int i = 0; i < index; i++) {
      while (!isUglyNumber(current++)) {
      }
    }
    return current - 1;
  }

  /**
   * 判断数字是否为丑数
   *
   * @param number 待判断的数字
   */
  private static boolean isUglyNumber(int number) {
    if (number <= 0) {
      return false;
    }
    if (number == 1) {
      return true;
    }
    while (number % 5 == 0) {
      number /= 5;
    }
    while (number % 2 == 0) {
      number /= 2;
    }
    while (number % 3 == 0) {
      number /= 3;
    }
    return number == 1;
  }

  /**
   * 解法二：创建数组保存已经找到的丑数
   */
  public static int GetUglyNumber_Solution2(int index) {
    // 1 ~ 6都是丑数
    if (index < 7) {
      return index;
    }
    int[] res = new int[index];
    res[0] = 1;
    int t2 = 0, t3 = 0, t5 = 0;
    for (int i = 1; i < index; i++) {
      res[i] = min(res[t2] * 2, res[t3] * 3, res[t5] * 5);
      if (res[i] == res[t2] * 2) {
        t2++;
      }
      if (res[i] == res[t3] * 3) {
        t3++;
      }
      if (res[i] == res[t5] * 5) {
        t5++;
      }
    }
    return res[index - 1];
  }

  private static int min(int a, int b, int c) {
    int min = a < b ? a : b;
    min = min < c ? min : c;
    return min;
  }
}
