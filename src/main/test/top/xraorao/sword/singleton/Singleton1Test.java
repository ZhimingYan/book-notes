package top.xraorao.sword.singleton;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Singleton1 Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>03/17/2018</pre>
 */
public class Singleton1Test {

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
    Singleton1 singleton1 = Singleton1.getInstance();
    Singleton1 singleton11 = Singleton1.getInstance();
    Assert.assertNotEquals(singleton1, null);
    Assert.assertEquals(singleton1, singleton11);
  }


} 
