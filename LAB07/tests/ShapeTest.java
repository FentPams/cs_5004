/**
 * Programmer: Xinyi Feng
 * LAB 07 -- Triangle
 * Date : 22, June, 2022
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This class contains all the unit tests for various kinds of shapes
 */
public class ShapeTest {

  Shape circle1, circle2, circle3, rect1, rect2, tri1, tri2, tri3;
  Point2D point1, point2, point3;

  @Before
  public void setup() {
    circle1 = new Circle(3, 4, 5);
    circle2 = new Circle(10.32, 10.43, 10);
    circle3 = new Circle(20);

    rect1 = new Rectangle(5, 6, 2.5, 2);
    rect2 = new Rectangle(2, 3, 10, 10);

    point1 = new Point2D(0, 0);
    point2 = new Point2D(3, 0);
    point3 = new Point2D(0, 4);
    tri1 = new Triangle(2, 3, 4, 5, 6, 7);
    tri2 = new Triangle(point1, point2, point3);
    tri3 = new Triangle(1, 2, 2, 1, 3, 3);

  }


  /**
   * Tests whether objects have been created with the correct numbers or not. It does this by using
   * their toString methods
   */
  @Test
  public void testObjectData() {
    assertEquals("Circle: center (3.000,4.000) radius 5.000", circle1.toString
        ());
    assertEquals("Circle: center (10.320,10.430) radius 10.000", circle2.toString
        ());
    assertEquals("Circle: center (0.000,0.000) radius 20.000", circle3
        .toString
            ());
    assertEquals("Rectangle: LL corner (5.000,6.000) width 2.500 height 2.000",
        rect1.toString());
    assertEquals("Rectangle: LL corner (2.000,3.000) width 10.000 height 10" +
        ".000", rect2
        .toString());
    assertEquals(
        "Triangle: Reference point:(2.000,3.000) Second point:(4.000,5.000) Third point:(6.000,7.000)",
        tri1.toString());
    assertEquals(
        "Triangle: Reference point:(0.000,0.000) Second point:(3.000,0.000) Third point:(0.000,4.000)",
        tri2.toString());
    assertEquals(
        "Triangle: Reference point:(1.000,2.000) Second point:(2.000,1.000) Third point:(3.000,3.000)",
        tri3.toString());
  }

  /**
   * Tests the triangle created with unique points throw exception
   */
  @Test(expected = IllegalArgumentException.class)
  public void testTriangleFailed() {
    Triangle failedTri;
    Point2D sameOne = new Point2D(1, 1);
    Point2D sameTwo = new Point2D(1, 1);
    Point2D sameThree = new Point2D(1, 1);

    failedTri = new Triangle(sameOne, sameTwo, sameThree);
  }


  /**
   * Tests whether the area methods work correctly for all shapes
   */
  @Test
  public void testArea() {
    assertEquals(Math.PI * 25, circle1.area(), 0.001);
    assertEquals(Math.PI * 100, circle2.area(), 0.001);
    assertEquals(Math.PI * 400, circle3.area(), 0.001);
    assertEquals(5, rect1.area(), 0.001);
    assertEquals(100, rect2.area(), 0.001);
    assertEquals(0.0, tri1.area(), 0.001);//colinear triangle
    assertEquals(6.0, tri2.area(), 0.001);
    assertEquals(1.5, tri3.area(), 0.001);
  }

  /**
   * Tests whether the perimeter methods work correctly for all shapes
   */
  @Test
  public void testPerimeter() {
    assertEquals(2 * Math.PI * 5, circle1.perimeter(), 0.001);
    assertEquals(2 * Math.PI * 10, circle2.perimeter(), 0.001);
    assertEquals(2 * Math.PI * 20, circle3.perimeter(), 0.001);
    assertEquals(9, rect1.perimeter(), 0.001);
    assertEquals(40, rect2.perimeter(), 0.001);
    assertEquals(11.313, tri1.perimeter(), 0.001);
    assertEquals(12.0, tri2.perimeter(), 0.001);
    assertEquals(5.886, tri3.perimeter(), 0.001);

  }

  /**
   * Tests whether the resize methods work correctly for all shapes
   */

