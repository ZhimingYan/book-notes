/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Permutation.java
 * Date: 18-7-18 上午9:00
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t28;

import java.util.ArrayList;

/**
 * .
 *
 * @author Xiong Raorao
 * @since 2018-07-18-9:00
 */
public class Permutation {

  public static void main(String[] args) {
    String ss = "abc";
    ArrayList<String> result = permutation(ss);
    for (String s : result) {
      System.out.println(s);
    }
  }

  public static ArrayList<String> permutation(String str) {
    ArrayList<String> result = new ArrayList<>();
    char[] chars = str.toCharArray();
    permutation(chars, 0, chars.length - 1, result);
    return result;
  }

  private static void permutation(char[] chars, int left, int right, ArrayList<String> list) {
    if (left < right) {
      for (int i = left; i <= right; i++) {
        swap(chars, left, i);
        if (!list.contains(String.valueOf(chars))) {
          list.add(String.valueOf(chars));
        }
        permutation(chars, left + 1, right, list);
        swap(chars, left, i);
      }
    } else {
      return;
    }
  }

  private static void swap(char[] chars, int i, int j) {
    char temp = chars[i];
    chars[i] = chars[j];
    chars[j] = temp;
  }

}
