/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Ali.java
 * Date: 18-5-7 下午7:26
 * Author: Xiong Raorao
 */

package top.xraorao.interview.tencent;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 智能去重.
 *
 * @author Xiong Raorao
 * @since 2018-05-07-19:26
 */
public class Ali {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    //String input = scan.next();
    String input = "刚才我说了我要退款我要退款";
    char[] chars = input.toCharArray();
    System.out.println("array length: " + chars.length);
    List<Integer> indexes = new ArrayList<>();
    for (int i = 0; i < chars.length; i++) {
      int length = 0;
      for (int j = i + 1; j < chars.length; j++) {
        if (chars[i] == chars[j]) {
          indexes.add(i);
          indexes.add(j);
          while (chars[i++] == chars[j++] && j < chars.length) {
            length++;
          }
          break;
        }
      }
      System.out.println(input.substring(i+1,i+length+1));
    }
    for (int i : indexes) {
      System.out.print(i + "\t");
    }

  }

}
