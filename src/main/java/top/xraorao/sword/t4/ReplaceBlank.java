/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: ReplaceBlank.java
 * Date: 18-3-21 上午8:57
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t4;

/**
 * t4-替换字符串空格.
 *
 * @author Xiong Raorao
 * @since 2018-03-21-8:57
 */
public class ReplaceBlank {

  public static String replace(StringBuffer sb) {
    if (sb == null) {
      return null;
    }
    int oldLength = sb.length();
    for (int i = 0; i < oldLength; i++) {
      if (sb.charAt(i) == ' ') {
        sb.append("  ");
      }
    }
    int newLength = sb.length();
    int oldIndex = oldLength - 1;
    int newIndex = newLength - 1;
    for (; (oldIndex >= 0 && newIndex > oldIndex); oldIndex--) {
      if (sb.charAt(oldIndex) == ' ') {
        sb.setCharAt(newIndex--, '0');
        sb.setCharAt(newIndex--, '2');
        sb.setCharAt(newIndex--, '%');
      } else {
        sb.setCharAt(newIndex--, sb.charAt(oldIndex));
      }
    }
    return sb.toString();
  }
}
