/**
 * Programmer: Xinyi Feng
 * HWK02--Polynomials
 * Date: June 20 th, 2022
 * This Constant class implement Polynomial interface, for degree 0
 * f(x) =  c
 *
 */

public class Constant implements Polynomial {

  private final double coefficient;


  public Constant() {
    this.coefficient = 0;
  }

  public Constant(double coefficient) {
    this.coefficient = coefficient;
  }

  /**
   * Gets the degree of polynomial
   *
   * @return the degree of this polynomial
   */
  @Override
  public int getDegree() {
    return 0;
  }

  /**
   * Gets the coefficient of polynomial
   *
   * @param power the power of term
   * @return the coefficient for the term with that power of this polynomial
   */
  @Override
  public double getCoefficient(int power) throws IllegalArgumentException {
    if (power == 0) {
      return this.coefficient;
    }
    throw new IllegalArgumentException("Invalid power");
  }

  /**
   * Get string format
   *
   * @return string representation of the polynomial
   */
  @Override
  public String getString() {
    if (this.coefficient == 0) {
      return "p(x) = 0";
    } else {
      return String.format("p(x) = %s", format(this.coefficient));
    }
  }

  /**
   * Gets the leading coefficient
   *
   * @return the leading coefficient for the term of this polynomial
   */
  @Override
  public double getLeadingCoefficient() {
    return this.coefficient;
  }

  /**
   * Calculate the result of polynomial with number passed in
   *
   * @param number double number that passed in
   * @return double that evaluate the polynomial at the number
   */
  @Override
  public double evaluateAt(double number) {
    return this.coefficient;
  }

  /**
   * Gets the Y intercept
   *
   * @return the coefficient
   */
  @Override
  public double getYIntercept() {
    return this.coefficient;
  }

  /**
   * Determine if it is a root True iff the polynomial evaluates to 0 at that number
   *
   * @param number checks iff the polynomial evaluates to 0 at this number
   * @return if coefficient is zero, then it is root, otherwise, it is not
   */
  @Override
  public boolean isRoot(double number) {
    return this.coefficient == 0;
  }

  /**
   * Determine if they are the same class and are equivalent True iff they are the same class and
   * are equivalent
   *
   * @return boolean
   */
  @Override
  public boolean isEqualTo(Polynomial other) {
    return other.getDegree() == 0 && this.coefficient == other.getCoefficient(0);

  }

  /**
   * Adds two polynomials
   *
   * @param other polynomial
   * @return new constant/line/quadratic obtained by adding two polynomials
   * @throws IllegalArgumentException if assumption is violated
   */
  @Override
  public Polynomial plus(Polynomial other) throws IllegalArgumentException {
    return switch (other.getDegree()) {
      //constant plus constant
      case 0 -> new Constant(this.coefficient + other.getCoefficient(0));
      //constant plus line
      case 1 -> new Line(other.getCoefficient(1), this.coefficient + other.getCoefficient(0));
      //constant plus quadratic
      case 2 -> new Quadratic(other.getCoefficient(2), other.getCoefficient(1),
          this.coefficient + other.getCoefficient(0));
      //neither constant, line nor quadratic
      default -> throw new IllegalArgumentException("Violated the assumption");
    };
  }

  /**
   * translate to new polynomials by passing in two double parameters
   *
   * @param dx
   * @param dy
   * @return Polynomial r such that r(x) = p(x - dx) + dy
   * @throws IllegalArgumentException if assumption is violated
   */
  @Override
  public Polynomial translate(double dx, double dy) throws IllegalArgumentException {
    return new Constant(this.coefficient + dy);
  }

  /**
   * Multiply two polynomials and returning a new polynomial without mutation
   *
   * @param other polynomial
   * @return Polynomial without mutation
   * @throws IllegalArgumentException if two polynomials' degree are not 0 or 1 or 2
   */
  @Override
  public Polynomial multiply(Polynomial other) throws IllegalArgumentException {
    return switch (other.getDegree()) {
      //constant multiplies constant
      case 0 -> new Constant(this.coefficient * other.getCoefficient(0));
      //constant multiplies line
      case 1 -> new Line(other.getCoefficient(1) * this.coefficient,
          this.coefficient * other.getCoefficient(0));
      //constant multiplies quadratic
      case 2 -> new Quadratic(other.getCoefficient(2) * this.coefficient,
          other.getCoefficient(1) * this.coefficient,
          this.coefficient * other.getCoefficient(0));
      //neither constant, line nor quadratic
      default -> throw new IllegalArgumentException("Violated the assumption");
    };
  }

  /**
   * ToString method
   *
   * @return The string represents polynomial
   */
  @Override
  public String toString() {
    return getString();
  }
  /**
   * format string if double with integer value or keep one digit after point
   *  e.g.  "1.0" will return "1" instead
   *  "6.66" will return "6.7"
   * @param d double
   * @return string
   */
  private String format(double d) {
    return d % 1 == 0 ? String.valueOf((int)d) : String.format("%.1f", d);
  }
}
