/**
 * This abstract class has methods body of every child concrete class needed And some abstract
 * methods for child class to override.
 */
public abstract class Item implements Comparable<Item> {

  private final String name;
  private double price;
  private int importance;

  /**
   * Constructors
   *
   * @param name
   */
  public Item(String name) {
    this.name = name;
  }

  public Item(String name, double price, int importance) {
    this.name = name;
    this.price = price;
    this.importance = importance;
  }

  /**
   * Getters
   *
   * @return String
   */
  public String getName() {
    return this.name;
  }

  public double getPrice() {
    return this.price;
  }

  public int getImportance() {
    return this.importance;
  }

  public abstract Category getCategory();

  /**
   * Setters
   *
   * @param price
   * @throws IllegalArgumentException when price less than 0
   */
  public void setPrice(double price) throws IllegalArgumentException {
    if (price < 0) {
      throw new IllegalArgumentException("Can't be negative");
    }
    this.price = price;
  }

  /**
   * Setter
   *
   * @param scale
   * @throws IllegalArgumentException when scale is not in 0-9
   */
  public void setImportance(int scale) throws IllegalArgumentException {
    if (scale < 0 || scale > 9) {
      throw new IllegalArgumentException("Invalid scale");
    }
    this.importance = scale;
  }

  /**
   * Implement comparable
   *
   * @param other the object to be compared.
   * @return 1 larger, -1 lesser, 0 equal
   */
  @Override
  public int compareTo(Item other) {
    return Double.compare(this.price, other.getPrice());
  }

  /**
   * Compare items, each concrete class has override
   *
   * @param other Item
   * @return boolean
   */
  public boolean equals(Item other) {
    return this.name.equals(other.getName()) && Double.compare(this.price, other.getPrice()) == 0
        && this.importance == other.getImportance();
  }

  /**
   * Name hash use hashcode of string of item name
   *
   * @return int
   */
  @Override
  public int hashCode() {
    return this.name.hashCode();
  }

  /**
   * Abstract string method
   *
   * @return String
   */
  public abstract String toString();
}
