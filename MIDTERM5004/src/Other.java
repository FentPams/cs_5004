/**
 * Other Class extends Item abstract class
 */
public class Other extends Item {

  public Other(String name) {
    super(name);
  }

  public Other(String name, double price, int importance) {
    super(name, price, importance);
  }

  @Override
  public Category getCategory() {
    return Category.OTHER;
  }

  @Override
  public String toString() {
    return String.format("Other item %s with price $%.2f has importance scale of %d.",
        super.getName(),
        super.getPrice(), super.getImportance());
  }

  @Override
  public boolean equals(Item other) {
    if (!(other instanceof Other)) {
      return false;
    }
    return super.equals(other);
  }

}
