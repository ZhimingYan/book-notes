/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Singleton5Test.java
 * Date: 18-3-18 下午11:14
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t2;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import top.xraorao.sword.t2.Singleton5.SingletonHander;

/**
 * Singleton5 Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>03/17/2018</pre>
 */
public class Singleton5Test {

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
    Singleton5 singleton5 = SingletonHander.INSTANCE.getInstance();
    Singleton5 singleton51 = SingletonHander.INSTANCE.getInstance();
    Assert.assertNotEquals(singleton5, null);
    Assert.assertEquals(singleton5, singleton51);
  }


} 
