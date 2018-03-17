package top.xraorao.sword.singleton;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

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