  @Test
  public void testResizes() {
    Shape resizedCircle1, resizedCircle2, resizedCircle3, resizedRect1,
        resizedRect2, resizedTri1, resizedTri2, resizedTri3;

    resizedCircle1 = circle1.resize(2.5);
    resizedCircle2 = circle2.resize(0);
    resizedCircle3 = circle3.resize(10);
    resizedRect1 = rect1.resize(12.5);
    resizedRect2 = rect2.resize(0.001);
    resizedTri1 = tri1.resize(0.5);
    resizedTri2 = tri2.resize(2);
    resizedTri3 = tri3.resize(5);

    assertEquals(2.5 * circle1.area(), resizedCircle1.area(), 0.001);
    assertEquals(0 * circle2.area(), resizedCircle2.area(), 0.001);
    assertEquals(10 * circle3.area(), resizedCircle3.area(), 0.001);
    assertEquals(12.5 * rect1.area(), resizedRect1.area(), 0.001);
    assertEquals(0.001 * rect2.area(), resizedRect2.area(), 0.001);
    assertEquals(0.5 * tri1.area(), resizedTri1.area(), 0.001);
    assertEquals(2 * tri2.area(), resizedTri2.area(), 0.001);
    assertEquals(5 * tri3.area(), resizedTri3.area(), 0.001);

  }

  /**
   * Tests the resize method will throw illegal argument exception
   * When Factor is less than zero, will throw exception
   */
  @Test(expected = IllegalArgumentException.class)
  public void testResizesIllegalFactor() {
    Shape resizedCircle1, resizedRect1, resizedTri1;

    resizedCircle1 = circle1.resize(-2.5); //negative factor

    resizedRect1 = rect1.resize(-12.5);

    resizedTri1 = tri1.resize(-0.5);


  }

  /**
   * test compare to method in Abstract class compare perimeter return negative if is less than
   * return 0 if equal return positive if is larger
   */
  @Test
  public void testCompareTo() {
    Triangle tri4SameTri2 = new Triangle(0, 0, 3, 0, 0, 4); // same as tri2
    // test compare triangle
    assertEquals(-1, tri1.compareTo(tri2));
    assertEquals(0, tri2.compareTo(tri4SameTri2));
    assertEquals(1, tri2.compareTo(tri3));

    // test rectangle compare
    assertEquals(-1, rect1.compareTo(rect2));

    // test circle compare
    assertEquals(-1, circle1.compareTo(circle2));
    assertEquals(-1, circle2.compareTo(circle3));
    assertEquals(-1, circle1.compareTo(circle3));

    // test compare different objects
    assertEquals(-1, tri1.compareTo(circle1));
    assertEquals(1, tri1.compareTo(rect1));
    assertEquals(-1, rect1.compareTo(circle1));
  }

  /**
   * test compare method in DisComparator class compare distance to origin return negative if is
   * less than return 0 if equal return positive if is larger
   * <p>
   * Compare the ordering of the array sorted by comparator and the array sorted manually The two
   * lists should be in same order(according to the distance to origin)
   */
  @Test
  public void testCompareInDisComparator() {
    // add objects unsorted in the list
    List<Shape> shapeLisSortByComparator = new ArrayList<>();
    shapeLisSortByComparator.add(circle1);
    shapeLisSortByComparator.add(circle2);
    shapeLisSortByComparator.add(circle3);
    shapeLisSortByComparator.add(rect1);
    shapeLisSortByComparator.add(rect2);
    shapeLisSortByComparator.add(tri1);
    shapeLisSortByComparator.add(tri2);
    shapeLisSortByComparator.add(tri3);
    // sort arraylist by comparator
    Collections.sort(shapeLisSortByComparator, new DistComparator());

    // sort array manually
    List<Shape> shapeLisSorted = new ArrayList<>(
        List.of(circle3, tri2, tri3, rect2, tri1, circle1, rect1, circle2));

    // compare two arrays
    assertArrayEquals(shapeLisSorted.toArray(), shapeLisSortByComparator.toArray());
  }

  /**
   * Tests Point2D get x  method
   */
  @Test
  public void testPoint2DGetX() {
    Point2D p1 = new Point2D(1,2);
    Point2D p2 = new Point2D(0, 0);

    assertEquals(1, p1.getX(),0.01);
    assertEquals(0, p2.getX(),0.01);
  }
  /**
   * Tests Point2D get y  method
   */
  @Test
  public void testPoint2DGetY() {
    Point2D p1 = new Point2D(1,2);
    Point2D p2 = new Point2D(0, 0);

    assertEquals(2, p1.getY(),0.01);
    assertEquals(0, p2.getY(),0.01);
  }
  /**
   * Tests Point2D class
   * test distToOrigin method
   * return the distance of two points
   */
  @Test
  public void testPoint2DDistToOrigin() {
    Point2D p1 = new Point2D(1,2);
    Point2D p2 = new Point2D(0, 0);

    assertEquals(2.236, p1.distToOrigin(),0.01);
    assertEquals(0, p2.distToOrigin(),0.01);
  }

}