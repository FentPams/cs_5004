/**
 * Programmer: Xinyi Feng HWK02--Polynomials Date: June 20 th, 2022 This Line class implement
 * Polynomial interface, for degree 1 f(x) = ax + c
 */

public class Line implements Polynomial {

  private final double coefficientDegree1;
  private final double coefficientDegree0;


  public Line(double coefficient1, double coefficient0) {
    this.coefficientDegree1 = coefficient1;
    this.coefficientDegree0 = coefficient0;

  }

  //default constructor
  public Line() {
    this.coefficientDegree1 = 1;
    this.coefficientDegree0 = 0;
  }

  /**
   * Gets the degree of polynomial
   *
   * @return the degree of this polynomial
   */
  @Override
  public int getDegree() {
    return 1;
  }

  /**
   * Gets the coefficient of polynomial
   *
   * @param power the power of term
   * @return the coefficient for the term with that power of this polynomial
   * @throws IllegalArgumentException if the power doesn't exist in the polynomials
   */
  @Override
  public double getCoefficient(int power) throws IllegalArgumentException {
    return switch (power) {
      case 0 -> this.coefficientDegree0;
      case 1 -> this.coefficientDegree1;
      //power is not 0 or 1
      default -> throw new IllegalArgumentException("Invalid Power");
    };
  }

  /**
   * Use string builder to display string combinations
   *
   * @return string representation of the polynomial Display one decimal place. Not include terms
   * with coefficient of 0 unless there are no other terms, and the term if coefficient is 1
   */
  @Override
  public String getString() {
    // use StringBuilder for different string combinations
    StringBuilder sb = new StringBuilder("p(x) = ");
    // if coefficientDegree1 is not 1, it should be displayed
    if (this.coefficientDegree1 != 1) {
      sb.append(this.format(this.coefficientDegree1));
    }
    sb.append("x");
    // if coefficientDegree0 is not 0, it should be displayed
    if (this.coefficientDegree0 != 0) {
      if (this.coefficientDegree0 > 0) {
        sb.append(" + ");
      } else {
        sb.append(" - ");
      }
      sb.append(this.format(Math.abs(this.coefficientDegree0)));
    }
    return sb.toString();
  }

  /**
   * Gets the leading coefficient
   *
   * @return the leading coefficient for the term of this polynomial
   */
  @Override
  public double getLeadingCoefficient() {
    return this.coefficientDegree1;
  }

  /**
   * Calculate the result of polynomial with number passed in
   *
   * @param number double number that passed in
   * @return double that evaluate the polynomial at the number
   */
  @Override
  public double evaluateAt(double number) {
    return this.coefficientDegree1 * number + this.coefficientDegree0;
  }

  /**
   * Gets the Y intercept
   *
   * @return the polynomial evaluated at 0
   */
  @Override
  public double getYIntercept() {
    return this.coefficientDegree0;
  }

  /**
   * Determine if it is a root True iff the polynomial evaluates to 0 at that number
   *
   * @param number checks iff the polynomial evaluates to 0 at this number
   * @return boolean
   */
  @Override
  public boolean isRoot(double number) {
    // when the number passed in render the method evaluate at is 0, it is true.
    return Double.compare(this.evaluateAt(number), 0) == 0;
  }

  /**
   * Determine if they are the same class and are equivalent True iff they are the same class and
   * are equivalent
   *
   * @param other polynomial
   * @return boolean
   */
  @Override
  public boolean isEqualTo(Polynomial other) {
    return other.getDegree() == this.getDegree()
        && other.getCoefficient(1) == this.coefficientDegree1 &&
        other.getCoefficient(0) == this.coefficientDegree0;
  }

  /**
   * Adds two polynomials
   *
   * @param other polynomial
   * @return Polynomial  obtained by adding two polynomials
   * @throws IllegalArgumentException if assumption is violated
   */
  @Override
  public Polynomial plus(Polynomial other) throws IllegalArgumentException {

    if (other.getDegree() > 2 || other.getDegree() < 0) {
      throw new IllegalArgumentException("Violated the assumption");
    }
    // assume the case: f(x) = ax^2 + bx + c
    double a = other.getDegree() == 2 ? other.getCoefficient(2) : 0;
    double b = other.getDegree() >= 1 ? other.getCoefficient(1) + this.coefficientDegree1
        : this.coefficientDegree1;
    double c = other.getCoefficient(0) + this.coefficientDegree0;

    // return a quadratic
    if (a != 0) {
      return new Quadratic(a, b, c);
    }
    // return a line
    if (b != 0) {
      return new Line(b, c);
    }
    // return a constant
    return new Constant(c);
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
    return new Line(this.coefficientDegree1,
        dy + this.coefficientDegree0 - this.coefficientDegree1 * dx);
  }

  /**
   * Multiply two polynomials and returning a new polynomial without mutation
   *
   * @param other@return Polynomial without mutation
   * @throws IllegalArgumentException if two polynomials' degree are not 0 or 1
   */
  @Override
  public Polynomial multiply(Polynomial other) throws IllegalArgumentException {
    return switch (other.getDegree()) {
      //multiply constant
      case 0 -> new Line(this.coefficientDegree1 * other.getCoefficient(0),
          this.coefficientDegree0 * other.getCoefficient(0));
      //multiply line  (a1x+b1)(a2x+b2) = a1a2x^2+(a1b2+a2b1)x+b1b2
      case 1 -> new Quadratic(this.coefficientDegree1 * other.getCoefficient(1),
          this.coefficientDegree0 * other.getCoefficient(1)
              + this.coefficientDegree1 * other.getCoefficient(0),
          this.coefficientDegree0 * other.getCoefficient(0));
      // neither constant nor line
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
   * format string if double with integer value or keep one digit after point e.g.  "1.0" will
   * return "1" instead
   *
   * @param d double
   * @return string
   */
  private String format(double d) {
    return d % 1 == 0 ? String.valueOf((int) d) : String.format("%.1f", d);
  }
}
