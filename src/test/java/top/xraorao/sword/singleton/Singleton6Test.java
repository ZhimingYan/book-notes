/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Singleton6Test.java
 * Date: 18-3-18 下午11:14
 * Author: Xiong Raorao
 */

package top.xraorao.sword.singleton;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import top.xraorao.sword.singleton.Singleton6;

/**
 * Singleton6 Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>03/17/2018</pre>
 */
public class Singleton6Test {

  @Before
  public void before() throws Exception {
  }

  @After
  public void after() throws Exception {
  }

  /**
   * Method: getInstatnce()
   */
  @Test
  public void testGetInstatnce() throws Exception {
    Singleton6 singleton6 = Singleton6.getInstatnce();
    Singleton6 singleton61 = Singleton6.getInstatnce();
    Assert.assertNotEquals(singleton6, null);
    Assert.assertEquals(singleton6, singleton61);
  }


} 
