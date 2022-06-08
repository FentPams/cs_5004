
/**
 * Programmer: Xinyi Feng
 * LAB05--Polynomials
 * Date: June 7th, 2022
 * This interface represents the
 * Polynomial ADT
 */
public interface Polynomial {

  /**
   * Gets the degree of polynomial
   *
   * @return the degree of this polynomial
   */
  int getDegree();

  /**
   * Gets the coefficient of polynomial
   *
   * @param power the power of term
   * @return the coefficient for the term with that power of this polynomial
   */
  double getCoefficient(int power);

  /**
   * Get string format
   *
   * @return string representation of the polynomial
   */
  String getString();

  /**
   * Gets the leading coefficient
   *
   * @return the leading coefficient for the term with that power of this polynomial
   */
  double getLeadingCoefficient();

  /**
   * Calculate the result of polynomial with number passed in
   *
   * @param number double number that passed in
   * @return double that evaluate the polynomial at the number
   */
  double evaluateAt(double number);

  /**
   * Gets the Y intercept
   *
   * @return the polynomial evaluated at 0
   */
  double getYIntercept();

  /**
   * Determine if it is a root True iff the polynomial evaluates to 0 at that number
   *
   * @param number checks iff the polynomial evaluates to 0 at this number
   * @return boolean
   */
  boolean isRoot(double number);

  /**
   * Determine if they are the same class and are equivalent True iff they are the same class and
   * are equivalent
   *
   * @return boolean
   */
  boolean isEqualTo(Polynomial other);

  /**
   * Adds two polynomials
   *
   * @param other polynomial
   * @return Polynomial  obtained by adding two polynomials
   * @throws IllegalArgumentException if assumption is violated
   */
  Polynomial plus(Polynomial other) throws IllegalArgumentException;

}
