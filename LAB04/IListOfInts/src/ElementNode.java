/**
 * Lab04 -- LinkedList
 * Programmer: Xinyi Feng
 * Date: 31 May, 2022
 */

/**
 * This represents a non-empty node of the list. It contains a piece of data
 * along with the rest of the list
 */
public class ElementNode implements IListOfInts {

  private final int data;
  private IListOfInts rest;

  public ElementNode(int data, IListOfInts rest) {
    this.data = data;
    this.rest = rest;

  }

  @Override
  public IListOfInts addAtIndex(int index, int data) throws IllegalArgumentException {
    if (index == 0) {
      return addFront(data);
    } else {
      this.rest = this.rest.addAtIndex(index - 1, data);
      return this;
    }
    // throw new IllegalArgumentException("Invalid index to add an element");
  }

  @Override
  public IListOfInts addFront(int data) {
    return new ElementNode(data, this);
  }

  @Override
  public IListOfInts addBack(int data) {
    this.rest = this.rest.addBack(data);
    return this;
  }

  @Override
  public int getDataAtIndex(int index) throws IllegalArgumentException {
    if (index == 0) {
      return this.data;
    }
    return this.rest.getDataAtIndex(index - 1);
  }

  @Override
  //public int count() { return 1+this.rest.count();}
  public int count() {
    return countHelp(0);
  }

  public int countHelp(int acc) {
    return this.rest.countHelp(1 + acc);
  }

  @Override
  public int sum() {
    return this.data + this.rest.sum();
  }


  @Override
  public String toString() {
    return "(" + String.valueOf(this.data) + ")" + this.rest.toString();
  }

}
