/**
 * Lab04 -- LinkedList
 * Programmer: Xinyi Feng
 * Date: 31 May, 2022
 */

/**
 * This represents an empty node in the list
 */
public class EmptyNode implements IListOfInts {

  @Override
  public IListOfInts addAtIndex(int index, int data) throws IllegalArgumentException {
    if (index == 0) {
      return addFront(data);
    }
    throw new IllegalArgumentException("Invalid index to add an element");
  }

  @Override
  public IListOfInts addFront(int data) {
    return new
        ElementNode(data, this);
  }

  @Override
  public IListOfInts addBack(int data) {
    return addFront(data);
  }

  @Override
  public int getDataAtIndex(int index) throws IllegalArgumentException {
    throw new IllegalArgumentException("Wrong index");
  }

  @Override
  public int count() {
    return 0;
  }

  @Override
  public int sum() {
    return 0;
  }

  @Override
  public int countHelp(int i) {
    return i;
  }

  @Override
  public String toString() {
    return "";
  }


  public String toStringHelper(String s) {
    return s;
  }

}
