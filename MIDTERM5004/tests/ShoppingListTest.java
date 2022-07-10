import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * This test class test all the method in Interface IShoppinglist and concrete classes:
 * Shoppinglist, food, clothing, other
 */
public class ShoppingListTest {

  Food taco, ribs, bun, bagel;
  Clothing top, shorts, sneaker, hat;
  Other fork, knife, book, tissue;

  @Before
  public void setup() {
    taco = new Food("taco", 2.5, 4, 7, 8, 2022);
    ribs = new Food("ribs", 25, 1, 7, 9, 2022);
    bun = new Food("bun", 7, 10, 2022);
    bagel = new Food("bagel", 7, 11, 2022);

    top = new Clothing("Nike", 30, 2, 1);
    shorts = new Clothing("Adidas", 40, 3, 2);
    sneaker = new Clothing("Sneaker", 6);
    hat = new Clothing("hat", 3);

    fork = new Other("fork", 2, 5);
    knife = new Other("knife", 3, 6);
    book = new Other("book");
    tissue = new Other("tissue");
  }

  /**
   * Tests add method use contains method to test
   */
  @Test
  public void testAdd() {
    IShoppingList shoppingList = new ShoppingList();

    assertTrue(shoppingList.add(taco));
    assertTrue(shoppingList.add(top));
    assertTrue(shoppingList.add(tissue));
  }

  /**
   * Tests get method
   */
  @Test
  public void testGet() {
    IShoppingList shoppingList = new ShoppingList();
    shoppingList.add(bun); //food
    shoppingList.add(hat); // clothing
    shoppingList.add(knife); //other

    assertEquals(bun, shoppingList.get(0));
    assertEquals(hat, shoppingList.get(1));
    assertEquals(knife, shoppingList.get(2));
  }

  /**
   * Tests get method throw exception
   */
  @Test(expected = IndexOutOfBoundsException.class)
  public void testGetFail() {
    IShoppingList shoppingList = new ShoppingList();
    shoppingList.add(bun); //food
    shoppingList.add(hat); // clothing
    shoppingList.add(knife); //other
    // invalid index
    shoppingList.get(3);
  }

  /**
   * Tests contain method, return boolean
   */
  @Test
  public void testContains() {
    IShoppingList shoppingList = new ShoppingList();
    shoppingList.add(bun); //food
    shoppingList.add(hat); // clothing
    shoppingList.add(knife); //other
    //in list
    assertTrue(shoppingList.contains(bun));
    //not in list
    assertFalse(shoppingList.contains(book));
  }

  /**
   * Tests isEmpty method, return boolean
   */
  @Test
  public void testIsEmpty() {
    IShoppingList shoppingList = new ShoppingList();
    assertTrue(shoppingList.isEmpty());

    shoppingList.add(bun);
    assertFalse(shoppingList.isEmpty());
  }

  /**
   * Tests remove method Use contains to test
   */
  @Test
  public void testRemove() {
    IShoppingList shoppingList = new ShoppingList();
    shoppingList.add(bun);
    shoppingList.remove(bun);
    assertFalse(shoppingList.contains(bun));
  }

  /**
   * Tests remove method with invaild input(not in list), will throw exception
   */
  @Test(expected = IllegalArgumentException.class)
  public void testRemoveFail() {
    IShoppingList shoppingList = new ShoppingList();
    shoppingList.remove(bun);
  }

  /**
   * Tests size method
   */
  @Test
  public void testSize() {
    IShoppingList shoppingList = new ShoppingList();
    shoppingList.add(taco);
    shoppingList.add(ribs);
    shoppingList.add(top);
    shoppingList.add(shorts);
    shoppingList.add(fork);
    shoppingList.add(knife);

    assertEquals(6, shoppingList.size());
  }

  /**
   * Tests sortbyprice, use comparable ordering Items sort in ascending order
   */
  @Test
  public void testSortByPrice() {
    //unsorted
    IShoppingList shoppingList = new ShoppingList();
    shoppingList.add(taco);
    shoppingList.add(ribs);
    shoppingList.add(top);
    shoppingList.add(shorts);
    shoppingList.add(fork);
    shoppingList.add(knife);
    shoppingList.sortByPrice();

    //sorted manually in price increasing order
    IShoppingList sortedShoppingList = new ShoppingList();
    sortedShoppingList.add(fork);
    sortedShoppingList.add(taco);
    sortedShoppingList.add(knife);
    sortedShoppingList.add(ribs);
    sortedShoppingList.add(top);
    sortedShoppingList.add(shorts);

    // toString() method contains the order information
    assertEquals(sortedShoppingList.toString(), shoppingList.toString());
  }

  /**
   * Tests sortbyimportance, use comparator ordering Items sort in ascending order
   */
  @Test
  public void testSortByImportance() {
    // unsorted
    IShoppingList shoppingList = new ShoppingList();
    shoppingList.add(taco);
    shoppingList.add(ribs);
    shoppingList.add(top);
    shoppingList.add(shorts);
    shoppingList.add(fork);
    shoppingList.add(knife);
    shoppingList.sortByImportance();

    // sorted manually according to importance scale
    IShoppingList sortedShoppingList = new ShoppingList();
    sortedShoppingList.add(ribs);
    sortedShoppingList.add(top);
    sortedShoppingList.add(shorts);
    sortedShoppingList.add(taco);
    sortedShoppingList.add(fork);
    sortedShoppingList.add(knife);

    // toString() method contains the order information
    assertEquals(sortedShoppingList.toString(), shoppingList.toString());
  }

  /**
   * Tests toString method.
   */
  @Test
  public void testToStringFood() {
    IShoppingList shoppingList = new ShoppingList();
    shoppingList.add(taco);
    shoppingList.add(top);
    shoppingList.add(tissue);
    assertEquals("""
        No.0 item: Food taco is $2.50 of importance scale 4, sell by Date 2022-08-07.
        No.1 item: Cloth Nike is $30.00 of importance scale 2, is size 1.
        No.2 item: Other item tissue with price $0.00 has importance scale of 0.
        """, shoppingList.toString());
  }
}

