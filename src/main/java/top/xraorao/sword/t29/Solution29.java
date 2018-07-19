/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Solution29.java
 * Date: 18-7-19 上午9:19
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t29;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组中出现次数超过一半的数字.
 *
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 *
 * @author Xiong Raorao
 * @since 2018-07-19-9:18
 */
public class Solution29 {

  public static void main(String[] args) {
    int[] arr = new int[] {1, 2, 3, 2, 2, 2, 5, 4, 2};
    //System.out.println(MoreThanHalfNum_Solution(arr));
    System.out.println(MoreThanHalfNum_Solution2(arr));
  }

  /**
   * 解法一： 使用 Map存储数组的个数和多少
   */
  public static int MoreThanHalfNum_Solution(int[] array) {
    if (array == null || array.length == 0) {
      return 0;
    }
    Map<Integer, Integer> map = new HashMap<>();
    for (int i : array) {
      if (map.containsKey(i)) {
        map.put(i, map.get(i) + 1);
      } else {
        map.put(i, 1);
      }
    }

    int maxValue = 0;
    int maxKey = 0;
    int arrLength = array.length;
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (maxValue < entry.getValue()) {
        maxValue = entry.getValue();
        maxKey = entry.getKey();
      }
    }
    return maxValue > arrLength / 2 ? maxKey : 0;
  }

  /**
   * 解法二：根据数组的特点，如果数组中有一个数字出现的次数超过数组长度的一半，那么它出现的次数比其他所有数字出现的次数的和还要多。 因此在遍历数组的时候，我们可以考虑在遍历数组的时候保存两个值：一个是数组中的一个数字，有一个是次数。
   * 当我们遍历到下一个数字的时候，如果下一个数字和我们之前保存的数字相同，则次数加1，否则次数减1。如果次数为0，需要保存下一个数字，把次数设为1。
   */
  public static int MoreThanHalfNum_Solution2(int[] array) {
    if (array == null || array.length == 0) {
      return 0;
    }

    int result = array[0];
    int times = 1;
    for (int i = 0; i < array.length; i++) {
      if (times == 0) {
        result = array[i];
        times = 1;
      } else if (array[i] == result) {
        times++;
      } else {
        times--;
      }
    }
    if (!checkMoreThanHalf(array, result)) {
      result = 0;
    }
    return result;
  }

  private static boolean checkMoreThanHalf(int[] numbers, int number) {
    int length = numbers.length;
    int times = 0;
    for (int i = 0; i < length; i++) {
      if (numbers[i] == number) {
        times++;
      }
    }
    boolean isMoreThanHalf = true;
    if (times * 2 <= length) {
      isMoreThanHalf = false;
    }
    return isMoreThanHalf;
  }

}
