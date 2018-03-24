/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: ReplaceBlankTest.java
 * Date: 18-3-24 上午11:10
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t4;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * ReplaceBlank Tester.
 *
 * @author Xiong Raorao <xiongraorao@gmail.com>
 * @version 1.0
 * @since <pre>03/23/2018</pre>
 */
public class ReplaceBlankTest {

  @Before
  public void before() throws Exception {
  }

  @After
  public void after() throws Exception {
  }

  /**
   * Method: replace(StringBuffer sb)
   */
  @Test
  public void testReplace() throws Exception {
    StringBuffer sb = new StringBuffer("we are happy");
    StringBuffer nullString = new StringBuffer("");
    Assert.assertEquals(ReplaceBlank.replace(sb), "we%20are%20happy");
    Assert.assertEquals(ReplaceBlank.replace(nullString), "");
    Assert.assertEquals(ReplaceBlank.replace(null), null);
  }


} 
