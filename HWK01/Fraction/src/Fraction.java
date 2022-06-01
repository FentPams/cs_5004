/**
 *  Programmer: Xinyi Feng
 *  CS5004 HWK1-Fraction
 *  31 May, 2022
 *  This Fraction implements FractionInterface with all its methods
 */

public class Fraction implements FractionInterface {

  private int numerator;
  private int denominator;

  /**
   * Constructor for fraction
   *
   * @param numerator,denominator int, denominator will call setDenominator method to setup
   * @throws IllegalArgumentException if denominator is less than 0, will throw exception
   */
  public Fraction(int numerator, int denominator) throws IllegalArgumentException {
    this.numerator = numerator;
    this.setDenominator(denominator);
  }

  /**
   * Setter to set numerator
   * set this. numerator as the argument
   */
  public void setNumerator(int numerator) {
    this.numerator = numerator;
  }

  /**
   * Setter to set denominator
   * set this. denominator as the argument
   * will throw exception when the denominator is set less than 0
   *
   * @param denominator int to be set
   * @throws IllegalArgumentException if denominator is not positive
   */
  public void setDenominator(int denominator) throws IllegalArgumentException {
    if (denominator <= 0) {
      throw new IllegalArgumentException("Invalid denominator, should be positive");
    }
    this.denominator = denominator;
  }

  /**
   * Getter to get denominator
   *
   * @return double, the denominator
   */
  public int getDenominator() {
    return denominator;
  }

  /**
   * Getter to get numerator
   *
   * @return double, the numerator
   */
  public int getNumerator() {
    return numerator;
  }

  /**
   * turns fraction into decimal number if fraction is an integer, cast it into double
   *
   * @return double, a decimal number of fraction
   */
  @Override
  public double toDouble() {
    return (double) this.numerator / this.denominator;
  }

  /**
   * convert the fraction into its reciprocal form if the numerator is zero, it can't be denominator
   * will throw exception
   *
   * @return double, the reciprocal of fraction
   * @throws IllegalArgumentException if numerator is 0
   */
  @Override
  public FractionInterface reciprocal() throws IllegalArgumentException {
    if (numerator == 0) {
      throw new IllegalArgumentException("Numerator should not be zero");
    }
    return new Fraction(this.denominator, this.numerator);
  }

  /**
   * Adds this fraction with another fraction
   *
   * @param otherFraction, fraction under same interface
   * @return a new Fraction, new numerator is :this.numerator * other.denominator + other.numerator
   * * this.denominator new denominator is:this.denominator * other.denominator
   */
  @Override
  public FractionInterface add(FractionInterface otherFraction) {

    Fraction other = (Fraction) otherFraction;
    // add two fractions in mathematical way
    //numerator is (this.numerator * other.denominator + other.numerator * this.denominator)
    // denominator is (this.denominator * other.denominator)
    int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
    int newDenominator = this.denominator * other.denominator;
    int gcd = gcd(Math.abs(newNumerator), newDenominator);
    return new Fraction(newNumerator / gcd, newDenominator / gcd);
  }

  /**
   * Compares this fraction with the specified object:fraction for value.
   *
   * @param otherFraction the fraction to be compared.
   * @return the value 0 if this fraction == other fraction; a value less than 0 if this fraction <
   * other fraction; and a value greater than 0 if this fraction > other fraction
   */
  @Override
  public int compareTo(FractionInterface otherFraction) {

    Fraction other = (Fraction) otherFraction;
    // Rather than compare in fraction format (e.g) a/b with c/d
    // compare a*b with d*c
    // if a*b is larger, then a/b is larger, vice versa
    long valueSelf = (long) this.numerator * other.denominator;
    long valueOther = (long) this.denominator * other.numerator;

    return Long.compare(valueSelf, valueOther);
  }

  /**
   * converts into String with the original denominator, numerator and the simplification value   *
   * is calculated by divide gcd
   *
   * @return String
   */
  @Override
  public String toString() {
    // ensures gcd to be positive
    // avoid the negative case that mess the simlification fraction
    // for example : if numerator is -1, denominator is 2, the simplification output will be 1/-2
    int gcd = gcd(Math.abs(this.numerator), this.denominator);
    // When the numerator is not zero, it has simplification form in fraction form
    if (this.numerator != 0) {
      return String.format(
          "Fraction numerator:%d, denominator:%d. Value after simplification is: %d / %d ",
          this.numerator, this.denominator, this.numerator / gcd, this.denominator / gcd);
    }
    // When the numerator is zero, the simplification should be zero.
    else {
      return String.format(
          "Fraction numerator:%d, denominator:%d. Value after simplification is: 0 ",
          this.numerator, this.denominator);
    }
  }

  /**
   * private method to calculated gcd for simplifying fraction
   *
   * @param a,b two int values
   * @return gcd of two int values.
   */
  private static int gcd(int a, int b) {
    if (b == 0) {
      return a;
    }
    return gcd(b, a % b);
  }
}
