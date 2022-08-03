/**
 * This test class tests InstrumentedIntSet3A extend IntSet3,
 * which codes are same as InstrumentedIntSet3
 * and test if IntSet3 works fine,
 * it uses Private_add method
 * Still works!
 */

import org.junit.Test;

import static org.junit.Assert.*;

public class InstrumentedIntSet3ATest {

    InstrumentedIntSet set3ATest = new InstrumentedIntSet3A();

    /**
     * Tests get add count method with only one value by add method
     * Test passed
     */
    @Test
    public void testGetAddCountOneValueByAdd() {
        set3ATest.add(1);
        assertEquals(1, set3ATest.getAddCount());
    }

    /**
     * Tests get add count method with multiple value once a time
     * Test passed
     */
    @Test
    public void testGetAddCountMultipleValueByAdd() {
        set3ATest.add(1);
        set3ATest.add(2);
        set3ATest.add(3);
        assertEquals(3, set3ATest.getAddCount());
    }

    /**
     * Tests get add count method with addall method but only one value
     */
    @Test
    public void testGetAddCountMultipleValueByAddAllWithOnlyOneValue() {
        set3ATest.addAll(1);
        assertEquals(1, set3ATest.getAddCount());
    }

    /**
     * Tests get add count method with addall method with multiple elements
     */
    @Test
    public void testGetAddCountByAddALL() {
        set3ATest.addAll(1,2);
        assertEquals(2, set3ATest.getAddCount());
    }
    /**
     * Tests add method by adding one value only
     * To makesure the add method works good
     * Use member method to test, should return true
     * Test pass
     */
    @Test
    public void testAdd() {
        set3ATest.add(1);
        assertTrue(set3ATest.member(1));
    }

    /**
     * Tests add all method
     * To test addall method can add the values required
     * but fail on dealing with count
     *
     */
    @Test
    public void testAddAll() {
        set3ATest.addAll(1,2,3);
        assertTrue(set3ATest.member(1));
        assertTrue(set3ATest.member(2));
        assertTrue(set3ATest.member(3));
    }
}