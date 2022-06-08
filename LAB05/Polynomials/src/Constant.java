public class Constant implements Polynomial {

  private double coefficient;


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
  public double getCoefficient(int power)throws IllegalArgumentException{
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
    return String.format("p(x) = %.1f", this.coefficient);
  }

  /**
   * Gets the leading coefficient
   *
   * @return the leading coefficient for the term with that power of this polynomial
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
   * @return new constant obtained by adding two polynomials
   * @throws IllegalArgumentException if assumption is violated
   */
  @Override
  public Polynomial plus(Polynomial other) throws IllegalArgumentException {
    if (this.getDegree() != other.getDegree()) {
      throw new IllegalArgumentException("Violated the assumption");
    }
    return new Constant(this.coefficient + other.getCoefficient(0));
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
}
