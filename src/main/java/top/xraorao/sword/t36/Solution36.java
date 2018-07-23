/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Solution36.java
 * Date: 18-7-23 上午9:10
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t36;

/**
 * 数组中的逆序对.
 *
 * @author Xiong Raorao
 * @since 2018-07-23-8:39
 */
public class Solution36 {

  public static void main(String[] args) {
    int[] arr = new int[] {364, 637, 341, 406, 747, 995, 234, 971, 571, 219, 993, 407, 416, 366,
        315, 301, 601, 650, 418, 355, 460, 505, 360, 965, 516, 648, 727, 667, 465, 849, 455, 181,
        486, 149, 588, 233, 144, 174, 557, 67, 746, 550, 474, 162, 268, 142, 463, 221, 882, 576,
        604, 739, 288, 569, 256, 936, 275, 401, 497, 82, 935, 983, 583, 523, 697, 478, 147, 795,
        380, 973, 958, 115, 773, 870, 259, 655, 446, 863, 735, 784, 3, 671, 433, 630, 425, 930, 64,
        266, 235, 187, 284, 665, 874, 80, 45, 848, 38, 811, 267, 575};
    System.out.println(InversePairs(arr));
  }

  public static int InversePairs(int[] array) {
    if (array == null || array.length == 0) {
      return 0;
    }

    int[] copy = new int[array.length];
    for (int i = 0; i < array.length; i++) {
      copy[i] = array[i];
    }
    return InverseParisCore(array, copy, 0, array.length - 1);
  }

  private static int InverseParisCore(int[] array, int[] copy, int low, int high) {
    if (low == high) {
      return 0;
    }
    int mid = (low + high) >> 1;
    int leftCount = InverseParisCore(array, copy, low, mid) % 1000000007;
    int rightCount = InverseParisCore(array, copy, mid + 1, high) % 1000000007;

    int i = mid;
    int j = high;
    int locCopy = high;
    int count = 0;
    while (i >= low && j >= mid + 1) {
      if (array[i] > array[j]) {
        copy[locCopy--] = array[i--];
        count += j - mid;
        if (count >= 1000000007) {
          ////数值过大求余
          count %= 1000000007;
        }
      } else {
        copy[locCopy--] = array[j--];
      }
    }

    for (; i >= low; --i) {
      copy[locCopy--] = array[i];
    }
    for (; j >= mid + 1; --j) {
      copy[locCopy--] = array[j];
    }
    for (int s = low; s <= high; s++) {
      array[s] = copy[s];
    }

    return (leftCount + rightCount + count) % 1000000007;

  }
}
