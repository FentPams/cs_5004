/**
 * This Test class test InstrumentedIntSet1 extend IntSet1, the first version.
 * And it has bug on addAll method, which double counts the elements.
 * See details below.
 */

import org.junit.Test;

import static org.junit.Assert.*;

public class InstrumentedIntSet1Test {

    InstrumentedIntSet set1Test = new InstrumentedIntSet1();

    /**
     * Tests get add count method with only one value by add method
     * Test passed
     */
    @Test
    public void testGetAddCountOneValueByAdd() {
        set1Test.add(1);
        assertEquals(1, set1Test.getAddCount());
    }

    /**
     * Tests get add count method with multiple value once a time
     * Test passed
     */
    @Test
    public void testGetAddCountMultipleValueByAdd() {
        set1Test.add(1);
        set1Test.add(2);
        set1Test.add(3);
        set1Test.add(4);
        set1Test.add(5);
        assertEquals(5,set1Test.getAddCount());
    }

    /** Failed!
     * Tests get add count method with addall method but only one value
     * Expected to be 1, but return 2, so addall method may have bugs.
     * Let's continue testing on addall to make sure of it.
     */
    @Test
    public void testGetAddCountMultipleValueByAddAllWithOnlyOneValue() {
        set1Test.addAll(1);
        assertEquals(1,set1Test.getAddCount());
    }

    /** Failed!
     * Tests get add count method with addall method with multiple elements
     * Expected to be 2, but return 4, so addall method has bugs!
     * And it will double the elements.
     * Back to the method, the code " addCount += value.length" double counts the elements.
     *
     * As we call the super.addAll method,
     * and it InSet1 class, it calls add method, which we have override, and in add method, it has updated the count,
     * So it results double counting
     *
     */
    @Test
    public void testGetAddCountByAddALL() {
        set1Test.addAll(1,2);
        assertEquals(2,set1Test.getAddCount());
    }
    /**
     * Tests add method by adding one value only
     * To makesure the add method works good
     * Use member method to test, should return true
     * Test pass
     */
    @Test
    public void testAdd() {
        set1Test.add(1);
        assertTrue(set1Test.member(1));
    }

    /**
     * Tests add all method
     * To test addall method can add the values required
     * but fail on dealing with count
     *
     */
    @Test
    public void testAddAll() {
        set1Test.addAll(1,2,3);
        assertTrue(set1Test.member(1));
        assertTrue(set1Test.member(2));
        assertTrue(set1Test.member(3));
    }
}