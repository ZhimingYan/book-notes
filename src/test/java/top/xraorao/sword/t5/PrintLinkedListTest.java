package top.xraorao.sword.t5;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * PrintLinkedList Tester.
 *
 * @author Xiong Raorao <xiongraorao@gmail.com>
 * @version 1.0
 * @since <pre>03/24/2018</pre>
 */
public class PrintLinkedListTest {

  private static LinkedList<Integer> linkedList;

  @BeforeClass
  public static void before() throws Exception {
    System.out.println("before class");
    linkedList = new LinkedList<>();
    linkedList.addTail(0);
    linkedList.addTail(1);
    linkedList.addTail(2);
  }

  @AfterClass
  public static void after() throws Exception {
  }


  /**
   * Method: printList(ListNode<Integer> list)
   */
  @Test
  public void testPrintList() throws Exception {
    System.out.println("test for printList: ");
    ArrayList<Integer> result = PrintLinkedList.printList(linkedList.getHead());
    Assert.assertEquals(result, Arrays.asList(2, 1, 0));
  }

  /**
   * Method: printList2(ListNode<Integer> list)
   */
  @Test
  public void testPrintList2() throws Exception {
    System.out.println("test for printList2: ");
    ArrayList<Integer> result = PrintLinkedList.printList2(linkedList.getHead());
    Assert.assertEquals(result, Arrays.asList(2, 1, 0));
  }

  /**
   * Method: printList3(ListNode<Integer> list)
   */
  @Test
  public void testPrintList3() throws Exception {
    System.out.println("test for printList3: ");
    ArrayList<Integer> result = PrintLinkedList.printList3(linkedList.getHead());
    Assert.assertEquals(result, Arrays.asList(2, 1, 0));
  }

} 
