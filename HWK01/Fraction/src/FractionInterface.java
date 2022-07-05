/**
 * Programmer: Xinyi Feng
 * CS5004 HWK1-Fraction
 * 31 May, 2022
 * This interface represents the operations of Fraction
 */

public interface FractionInterface extends Comparable<FractionInterface> {

  /**
   * convert a fraction into a double
   *
   * @return double, the scientific value(decimal)of the fraction
   */
  double toDouble();

  /**
   * convert the fraction into its reciprocal form
   *
   * @return double, the reciprocal of fraction
   */
  FractionInterface reciprocal();

  /**
   * adds one fraction with another fraction
   *
   * @param otherFraction fraction needed to be added
   * @return fraction, a result after adding
   */
  FractionInterface add(FractionInterface otherFraction);
  
  /**
   * Setter to set numerator
   * set this. numerator as the argument
   */
  public void setNumerator(int numerator); 
    
   /**
   * Setter to set denominator
   * set this. denominator as the argument
   * will throw exception when the denominator is set less than 0
   *
   * @param denominator int to be set
   * @throws IllegalArgumentException if denominator is not positive
   */
  public void setDenominator(int denominator) throws IllegalArgumentException;
  
  /**
   * Getter to get denominator
   *
   * @return double, the denominator
   */
  public int getDenominator()；
  
  /**
   * Getter to get numerator
   *
   * @return double, the numerator
   */
  public int getNumerator();
 
}

