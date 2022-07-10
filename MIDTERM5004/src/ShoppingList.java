import java.util.ArrayList;
import java.util.List;

/**
 * This concrete shopping list class implements IShopping list interface Implement Arraylist because
 * the items have many get operations Arraylist has lower time complexity than linked list on
 * getting items.
 */

public class ShoppingList implements IShoppingList {

  // Uses Arraylist create list for efficient get, remove operations
  private final List<Item> items;

  public ShoppingList() {
    this.items = new ArrayList<>();
  }

  /**
   * Add an object to this shopping list
   *
   * @param i the object to be added to the list
   * @return boolean True if add successfully
   */
  @Override
  public boolean add(Item i) {
    return this.items.add(i);
  }

  /**
   * Get the (index)th object in this list
   *
   * @param index the index of the object to be returned
   * @return the object at the given index
   * @throws IllegalArgumentException if an invalid index is passed
   */
  @Override
  public Item get(int index) throws IndexOutOfBoundsException {
    return this.items.get(index);
  }

  /**
   * Check if the shopping list contains item i empty or not
   *
   * @param i the item to be checked in shopping list
   * @return boolean if item exist in the shopping list, return True, otherwise return False
   */
  @Override
  public boolean contains(Item i) {
    return this.items.contains(i);
  }

  /**
   * Check if the shopping list is empty or not
   *
   * @return boolean if list is empty, return True, otherwise return False
   */
  @Override
  public boolean isEmpty() {
    return this.items.isEmpty();
  }

  /**
   * Remove the item of this object from this list
   *
   * @param i the object to be removed
   * @throws IllegalArgumentException when i is not in the list
   */

  public void remove(Item i) throws IllegalArgumentException {
    if (!this.items.contains(i)) {
      throw new IllegalArgumentException("Item not in the list");
    }
    this.items.remove(i);
  }

  /**
   * Return the number of objects currently in this list
   *
   * @return the size of the list
   */
  @Override
  public int size() {
    return this.items.size();
  }

  /**
   * Sort list of item in increasing order of price use comparable ordering from items class
   */
  @Override
  public void sortByPrice() {
    this.items.sort(Item::compareTo);
  }

  /**
   * Sort list of item in increasing order of importance Use the comparator ordering
   */
  @Override
  public void sortByImportance() {
    this.items.sort(new ItemImportanceComparator());
  }

  /**
   * Return shopping list item with info
   *
   * @return String
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < this.items.size(); i++) {
      sb.append(String.format("No.%d item: %s\n", i, this.items.get(i)));
    }
    return sb.toString();
  }
}

