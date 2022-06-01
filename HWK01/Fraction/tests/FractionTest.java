/**
 * Programmer: Xinyi Feng
 * CS5004 HWK1-Fraction
 * 31 May, 2022
 * This FractionTest tests all the methods in Fraction class
 */

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FractionTest {

  Fraction fraction1, fraction2, fraction3;

  @Before
  public void setUp() throws Exception {

    fraction1 = new Fraction(4, 8); // unsimplified
    fraction2 = new Fraction(3, 5); // simplified
    fraction3 = new Fraction(0, 2); // zero fraction
  }

  /**
   * Tests whether fraction can be set when its numerator is passed in as 0
   * should throw exception
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructor() {
    Fraction fraction4 = new Fraction(5, 0);
  }

  /**
   * Tests whether fraction with same value of numerator and denominator passed can be set
   * should be set successfully
   */
  @Test
  public void testTwoSameValueConstructor() {
    Fraction fraction5 = new Fraction(6, 11);
    Fraction fraction6 = new Fraction(6, 11); // same value two objects
    assertNotEquals(fraction5, fraction6);
  }

  /**
   * Tests whether fraction's numerator can be set successfully It does this by using their toString
   * methods
   */
  @Test()
  public void testSetNumerator() {

    fraction1.setNumerator(6); // set to unsimplified fraction
    fraction2.setNumerator(0); // set to zero fraction
    fraction3.setNumerator(-1); // set to negative fraction

    assertEquals("Fraction numerator:6, denominator:8. Value after simplification is: 3 / 4 ",
        fraction1.toString());
    assertEquals("Fraction numerator:0, denominator:5. Value after simplification is: 0 ",
        fraction2.toString());
    assertEquals("Fraction numerator:-1, denominator:2. Value after simplification is: -1 / 2 ",
        fraction3.toString());
  }

  /**
   * Tests whether invalid fraction's denominator can throw exception successfully denominator
   * should not be zero
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetZeroDenominator() {
    fraction1.setDenominator(0); // can't be zero
  }

  /**
   * Tests whether invalid fraction's denominator can throw exception successfully
   * Denominator cannot be negative
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetNegativeDenominator() {
    fraction2.setDenominator(-1); // can't be negative
  }

  /**
   * Tests whether positive fraction's denominator can be set successfully use to string to test
   */
  @Test
  public void testSetPositiveDenominator() {

    fraction3.setDenominator(3);
    assertEquals("Fraction numerator:0, denominator:3. Value after simplification is: 0 ",
        fraction3.toString());
  }

  /**
   * Tests whether fraction's denominator can be got successfully
   */
  @Test
  public void testGetDenominator() {

    assertEquals(8, fraction1.getDenominator()); // fraction1： denominator 8
    assertEquals(5, fraction2.getDenominator()); // fraction2： denominator 5
    assertEquals(2, fraction3.getDenominator()); // fraction3： denominator 2

  }

  /**
   * Tests whether fraction's numerator can be got successfully
   */
  @Test
  public void testGetNumerator() {

    assertEquals(4, fraction1.getNumerator()); // fraction1: numerator 4
    assertEquals(3, fraction2.getNumerator()); // fraction2: numerator 3
    assertEquals(0, fraction3.getNumerator()); // fraction3: numerator 0
  }

  /**
   * Tests whether fraction can be converted to double(decimal number) successfully
   */
  @Test
  public void testToDouble() {

    assertEquals(0.5, fraction1.toDouble(), 0.001); // fraction 1 : 4/8
    assertEquals(0.6, fraction2.toDouble(), 0.001); // fraction 2 : 3/5
    assertEquals(0, fraction3.toDouble(), 0.001); // fraction 3 : 0/2
  }

  /**
   * Tests whether fraction can be converted to reciprocal successfully
   * In the case that numerator and denominator are valid 
   */
  @Test
  public void testReciprocal() {

    assertEquals(new Fraction(8, 4).toString(), fraction1.reciprocal().toString()); // fraction 1 : 4/8
    assertEquals(new Fraction(5, 3).toString(), fraction2.reciprocal().toString()); // fraction 2 : 3/5
  }

  /**
   * Tests whether an invalid denominator fraction can throw exception 
   * When numerator is zero(or negative) before, it can't be new denominator
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidReciprocal() {

    assertEquals(new Fraction(2, 0), fraction1.reciprocal()); // fraction 3 : 0/2
  }

  /**
   * Tests whether two fraction can be added and yield result successfully in simplification
   * fraction1 :4/8 fraction2: 3/5 fraction3: 0/2
   */
  @Test
  public void testAdd() {

    assertEquals(new Fraction(11, 10).toString(), fraction1.add(fraction2).toString());
    assertEquals(new Fraction(1, 2).toString(), fraction1.add(fraction3).toString());
    assertEquals(new Fraction(3, 5).toString(), fraction2.add(fraction3).toString());
  }

  /**
   * Tests whether two fraction can be compared successfully
   * fraction1 :4/8 fraction2: 3/5 fraction3: 0/2
   */
  @Test
  public void testCompareTo() {
    
    assertEquals(0, fraction1.compareTo(new Fraction(1, 2)));
    assertEquals(-1, fraction1.compareTo(new Fraction(5, 8)));
    assertEquals(1, fraction1.compareTo(new Fraction(3, 8)));
  }

  /**
   * Tests whether toString works successfully for fractions
   */
  @Test
  public void testToString() {

    assertEquals("Fraction numerator:4, denominator:8. Value after simplification is: 1 / 2 ",
        fraction1.toString());
    assertEquals("Fraction numerator:3, denominator:5. Value after simplification is: 3 / 5 ",
        fraction2.toString());
    assertEquals("Fraction numerator:0, denominator:2. Value after simplification is: 0 ",
        fraction3.toString());
  }
}
