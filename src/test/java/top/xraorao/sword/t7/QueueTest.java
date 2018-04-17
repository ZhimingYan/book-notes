package top.xraorao.sword.t7;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Queue Tester.
 *
 * @author Xiong Raorao <xiongraorao@gmail.com>
 * @version 1.0
 * @since <pre>03/30/2018</pre>
 */
public class QueueTest {

  private Queue queue;


  @Before
  public void before() throws Exception {
    System.out.println("before test!");
    queue = new Queue();
    queue.push(1);
    queue.push(2);
    queue.push(3);
  }

  @After
  public void after() throws Exception {
  }

  /**
   * Method: push(int node)
   */
  @Test
  public void testPush() throws Exception {
    queue.push(4);
    Assert.assertEquals(queue.pop(), 1);
    Assert.assertEquals(queue.pop(), 2);
    Assert.assertEquals(queue.pop(), 3);
    Assert.assertEquals(queue.pop(), 4);
  }

  /**
   * Method: pop()
   */
  @Test
  public void testPop() throws Exception {
    Assert.assertEquals(queue.pop(), 1);
    Assert.assertEquals(queue.pop(), 2);
    Assert.assertEquals(queue.pop(), 3);
  }


} 
