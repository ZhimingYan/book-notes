/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: RegExTest.java
 * Date: 18-7-20 下午12:03
 * Author: Xiong Raorao
 */

package top.xraorao.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式测试.
 *
 * @author Xiong Raorao
 * @since 2018-07-20-12:03
 */
public class RegExTest {

  public static void main(String[] args) {
    // 要验证的字符串
    String str = "service@xsoftlab.net";
    // 邮箱验证规则
    String regEx = "[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}";
    // 编译正则表达式
    Pattern pattern = Pattern.compile(regEx);
    // 忽略大小写的写法
    // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
    Matcher matcher = pattern.matcher(str);
    // 字符串是否与正则表达式相匹配
    boolean rs = matcher.matches();
    System.out.println(rs);
    if (rs) {
      System.out.println(matcher.group(1));
    }
  }


}
