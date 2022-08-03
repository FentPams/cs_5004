/**
 * This test class is to test InstrumentedIntSet4 using delegation
 * All passed!
 */

import org.junit.Test;

import static org.junit.Assert.*;

public class InstrumentedIntSet4Test {

    InstrumentedIntSet set4Test = new InstrumentedIntSet4();
/**
 * Tests get add count method with only one value by add method
 * Test passed
 */
    @Test
    public void testGetAddCountOneValueByAdd() {
        set4Test.add(1);
        assertEquals(1, set4Test.getAddCount());
    }


    /**
     * Tests get add count method with multiple value once a time
     * Test passed
     */
    @Test
    public void testGetAddCountMultipleValueByAdd() {
        set4Test.add(1);
        set4Test.add(2);
        set4Test.add(3);
        assertEquals(3, set4Test.getAddCount());
    }

    /**
     * Tests get add count method with addall method but only one value
     */
    @Test
    public void testGetAddCountMultipleValueByAddAllWithOnlyOneValue() {
        set4Test.addAll(1);
        assertEquals(1, set4Test.getAddCount());
    }

    /**
     * Tests get add count method with addall method with multiple elements
     */
    @Test
    public void testGetAddCountByAddALL() {
        set4Test.addAll(1,2);
        assertEquals(2, set4Test.getAddCount());
    }
    /**
     * Tests add method by adding one value only
     * To makesure the add method works good
     * Use member method to test, should return true
     * Test pass
     */
    @Test
    public void testAdd() {
        set4Test.add(1);
        assertTrue(set4Test.member(1));
    }

    /**
     * Tests add all method
     * To test addall method can add the values required
     * but fail on dealing with count
     *
     */
    @Test
    public void testAddAll() {
        set4Test.addAll(1,2,3);
        assertTrue(set4Test.member(1));
        assertTrue(set4Test.member(2));
        assertTrue(set4Test.member(3));
    }

    /**
     * Tests remove method,
     * to test if the element can remove correctly
     * using member method to check
     * The remove method works fine!
     */
    @Test
    public void testRemoveOneValue() {
        set4Test.add(1);
        set4Test.remove(1);

        assertFalse(set4Test.member(1));
    }


    /**
     * Tests remove method mutiple times,
     * to test if the element can remove correctly
     * Using member to check it
     */
    @Test
    public void testRemoveMultipleTimes() {
        set4Test.add(1);
        set4Test.remove(1);
        set4Test.add(1);
        set4Test.remove(1);
        assertFalse(set4Test.member(1));
    }

    /**
     * Test member method True
     */
    @Test
    public void testMemberTrue() {
        set4Test.add(1);
        assertTrue(set4Test.member(1));
    }

    /**
     * Test member method False
     */
    @Test
    public void testMemberFalse() {
        set4Test.add(1);
        set4Test.remove(1);
        assertFalse(set4Test.member(1));

    }
}