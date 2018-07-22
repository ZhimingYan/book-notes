/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Solution35.java
 * Date: 18-7-22 下午5:14
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t35;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 第一个只出现一次的字符位置.
 *
 * 描述：在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 *
 * @author Xiong Raorao
 * @since 2018-07-22-17:14
 */
public class Solution35 {

  public static void main(String[] args) {
    String ss = "google";
    System.out.println(FirstNotRepeatingChar(ss));
  }

  public static int FirstNotRepeatingChar(String str) {
    Map<Character, Integer> map = new LinkedHashMap<>();
    char[] chars = str.toCharArray();
    for (char c : chars) {
      if (!map.containsKey(c)) {
        map.put(c, 1);
      } else {
        map.put(c, map.get(c) + 1);
      }
    }

    int pos = -1;
    for (char c:chars) {
      pos++;
      if (map.get(c) == 1) {
        return pos;
      }
    }
    return -1;
  }

}
