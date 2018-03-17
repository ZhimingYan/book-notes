package top.xraorao.sword.singleton;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * Singleton2 Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>03/17/2018</pre>
 */
public class Singleton2Test {

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
    Singleton2 singleton2 = Singleton2.getInstance();
    Singleton2 singleton21 = Singleton2.getInstance();
    Assert.assertNotEquals(singleton2, null);
    Assert.assertEquals(singleton2, singleton21);
  }


} 
