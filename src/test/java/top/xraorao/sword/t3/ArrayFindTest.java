package top.xraorao.sword.t3;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Categories.IncludeCategory;

/**
 * ArrayFind Tester.
 *
 * @author Xiong Raorao <xiongraorao@gmail.com>
 * @version 1.0
 * @since <pre>03/20/2018</pre>
 */
public class ArrayFindTest {

  int[][] matrix = new int[][] {
      {1, 2, 8, 9},
      {2, 4, 9, 12},
      {4, 7, 10, 13},
      {6, 8, 11, 15}};

  int[][] nullMatrix = new int[][] {};

  @Before
  public void before() throws Exception {
    System.out.println("before");
  }

  @After
  public void after() throws Exception {
    System.out.println("after");
  }

  /**
   * Method: find2(int[][] matrix, int rows, int columns, int number)
   */
  @Test
  public void testFind2() throws Exception {
    Assert.assertEquals("find2 test: ", ArrayFind.find2(matrix, 7), true);
    Assert.assertEquals("find2 test: ", ArrayFind.find2(matrix, 3), false);
    Assert.assertEquals("find2 test: ", ArrayFind.find2(nullMatrix, 3), false);
    Assert.assertEquals("find2 test: ", ArrayFind.find2(null, 3), false);
  }

  /**
   * Method: find1(int[][] matrix, int rows, int columns, int number)
   */
  @Test
  public void testFind1() throws Exception {
    Assert.assertEquals("find1 test: ", ArrayFind.find1(matrix, 7), true);
    Assert.assertEquals("find1 test: ", ArrayFind.find1(matrix, 3), false);
    Assert.assertEquals("find1 test: ", ArrayFind.find1(nullMatrix, 3), false);
    Assert.assertEquals("find2 test: ", ArrayFind.find1(null, 3), false);
  }


} 
