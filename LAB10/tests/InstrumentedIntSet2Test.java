/**
 * This Test class test InstrumentedIntSet2 extend IntSet2, the first version.
 * And it has bug. Because the Intset2 dosen't call add method inside addall, and never runs ++addcount
 * See details below.
 */

import org.junit.Test;

import static org.junit.Assert.*;

public class InstrumentedIntSet2Test {

    InstrumentedIntSet set2Test = new InstrumentedIntSet2();

    /**
     * Tests get add count method with only one value by add method
     * Test passed
     */
    @Test
    public void testGetAddCountOneValueByAdd() {
        set2Test.add(1);
        assertEquals(1, set2Test.getAddCount());
    }

    /**
     * Tests get add count method with multiple value once a time
     * Test passed
     */
    @Test
    public void testGetAddCountMultipleValueByAdd() {
        set2Test.add(1);
        set2Test.add(2);
        set2Test.add(3);
        set2Test.add(4);
        set2Test.add(5);
        assertEquals(5, set2Test.getAddCount());
    }

    /** Failed!
     * Tests get add count method with addall method but only one value
     * Expected to be 1, but return 0, so addall method may have bugs.
     * Let's continue testing on addall to make sure of it.
     */
    @Test
    public void testGetAddCountMultipleValueByAddAllWithOnlyOneValue() {
        set2Test.addAll(1);
        assertEquals(1, set2Test.getAddCount());
    }

    /** Failed!
     * Tests get add count method with addall method with multiple elements
     * Expected to be 2, but return 0, so addall method has bugs! And fail to cout the add!
     *
     * As we call the super.addAll method,
     * but in InSet2 class, it doesn't call add method, rather, it adds elements to set directly,
     * So the ++addCount in the add method never runs!
     *
     */
    @Test
    public void testGetAddCountByAddALL() {
        set2Test.addAll(1,2);
        assertEquals(2, set2Test.getAddCount());
    }
    /**
     * Tests add method by adding one value only
     * To makesure the add method works good
     * Use member method to test, should return true
     * Test pass
     */
    @Test
    public void testAdd() {
        set2Test.add(1);
        assertTrue(set2Test.member(1));
    }

    /**
     * Tests add all method
     * To test addall method can add the values required
     * but fail on dealing with count
     *
     */
    @Test
    public void testAddAll() {
        set2Test.addAll(1,2,3);
        assertTrue(set2Test.member(1));
        assertTrue(set2Test.member(2));
        assertTrue(set2Test.member(3));
    }
}