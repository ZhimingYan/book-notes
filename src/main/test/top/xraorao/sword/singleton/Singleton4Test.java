package top.xraorao.sword.singleton;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * Singleton4 Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>03/17/2018</pre>
 */
public class Singleton4Test {

  @Before
  public void before() throws Exception {
  }

  @After
  public void after() throws Exception {
  }

  /**
   * Method: getInstance()
   */
  @Test()
  public void testGetInstance() throws Exception {
    Singleton4 singleton4 = Singleton4.getInstance();
    Singleton4 singleton41 = Singleton4.getInstance();
    Assert.assertNotEquals(singleton4, null);
    Assert.assertEquals(singleton4, singleton41);

  }


} 
