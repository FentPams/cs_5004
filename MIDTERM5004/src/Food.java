import java.time.DateTimeException;
import java.time.LocalDate;

/**
 * Food Class extends Item abstract class
 */
public class Food extends Item {

  private final LocalDate sellByDate;

  /**
   * Constructors for food
   *
   * @param name
   * @param day
   * @param month
   * @param year
   * @throws IllegalArgumentException when date invalid
   */
  public Food(String name, int day, int month, int year) throws IllegalArgumentException {
    super(name);
    try {
      this.sellByDate = LocalDate.of(year, month, day);
    } catch (DateTimeException e) {
      throw new IllegalArgumentException("Invalid date");
    }
  }

  public Food(String name, double price, int importance, int day, int month, int year)
      throws IllegalArgumentException {
    super(name, price, importance);
    try {
      this.sellByDate = LocalDate.of(year, month, day);
    } catch (DateTimeException e) {
      throw new IllegalArgumentException("Invalid date");
    }
  }

  /**
   * Get sell by date
   *
   * @return localDate
   */
  public LocalDate getSellByDate() {
    return this.sellByDate;
  }

  /**
   * Get Category
   *
   * @return enum Category
   */
  @Override
  public Category getCategory() {
    return Category.FOOD;
  }

  /**
   * @return String
   */
  @Override
  public String toString() {
    return String.format("Food %s is $%.2f of importance scale %d, sell by Date %s.",
        super.getName(), super.getPrice(), super.getImportance(), this.sellByDate);
  }

  /**
   * Compare two items
   *
   * @param other
   * @return boolean
   */
  @Override
  public boolean equals(Item other) {
    if (!(other instanceof Food)) {
      return false;
    }
    return super.equals(other) && this.sellByDate.isEqual(((Food) other).getSellByDate());
  }
}
