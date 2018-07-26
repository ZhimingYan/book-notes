/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Solution55.java
 * Date: 18-7-26 下午4:21
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t55;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

/**
 * 字符流中第一个不重复的字符.
 *
 * 题目描述：请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 *
 * @author Xiong Raorao
 * @since 2018-07-26-16:20
 */
public class Solution55 {

  private LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();

  public static void main(String[] args) {
    Solution55 solution55 = new Solution55();
    String ss = "google";
    StringBuilder sb = new StringBuilder();
    for (char c : ss.toCharArray()) {
      solution55.Insert(c);
      sb.append(solution55.FirstAppearingOnce());
    }
    System.out.println(sb.toString());
  }

  //Insert one char from stringstream
  public void Insert(char ch) {
    if (map.containsKey(ch)) {
      map.put(ch, map.get(ch) + 1);
    } else {
      map.put(ch, 1);
    }
  }

  //return the first appearence once char in current stringstream
  public char FirstAppearingOnce() {
    char res = '#';
    for (Entry<Character, Integer> entry : map.entrySet()) {
      if (entry.getValue() == 1) {
        res = entry.getKey();
        return res;
      }
    }
    return res;
  }

}
