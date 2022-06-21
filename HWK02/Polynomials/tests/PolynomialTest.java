/**
 * Programmer: Xinyi Feng
 * HWK02--Polynomials Date: June 20 th, 2022
 * PolynomialTest, test all the methods of Polynomial interface
 */
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;


public class PolynomialTest {

  @Test
  public void testGetDegree() {
    //Setup three objects constructed by default
    Quadratic q1 = new Quadratic();
    Line l1 = new Line();
    Constant c1 = new Constant();

    assertEquals(2, q1.getDegree());
    assertEquals(1, l1.getDegree());
    assertEquals(0, c1.getDegree());
  }

  @Test
  public void testGetCoefficient() {
    //Setup three objects constructed by default
    Quadratic q1 = new Quadratic();
    Line l1 = new Line();
    Constant c1 = new Constant();

    assertEquals(1, q1.getCoefficient(2), 0.01);
    assertEquals(1, l1.getCoefficient(1), 0.01);
    assertEquals(0, c1.getCoefficient(0), 0.01);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetCoefficient2() {
    //Setup three objects constructed by argument
    Quadratic q2 = new Quadratic(2.5, 1, 3.5);
    Line l2 = new Line(-2.5, 0);
    Constant c2 = new Constant(6.6);

    assertEquals(2.5, q2.getCoefficient(3), 0.01);
    assertEquals(-2.5, l2.getCoefficient(2), 0.01);
    assertEquals(6.6, c2.getCoefficient(1), 0.01);
  }

  @Test
  public void testGetString() {
    //Setup three objects constructed by default
    Quadratic q1 = new Quadratic();
    Line l1 = new Line();
    Constant c1 = new Constant();
    //Setup three objects constructed by argument
    Quadratic q2 = new Quadratic(2.5, 1, 3.5);
    Line l2 = new Line(-2.5, 0);
    Constant c2 = new Constant(6.6);

    //test three objects constructed by default
    assertEquals("p(x) = x^2 + x", q1.toString());
    assertEquals("p(x) = x", l1.toString());
    assertEquals("p(x) = 0", c1.toString());

    //test three objects constructed by argument
    assertEquals("p(x) = 2.5x^2 + x + 3.5", q2.toString());
    assertEquals("p(x) = -2.5x", l2.toString());
    assertEquals("p(x) = 6.6", c2.toString());
  }

  @Test
  public void testGetLeadingCoefficient() {
    //Setup three objects constructed by default
    Quadratic q1 = new Quadratic();
    Line l1 = new Line();
    Constant c1 = new Constant();
    //Setup three objects constructed by argument
    Quadratic q2 = new Quadratic(2.5, 1, 3.5);
    Line l2 = new Line(-2.5, 0);
    Constant c2 = new Constant(6.6);

    //test three objects constructed by default
    assertEquals(1.0, q1.getLeadingCoefficient(), 0.01);
    assertEquals(1.0, l1.getLeadingCoefficient(), 0.01);
    assertEquals(0, c1.getLeadingCoefficient(), 0.01);

    //test three objects constructed by argument
    assertEquals(2.5, q2.getLeadingCoefficient(), 0.01);
    assertEquals(-2.5, l2.getLeadingCoefficient(), 0.01);
    assertEquals(6.6, c2.getLeadingCoefficient(), 0.01);
  }

  @Test
  public void testEvaluateAt() {
    //Setup three objects constructed by default
    // q1 : x^2 + x
    // l1 : x
    // c1 : 0
    Quadratic q1 = new Quadratic();
    Line l1 = new Line();
    Constant c1 = new Constant();
    //Setup three objects constructed by argument
    Quadratic q2 = new Quadratic(2.5, 1, 3.5);
    Line l2 = new Line(-2.5, 0);
    Constant c2 = new Constant(6.6);

    //test three objects constructed by default
    assertEquals(2.0, q1.evaluateAt(1), 0.01);
    assertEquals(1.0, l1.evaluateAt(1), 0.01);
    assertEquals(0, c1.evaluateAt(1), 0.01);

    //test three objects constructed by argument
    assertEquals(0.0, q2.evaluateAt(-1), 0.01);
    assertEquals(3.75, l2.evaluateAt(-1.5), 0.01);
    assertEquals(6.6, c2.evaluateAt(22.2), 0.01); // return coefficient

  }

  @Test
  public void testGetYIntercept() {
    //Setup three objects constructed by default
    Quadratic q1 = new Quadratic();
    Line l1 = new Line();
    Constant c1 = new Constant();

    //Setup three objects constructed by argument
    Quadratic q2 = new Quadratic(3, 2, 1);
    Line l2 = new Line(-2.5, -1); // test negative coefficient
    Constant c2 = new Constant(6.6); // double number

    assertEquals(0.0, q1.getYIntercept(), 0.01);
    assertEquals(0.0, l1.getYIntercept(), 0.01);
    assertEquals(0.0, c1.getYIntercept(), 0.01);

    assertEquals(1.0, q2.getYIntercept(), 0.01);
    assertEquals(-1.0, l2.getYIntercept(), 0.01);
    assertEquals(6.6, c2.getYIntercept(), 0.01);
  }

  @Test
  public void testIsRoot() {
    //Setup three objects constructed by default
    Quadratic q1 = new Quadratic();
    Line l1 = new Line();
    Constant c1 = new Constant();

    //Setup three objects constructed by argument
    Quadratic q2 = new Quadratic(3, 2, 1);
    Line l2 = new Line(-2.5, -1); // test negative coefficient
    Constant c2 = new Constant(6.6); // double number

    assertTrue(q1.isRoot(0));
    assertTrue(c1.isRoot(0));
    assertTrue(l1.isRoot(0));

    assertFalse(q2.isRoot(0));
    assertFalse(l2.isRoot(0));
    assertFalse(c2.isRoot(0));


  }

  @Test
  public void testIsEqualTo() {
    //Setup three objects constructed by argument
    Quadratic q2 = new Quadratic(3, 2, 1);
    Line l2 = new Line(-2.5, -1); // test negative coefficient
    Constant c2 = new Constant(6.6); // double number

    // setup objects same with same attribute and values of above three
    Quadratic q3 = new Quadratic(3, 2, 1);
    Line l3 = new Line(-2.5, -1); // test negative coefficient
    Constant c3 = new Constant(6.6); // double number

    // setup objects same with same attribute but different values of above six
    Quadratic q4 = new Quadratic(1, 1, 1);
    Line l4 = new Line(-1.1, -1.1); // test negative coefficient
    Constant c4 = new Constant(1.1); // double number

    // different objects but same value and class
    assertTrue(q2.isEqualTo(q3));
    assertTrue(l2.isEqualTo(l3));
    assertTrue(c2.isEqualTo(c3));

    // same class type but different value
    assertFalse(q2.isEqualTo(q4));
    assertFalse(l2.isEqualTo(l4));
    assertFalse(c2.isEqualTo(c4));

    // different class type
    assertFalse(q2.isEqualTo(l2));
    assertFalse(l2.isEqualTo(c2));
    assertFalse(c2.isEqualTo(q4));


  }

  @Test
  public void testPlus() {
    //Setup three objects constructed by argument
    Quadratic q2 = new Quadratic(3, 2, 1);
    Line l2 = new Line(-2.5, -1); // test negative coefficient
    Constant c2 = new Constant(6.6); // double number

    // three objects above plus following will give new constant 0
    Quadratic q6 = new Quadratic(-3, -2, -1);
    Line l6 = new Line(2.5, 1); // test negative coefficient
    Constant c6 = new Constant(); // constant 0

    // quadratic q2 plus following will give new line l7
    Quadratic q7 = new Quadratic(-3, 2, -1);
    Line l7 = new Line(4, 0);

    //test three objects constructed by default
    assertEquals("p(x) = 6x^2 + 4x + 2", q2.plus(q2).toString()); // quadratic plus quadratic
    assertEquals("p(x) = 3x^2 - 0.5x", q2.plus(l2).toString()); // quadratic plus line
    assertEquals("p(x) = 3x^2 + 2x + 7.6", q2.plus(c2).toString()); // quadratic plus constant
    assertEquals("p(x) = -5x - 2", l2.plus(l2).toString()); // line plus line
    assertEquals("p(x) = -2.5x + 5.6", l2.plus(c2).toString()); // line plus constant
    assertEquals("p(x) = 13.2", c2.plus(c2).toString()); // constant plus constant

    assertEquals(q2.plus(l2).toString(), l2.plus(q2).toString()); // line plus quadratic
    assertEquals(q2.plus(c2).toString(), c2.plus(q2).toString()); // constant plus quadratic
    assertEquals(l2.plus(c2).toString(), c2.plus(l2).toString()); // constant plus line

    // when line or quadratic plus its inverse, will give constant 0
    assertEquals(c6.toString(), q2.plus(q6).toString());
    assertEquals(c6.toString(), l2.plus(l6).toString());

    assertEquals(l7.toString(), q2.plus(q7).toString());

  }

  // use toString method to test equal
  @Test
  public void testTranslate() {
    //Setup three objects constructed by default
    Quadratic q1 = new Quadratic();
    Line l1 = new Line();
    Constant c1 = new Constant();

    //Setup three objects constructed by argument
    Quadratic q2 = new Quadratic(3, 2, 1);
    Line l2 = new Line(-2.5, -1); // test negative coefficient
    Constant c2 = new Constant(6.6); // double number

    //test three objects constructed by default
    assertEquals("p(x) = x^2 - 3x + 3", q1.translate(2, 1).toString());
    assertEquals("p(x) = x - 1", l1.translate(2, 1).toString());
    assertEquals("p(x) = 1", c1.translate(2, 1).toString());

    //test three objects constructed by argument
    assertEquals("p(x) = 3x^2 - 28x + 69", q2.translate(5, 3).toString());
    assertEquals("p(x) = -2.5x + 5", l2.translate(2, 1).toString());
    assertEquals("p(x) = -3.6", c2.translate(2, -10.2).toString());

  }

  @Test
  public void testMultiply1() {
    //Setup three objects constructed by default
    Quadratic q1 = new Quadratic();
    Line l1 = new Line();
    Constant c1 = new Constant();

    //Setup three objects constructed by argument
    Quadratic q2 = new Quadratic(3, 2, 1);
    Line l2 = new Line(-2.5, -1); // test negative coefficient
    Constant c2 = new Constant(6.6); // double number

    //test three objects constructed by default
    // multiplying a constant 0 gives 0
    assertEquals("p(x) = 0", q1.multiply(c1).toString());
    assertEquals("p(x) = 0", l1.multiply(c1).toString());
    assertEquals("p(x) = 0", c1.multiply(c1).toString());

    // test three objects constructed by argument
    assertEquals("p(x) = 19.8x^2 + 13.2x + 6.6",
        q2.multiply(c2).toString()); //quadratic multiply constant
    assertEquals("p(x) = -16.5x - 6.6", l2.multiply(c2).toString()); //line multiply constant
    assertEquals("p(x) = 6.3x^2 + 5x + 1", l2.multiply(l2).toString()); //line multiply line
    assertEquals("p(x) = 43.6", c2.multiply(c2).toString()); //constant multiply constant

    assertEquals(q2.multiply(c2).toString(), c2.multiply(q2).toString());
    assertEquals(l2.multiply(c2).toString(), c2.multiply(l2).toString());

  }

  @Test(expected = IllegalArgumentException.class)
  public void testMultiply2() {

    //Setup three objects constructed by argument
    Quadratic q2 = new Quadratic(3, 2, 1);
    Line l2 = new Line(-2.5, -1); // test negative coefficient
    Constant c2 = new Constant(6.6); // double number

    q2.multiply(q2); // quadratic can't multiply a quadratic
    q2.multiply(l2); // quadratic can't multiply a line
    l2.multiply(l2); // line can't multiply a line
    l2.multiply(q2); // line can't multiply a line
  }

  @Test

  public void testToString() {
    //Setup three objects constructed by argument
    Quadratic q5 = new Quadratic(10, -8, -2.2); //negative and positive coefficients
    Line l5 = new Line(-66, -11.11); // test negative coefficient
    Constant c5 = new Constant(22.33); // double number

    assertEquals("p(x) = 10x^2 - 8x - 2.2", q5.toString());
    assertEquals("p(x) = -66x - 11.1", l5.toString());
    assertEquals("p(x) = 22.3", c5.toString());

  }
}
