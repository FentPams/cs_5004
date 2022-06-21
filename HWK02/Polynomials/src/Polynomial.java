/**
 * Programmer: Xinyi Feng
 * HWK02--Polynomials
 * Date: June 20 th, 2022
 * This interface represents all the
 * Polynomial methods
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
   * @throws IllegalArgumentException if the power doesn't exist in the polynomials
   */
  double getCoefficient(int power)throws IllegalArgumentException;

  /**
   * Get string format
   *
   * @return string representation of the polynomial
   * Display one decimal place. Not include terms with coefficient of 0
   * unless there are no other terms, and the term if coefficient is 1
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

  /**
   * translate to new polynomials by passing in two double parameters
   *
   * @param dx,dy two double
   * @return Polynomial r such that r(x) = p(x - dx) + dy
   * @throws IllegalArgumentException if assumption is violated
   */
  Polynomial translate(double dx, double dy) throws IllegalArgumentException;

  /**
   * Multiply two polynomials and returning a new polynomial without mutation
   *
   * @param other, a polynomial with degree 0 or 1 only
   * @return Polynomial without mutation
   * @throws IllegalArgumentException if two polynomials' degree are not 0 or 1
   */
  Polynomial multiply(Polynomial other) throws IllegalArgumentException;


}

