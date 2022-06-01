/**
 * Lab04 -- LinkedList
 * Programmer: Xinyi Feng
 * Date: 31 May, 2022
 */

/**
 * This interface represents all the operations to be supported by a list of int
 */
public interface IListOfInts {

  /**
   * Add an int to this list so that it occupies the provided index. Index
   * begins with 0
   * @param index the index to be occupied by this object, beginning at 0
   * @param data the int to be added to the list
   */
  IListOfInts addAtIndex(int index, int data);

  /**
   * Add an int to the front of this list
   * @param data the int to be added to the front of this list
   */
  IListOfInts addFront(int data);

  /**
   * Add an int to the back of this list (so it is the last int in the
   * list
   * @param data the int to be added to teh back of this list
   */
  IListOfInts addBack(int data);

  /**
   * Return the int at the index in this list
   * @param index the index that int at
   */
  int getDataAtIndex(int index);

  /**
   * Return the number of ints currently in this list
   * @return the size of the list
   */
  int count();
  int countHelp(int i);
  /**
   * Return the sum of ints currently in this list
   * @return the sum of the list
   */
  int sum();

}

