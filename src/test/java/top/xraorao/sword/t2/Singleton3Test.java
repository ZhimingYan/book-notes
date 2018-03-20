/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Singleton3Test.java
 * Date: 18-3-18 下午11:14
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t2;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Singleton3 Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>03/17/2018</pre>
 */
public class Singleton3Test {

  @Before
  public void before() throws Exception {
  }

  @After
  public void after() throws Exception {
  }

  /**
   * Method: getInstance()
   */
  @Test
  public void testGetInstance() throws Exception {
    Singleton3 singleton3 = Singleton3.getInstance();
    Singleton3 singleton31 = Singleton3.getInstance();
    Assert.assertNotEquals(singleton3, null);
    Assert.assertEquals(singleton3, singleton31);
  }


} 
