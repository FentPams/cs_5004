/**
 * This interface represents a shopping list for item. With the methods that needed to be
 * implemented in shopping list
 */
public interface IShoppingList {

  /**
   * Add an object to this shopping list
   *
   * @param i the object to be added to the list
   */
  boolean add(Item i);


  /**
   * Get the (index)th object in this list
   *
   * @param index the index of the object to be returned
   * @return the object at the given index
   * @throws IndexOutOfBoundsException if an invalid index is passed
   */
  Item get(int index) throws IndexOutOfBoundsException;

  /**
   * Check if the shopping list contains item i empty or not
   *
   * @param i the item to be checked in shopping list
   * @return boolean if item exist in the shopping list, return True, otherwise return False
   */
  boolean contains(Item i);

  /**
   * Check if the shopping list is empty or not
   *
   * @return boolean if list is empty, return True, otherwise return False
   */
  boolean isEmpty();


  /**
   * Remove the first instance of this object from this list
   *
   * @param i the object to be removed
   */
  void remove(Item i) throws IllegalArgumentException;

  /**
   * Return the number of objects currently in this list
   *
   * @return the size of the list
   */
  int size();


  /**
   * Return a sorted list of item in increasing order of price
   *
   * @return a sorted list of item
   */
  void sortByPrice();


  /**
   * Return a sorted list of item in increasing order of importance
   *
   * @return a sorted list of item
   */
  void sortByImportance();
}
