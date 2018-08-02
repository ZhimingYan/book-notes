/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Solution64.java
 * Date: 18-7-30 上午9:43
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t64;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 数据流中的中位数.
 *
 * 题目说明：如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，
 * 那么中位数就是所有数值排序之后中间两个数的平均值。 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 *
 * 思路： 为了保证插入新数据和取中位数的时间效率都高效，这里使用大顶堆+小顶堆的容器，并且满足：
 * 1、两个堆中的数据数目差不能超过1，这样可以使中位数只会出现在两个堆的交接处；
 * 2、大顶堆的所有数据都小于小顶堆，这样就满足了排序要求。
 *
 * @author Xiong Raorao
 * @since 2018-07-30-9:43
 */
public class Solution64 {

  int count;
  PriorityQueue<Integer> minHeap = new PriorityQueue<>();
  PriorityQueue<Integer> maxHeap = new PriorityQueue<>(11, new Comparator<Integer>() {
    @Override
    public int compare(Integer o1, Integer o2) {
      return o2.compareTo(o1);
    }
  });

  public static void main(String[] args) {

  }

  public void Insert(Integer num) {
    count++;
    if ((count & 1) == 0) {
      if (!maxHeap.isEmpty() && num < maxHeap.peek()) {
        maxHeap.offer(num);
        num = maxHeap.poll();
      }
      minHeap.offer(num);
    } else {
      if (!minHeap.isEmpty() && num > minHeap.peek()) {
        minHeap.offer(num);
        num = minHeap.poll();
      }
      maxHeap.offer(num);
    }
  }

  public Double GetMedian() {
    if (count == 0) {
      throw new RuntimeException("no available number!");
    }
    double result;
    // 总数为奇数
    if ((count & 1) == 1) {
      result = maxHeap.peek();
    } else {
      result = (minHeap.peek() + maxHeap.peek()) / 2.0;
    }
    return result;
  }

}
