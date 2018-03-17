package top.xraorao.sword.singleton;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

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
