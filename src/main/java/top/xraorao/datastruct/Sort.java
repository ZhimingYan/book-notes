/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Sort.java
 * Date: 18-7-11 上午8:49
 * Author: Xiong Raorao
 */

package top.xraorao.datastruct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 排序算法，默认排成从小到大的数组.
 *
 * @author Xiong Raorao
 * @since 2018-07-11-8:49
 */
public class Sort {

  public static void main(String[] args) {
    int[] arr = {7, 17, 2, 6, 18, 23, 4, 17, 25};
    printArr(arr);
    //bubbleSort(arr);
    //selectSort(arr);
    //insertSort2(arr);
    //shellSort(arr);
    //mergeSort(arr);
    //quickSort(arr);
    //heapSort(arr);
    countSort(arr);
    printArr(arr);
  }

  private static void printArr(int[] arr) {
    for (int i : arr) {
      System.out.print(i + ", ");
    }
    System.out.println();
  }

  /**
   * 桶排序
   */
  public static void bucketSort(int[] arr, int bucketSize) {
    int i;
    int minValue = arr[0];
    int maxValue = arr[0];
    for (i = 0; i < arr.length; i++) {
      if (arr[i] < minValue) {
        minValue = arr[i];
      } else if (arr[i] > maxValue) {
        maxValue = arr[i];
      }
    }

    // 初始化桶
    int bucketCount = (int) (Math.floor((maxValue - minValue) / bucketSize) + 1);
    List<List<Integer>> buckets = new ArrayList<>();

    for (i = 0; i < arr.length; i++) {
      int index = (int) Math.floor((arr[i] - minValue) / bucketSize);
      List<Integer> temp = buckets.get(index);
      if (temp == null) {
        buckets.add(index, Arrays.asList(arr[i]));
      } else {
        temp.add(arr[i]);
      }
    }

    for (i = 0; i < buckets.size(); i++) {
      //对每个桶进行排序。。。
    }
  }

