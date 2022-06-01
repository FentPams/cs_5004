/**
 * Lab04 -- LinkedList
 * Programmer: Xinyi Feng
 * Date: 31 May, 2022
 */

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class IListOfIntsTest {

  IListOfInts emptyListOfInts, listOfInts;

  /**
   * set up two lists of nodes one is empty one is a list with int 1, 2, 3, 4, 5
   */
  @Before
  public void setup() {
    emptyListOfInts = new EmptyNode();

    listOfInts = new ElementNode(1, new ElementNode(2, new ElementNode(3,
        new ElementNode(4, new ElementNode(5, new EmptyNode())))));
  }

  /**
   * test two lists of nodes are successfully created one is empty, one is a list with int 1, 2, 3,
   * 4, 5 use toString to check it
   */
  @Test
  public void testListInts() {
    // tests list in elementnode
    assertEquals("(1)(2)(3)(4)(5)", listOfInts.toString());
    //test list in empty node
    assertEquals("", emptyListOfInts.toString());
  }

  /**
   * test adding int at a given index in two lists of nodes one is empty, one is a list with int 1,
   * 2, 3, 4, 5 use toString to check it
   */
  @Test
  public void testAddAtIndex() {
    // tests add int in elementnode
    assertEquals("(0)(1)(2)(3)(4)(5)", listOfInts.addAtIndex(0, 0).toString());
    // tests add int in empty node
    assertEquals("(1)", emptyListOfInts.addAtIndex(0, 1).toString());
  }

  /**
   * test adding int at front in two lists of nodes one is empty, one is a list with int 1, 2, 3, 4,
   * 5 use toString to check it
   */
  @Test
  public void testAddFront() {
    // tests add int in elementnode
    assertEquals("(-1)(1)(2)(3)(4)(5)", listOfInts.addFront(-1).toString());
    // tests add int in empty node
    assertEquals("(-1)", emptyListOfInts.addFront(-1).toString());
  }

  /**
   * test adding int at back in two lists of nodes one is empty, one is a list with int 1, 2, 3, 4,
   * 5 use toString to check it
   */
  @Test
  public void testAddBack() {
    // tests add int in elementnode
    assertEquals("(1)(2)(3)(4)(5)(6)", listOfInts.addBack(6).toString());
    // tests add int in empty node
    assertEquals("(6)", emptyListOfInts.addBack(6).toString());
  }

  /**
   * test get index of data in two lists of nodes one is empty, one is a list with int 1, 2, 3, 4, 5
   * it will throw exception when get index in empty node
   */
  @Test(expected = IllegalArgumentException.class)
  public void testGetDataAtIndex() {
    // tests get data in elementnode
    assertEquals(3, listOfInts.getDataAtIndex(2));
    //tests get data in emptynode will throw exception
    assertEquals(3, emptyListOfInts.getDataAtIndex(2));
  }

  /**
   * test count of data in two lists of nodes one is empty, one is a list with int 1, 2, 3, 4, 5
   */
  @Test
  public void testCount() {
    // tests data count in elementnode
    assertEquals(5, listOfInts.count());
    // tests data count in empty node
    assertEquals(0, emptyListOfInts.count());
  }

  /**
   * test sum of data in two lists of nodes one is empty, one is a list with int 1, 2, 3, 4, 5
   */
  @Test
  public void testSum() {
    // tests data sum in elementnode
    assertEquals(15, listOfInts.sum());
    // tests data sum in emptynode
    assertEquals(0, emptyListOfInts.sum());
  }
}
