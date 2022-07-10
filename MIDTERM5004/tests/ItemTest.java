import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * This test tests the item class with all methods in it
 */
public class ItemTest {

  Item taco, top, fork;

  @Before
  public void setup() {
    taco = new Food("taco", 2.5, 4, 7, 8, 2022);
    top = new Clothing("Nike", 30, 2, 1);
    fork = new Other("fork", 2, 5);

  }

  @Test(expected = IllegalArgumentException.class)
  public void testFoodWithInvalidDate() {
    new Food("foodInvalid", 32, 1, 2022);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testFoodWithInvalidDate2() {
    new Food("foodInvalid", 2, 1, 20, 13, 2022);
  }

  /**
   * Tests Getter
   */
  @Test
  public void testGetName() {
    assertEquals("taco", taco.getName());
    assertEquals("Nike", top.getName());
    assertEquals("fork", fork.getName());
  }

  @Test
  public void testGetPrice() {
    assertEquals(2.5, taco.getPrice(), 0.01);
    assertEquals(30, top.getPrice(), 0.01);
    assertEquals(2, fork.getPrice(), 0.01);
  }

  @Test
  public void testGetImportance() {
    assertEquals(4, taco.getImportance());
    assertEquals(2, top.getImportance());
    assertEquals(5, fork.getImportance());
  }

  /**
   * Test get enum type
   */
  @Test
  public void testGetCategory() {
    assertEquals(Category.FOOD, taco.getCategory());
    assertEquals(Category.CLOTHING, top.getCategory());
    assertEquals(Category.OTHER, fork.getCategory());
  }

  /**
   * Tests set price correctly
   */
  @Test
  public void testSetPrice() {
    Item item = new Other("name");
    item.setPrice(1.0);
    assertEquals(1.0, item.getPrice(), 0.01);
  }

  /**
   * Tests set price fail if price is negative
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetPriceFail() {
    Item item = new Other("name");
    item.setPrice(-1.0);
  }

  /**
   * Tests set importance within 0-9
   */
  @Test
  public void testSetImportance() {
    Item item = new Other("name");
    item.setImportance(5);
    assertEquals(5, item.getImportance());
  }

  /**
   * Tests set importance throw exception not within 0-9
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetImportanceFail() {
    Item item = new Other("name");
    item.setImportance(20);
  }

  /**
   * Compare price, if lesser return -1, equals 0, larger 1
   */
  @Test
  public void testCompareTo() {
    Item item1 = new Other("Phone1", 2999, 6);
    Item item2 = new Other("Phone2", 3999, 6);
    assertEquals(-1, item1.compareTo(item2));

  }

/**
 * Tests equals, instance, and fields should be same.
 */
  @Test
  public void testEquals() {
    Item food1 = new Food("food", 9, 7, 2022);
    Item food2 = new Food("food", 9, 7, 2022);

    Item other1 = new Other("other", 2999, 6);
    Item other2 = new Other("other", 2999, 6);

    Item clothing1 = new Clothing("clothing", 1);
    Item clothing2 = new Clothing("clothing", 1);

    assertTrue(food1.equals(food2));
    assertTrue(other1.equals(other2));
    assertTrue(clothing1.equals(clothing2));

    assertFalse(food1.equals(other1));
    assertFalse(clothing1.equals(other1));
    assertFalse(other1.equals(food2));
  }

  /**
   * Tests Name hashcode
   */
  @Test
  public void testHashCode() {
    assertEquals(taco.getName().hashCode(), taco.hashCode());
    assertEquals(top.getName().hashCode(), top.hashCode());
    assertEquals(fork.getName().hashCode(), fork.hashCode());
  }

  /**
   * Tests to string
   */
  @Test
  public void testToString() {
    assertEquals("Food taco is $2.50 of importance scale 4, sell by Date 2022-08-07.",
        taco.toString());
    assertEquals("Cloth Nike is $30.00 of importance scale 2, is size 1.", top.toString());
    assertEquals("Other item fork with price $2.00 has importance scale of 5.", fork.toString());
  }
}