  /**
   * 计数排序
   */
  public static void countSort(int[] arr) {
    int maxValue = arr[0];
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] > maxValue) {
        maxValue = arr[i];
      }
    }
    countSort(arr, maxValue);
  }

  private static void countSort(int[] arr, int maxValue) {
    int[] bucket = new int[maxValue + 1];
    int sortedIndex = 0;
    int len = arr.length;
    int bucketLen = maxValue + 1;

    for (int i = 0; i < len; i++) {
      bucket[arr[i]]++;
    }

    for (int j = 0; j < bucketLen; j++) {
      while (bucket[j] > 0) {
        arr[sortedIndex++] = j;
        bucket[j]--;
      }
    }
  }

  /**
   * 堆排序
   */
  public static void heapSort(int []arr){
    //1.构建大顶堆
    for(int i=arr.length/2-1;i>=0;i--){
      //从第一个非叶子结点从下至上，从右至左调整结构
      adjustHeap(arr,i,arr.length);
    }
    //2.调整堆结构+交换堆顶元素与末尾元素
    for(int j=arr.length-1;j>0;j--){
      swap(arr,0,j);//将堆顶元素与末尾元素进行交换
      adjustHeap(arr,0,j);//重新对堆进行调整,每调整好一个，length就减少一个。
    }

  }

  /**
   * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
   * @param arr
   * @param i
   * @param length
   */
  public static void adjustHeap(int []arr,int i,int length){
    int temp = arr[i];//先取出当前元素i
    for(int k=i*2+1;k<length;k=k*2+1){//从i结点的左子结点开始，也就是2i+1处开始
      if(k+1<length && arr[k]<arr[k+1]){//如果左子结点小于右子结点，k指向右子结点
        k++;
      }
      if(arr[k] >temp){//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
        arr[i] = arr[k];
        i = k;
      }else{
        break;
      }
    }
    arr[i] = temp;//将temp值放到最终的位置
  }

  /**
   * 快速排序
   */
  public static void quickSort(int[] arr) {
    quickSort(arr, 0, arr.length - 1);
  }

  private static void quickSort(int[] arr, int left, int right) {
    if (right <= left) {
      return;
    }
    int index = partition(arr, left, right);
    quickSort(arr, left, index - 1);
    quickSort(arr, index + 1, right);
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
   * 归并排序
   */
  public static void mergeSort(int[] arr) {
    mergeSort(arr, 0, arr.length - 1);
  }

  private static int[] mergeSort(int[] arr, int low, int high) {
    int mid = (low + high) / 2;
    if (low < high) {
      mergeSort(arr, low, mid);
      mergeSort(arr, mid + 1, high);
      merge(arr, low, mid, high);
    }
    return arr;
  }

  /**
   * 合并两个有序数组
   */
  private static void merge(int[] a, int low, int mid, int high) {
    int[] temp = new int[high - low + 1];
    int i = low;
    int j = mid + 1;
    int k = 0;
    // 把较小的数先移到新数组中
    while (i <= mid && j <= high) {
      if (a[i] < a[j]) {
        temp[k++] = a[i++];
      } else {
        temp[k++] = a[j++];
      }
    }
    // 把左边剩余的数移入数组
    while (i <= mid) {
      temp[k++] = a[i++];
    }
    // 把右边边剩余的数移入数组
    while (j <= high) {
      temp[k++] = a[j++];
    }
    // 把新数组中的数覆盖nums数组
    for (int x = 0; x < temp.length; x++) {
      a[x + low] = temp[x];
    }
  }

  /**
   * 插入排序
   */
  public static void insertSort(int[] arr) {
    int N = arr.length;
    for (int i = 1; i < N; i++) {
      int current = arr[i];
      int j = i - 1;
      for (; j >= 0 && arr[j] > current; j--) {
        arr[j + 1] = arr[j];
      }
      arr[j + 1] = current;
    }
  }

  /**
   * 插入排序2
   *
   * 直接相邻数据交换，不需要中间变量
   */
  public static void insertSort2(int[] arr) {
    int N = arr.length;
    for (int i = 1; i < N; i++) {
      for (int j = i; j > 0 && arr[j - 1] > arr[j]; j--) {
        swap(arr, j - 1, j);
      }
    }
  }

  /**
   * 希尔排序
   */
  public static void shellSort(int[] arr) {
    int N = arr.length;
    int h = 1;
    // 动态定义间隔
    while (h < N / 3) {
      h = h * 3 + 1; // h = 1, 4, 13, 40 ...
    }

    while (h >= 1) {
      for (int i = h; i < N; i++) {
        for (int j = i; j >= h && arr[j - h] > arr[j]; j -= h) {
          swap(arr, j - h, j);
        }
      }
      h = h / 3;
    }
  }

  /**
   * 冒泡排序
   */
  public static void bubbleSort(int[] arr) {
    boolean hasSorted = false;
    for (int i = 0; i < arr.length - 1 && !hasSorted; i++) {
      hasSorted = true;
      for (int j = 0; j < arr.length - 1 - i; j++) {
        if (arr[j + 1] < arr[j]) {
          hasSorted = false;
          swap(arr, j, j + 1);
        }
      }
    }
  }

  /**
   * 选择排序
   */
  public static void selectSort(int[] arr) {
    int N = arr.length;
    for (int i = 0; i < N - 1; i++) {
      int minIndex = i;
      for (int j = i + 1; j < N; j++) {
        if (arr[j] < arr[minIndex]) {
          minIndex = j;
        }
      }
      swap(arr, minIndex, i);
    }
  }

  private static void swap(int[] arr, int a, int b) {
    if (arr == null || arr.length == 0) {
      return;
    }

    if (a < 0 || a > arr.length || b < 0 || b > arr.length) {
      return;
    }

    int temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
  }
}
