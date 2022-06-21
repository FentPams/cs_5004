import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class PolynomialTest {

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
    assertEquals("p(x) = 0",c1.toString());

    //test three objects constructed by argument
    assertEquals("p(x) = 2.5x^2 + x + 3.5", q2.toString());
    assertEquals("p(x) = -2.5x", l2.toString());
    assertEquals("p(x) = 6.6",c2.toString());
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
    assertEquals(1.0, q1.getLeadingCoefficient(),0.01);
    assertEquals(1.0, l1.getLeadingCoefficient(),0.01);
    assertEquals(0, c1.getLeadingCoefficient(),0.01);

    //test three objects constructed by argument
    assertEquals(2.5, q2.getLeadingCoefficient(),0.01);
    assertEquals(-2.5,l2.getLeadingCoefficient(),0.01);
    assertEquals(6.6, c2.getLeadingCoefficient(),0.01);
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
    assertEquals(1.0, q1.evaluateAt(1),0.01);
    assertEquals(1.0, l1.getLeadingCoefficient(),0.01);
    assertEquals(0, c1.getLeadingCoefficient(),0.01);

  }

  @Test
  public void testGetYIntercept() {
  }

  @Test
  public void testIsRoot() {
  }

  @Test
  public void testIsEqualTo() {
  }

  @Test
  public void testPlus() {
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

    assertEquals("p(x) = 3x^2 - 28x + 69", q2.translate(5, 3).toString());
    assertEquals("p(x) = -2.5x + 5", l2.translate(2, 1).toString());
    assertEquals("p(x) = -3.6", c2.translate(2, -10.2).toString());

  }

  @Test
  public void testMultiply() {
  }
}
