
/**
 * Clothing Class extends Item abstract class
 */
public class Clothing extends Item {

  private final int clothingSize;

  /**
   * Constructors for clothing
   *
   * @param name
   * @param clothingSize
   */
  public Clothing(String name, int clothingSize) {
    super(name);
    this.clothingSize = clothingSize;
  }

  public Clothing(String name, double price, int importance, int clothingSize) {
    super(name, price, importance);
    this.clothingSize = clothingSize;
  }

  /**
   * Get size
   *
   * @return int
   */
  public int getClothingSize() {
    return this.clothingSize;
  }

  /**
   * Get enum category
   *
   * @return Category
   */
  @Override
  public Category getCategory() {
    return Category.CLOTHING;
  }

  /**
   * @return String
   */
  @Override
  public String toString() {
    return String.format("Cloth %s is $%.2f of importance scale %d, is size %d.",
        super.getName(), super.getPrice(), super.getImportance(), this.clothingSize);
  }

  /**
   * Compare two items
   *
   * @param other
   * @return boolean
   */
  @Override
  public boolean equals(Item other) {
    if (!(other instanceof Clothing)) {
      return false;
    }
    return super.equals(other) && this.clothingSize == ((Clothing) other).getClothingSize();
  }
}

