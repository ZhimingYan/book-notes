/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Solution30.java
 * Date: 18-7-19 下午3:29
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t30;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import top.xraorao.datastruct.Sort;

/**
 * 最小的K个数.
 *
 * @author Xiong Raorao
 * @since 2018-07-19-15:29
 */
public class Solution30 {

  public static void main(String[] args) {
    int[] input = new int[] {4, 5, 1, 6, 2, 7, 3, 8};
    GetLeastNumbers_Solution2(input, 4);
  }

  /**
   * 解法1：快速排序，取前K个，时间复杂度为O(nlogn)
   */
  public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
    if (input == null || input.length == 0 || k > input.length) {
      return null;
    }
    ArrayList<Integer> list = new ArrayList<>();
    Sort.quickSort(input);
    for (int i = 0; i < k; i++) {
      list.add(input[i]);
    }
    return list;
  }

  /**
   * 解法2：冒泡排序思想，外层循环k次，时间复杂度O(n*k)
   */
  public static ArrayList<Integer> GetLeastNumbers_Solution2(int[] input, int k) {
    ArrayList<Integer> list = new ArrayList<>();
    if (input == null || input.length == 0 || k > input.length || k <= 0) {
      return list;
    }
    for (int i = 0; i < k; i++) {
      for (int j = 0; j < input.length - 1 - i; j++) {
        if (input[j + 1] > input[j]) {
          int temp = input[j];
          input[j] = input[j + 1];
          input[j + 1] = temp;
        }
      }
      // 取末尾四个
      list.add(input[input.length - 1 - i]);
    }
    return list;
  }

  /**
   * 解法3：partition思想，复杂度O(n)
   */
  public static ArrayList<Integer> GetLeastNumbers_Solution3(int[] input, int k) {
    ArrayList<Integer> result = new ArrayList<>();
    if (input == null || input.length == 0 || k > input.length) {
      return result;
    }
    int len = input.length;
    int start = 0;
    int end = len - 1;
    int index = partition(input, start, end);
    while (index != (k - 1)) {
      if (index > k - 1) {
        end = index - 1;
        index = partition(input, start, end);
      } else {
        start = index + 1;
        index = partition(input, start, end);
      }
    }
    for (int i = 0; i < k; i++) {
      result.add(input[i]);
    }
    return result;
  }

  private static int partition(int[] arr, int left, int right) {
    int pivot = arr[left]; // 以第一个数为基准
    while (left < right) {
      // 先从后向前比较
      while (arr[right] > pivot && right > left) {
        right--;
      }
      arr[left] = arr[right];
      while (arr[left] <= pivot && right > left) {
        left++;
      }
      arr[right] = arr[left];
    }
    arr[right] = pivot;
    return right;
  }

  /**
   * 解法四：最大堆
   */
  public ArrayList<Integer> GetLeastNumbers_Solution4(int[] input, int k) {
    ArrayList<Integer> result = new ArrayList<>();
    int length = input.length;
    if (k > length || k == 0) {
      return result;
    }
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o2.compareTo(o1);
      }
    });
    for (int i = 0; i < length; i++) {
      if (maxHeap.size() != k) {
        maxHeap.offer(input[i]);
      } else if (maxHeap.peek() > input[i]) {
        Integer temp = maxHeap.poll();
        temp = null;
        maxHeap.offer(input[i]);
      }
    }
    for (Integer integer : maxHeap) {
      result.add(integer);
    }
    return result;
  }
}
