/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Find.java
 * Date: 18-7-14 上午9:27
 * Author: Xiong Raorao
 */

package top.xraorao.datastruct;

/**
 * 查找类.
 *
 * @author Xiong Raorao
 * @since 2018-07-14-9:27
 */
public class Find {

  public static void main(String[] args) {
    int[] disOrderArr = {7, 17, 2, 6, 18, 23, 4, 17, 25};
    int[] orderArr = {1, 3, 9, 22, 27, 28, 28, 30, 32};

    System.out.println(sequenceSearch(disOrderArr, 6));
    System.out.println(binarySearch(orderArr, 22));
    System.out.println(insertSearch(orderArr, 22));
  }

  /**
   * 顺序查找
   *
   * @param arr 目标数组
   * @param key 关键字
   * @return 目标数组的索引
   */
  public static int sequenceSearch(int[] arr, int key) {
    if (arr == null || arr.length == 0) {
      return -1;
    }
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == key) {
        return i;
      }
    }
    return -1;
  }

  /**
   * 二分查找
   *
   * @param arr 目标数组
   * @param key 关键字
   * @return 目标数组的索引
   */
  public static int binarySearch(int[] arr, int key) {
    return binarySearch(arr, key, 0, arr.length - 1);
  }

  private static int binarySearch(int[] arr, int key, int low, int high) {
    int mid = (low + high) / 2;
    if (arr[mid] == key) {
      return mid;
    } else if (arr[mid] < key) {
      low = mid + 1;
      return binarySearch(arr, key, low, high);
    } else {
      high = mid - 1;
      return binarySearch(arr, key, low, high);
    }
  }

  /**
   * 插入查找
   *
   * @param arr 目标数组
   * @param key 关键字
   * @return 目标数组的索引
   */
  public static int insertSearch(int[] arr, int key) {
    return insertSearch(arr, key, 0, arr.length - 1);
  }

  private static int insertSearch(int[] arr, int key, int low, int high) {
    // 把二分查找的比例参数改为自适应的，让mid值的变化更加靠近关键字key，间接减少比较次数
    int mid = low + (key - arr[low]) / (arr[high] - arr[low]) * (high - low);
    if (arr[mid] == key) {
      return mid;
    } else if (arr[mid] < key) {
      low = mid + 1;
      return insertSearch(arr, key, low, high);
    } else {
      high = mid - 1;
      return insertSearch(arr, key, low, high);
    }
  }

}











