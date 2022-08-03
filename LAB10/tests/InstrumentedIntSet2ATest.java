/**
 * This test class tests InstrumentedIntSet2A extend IntSet1,
 * which is the second version based on the InstrumentedIntSet1,
 * and retest if it works finely for IntSet1
 * All passed!
 */

import org.junit.Test;

import static org.junit.Assert.*;

public class InstrumentedIntSet2ATest {

    InstrumentedIntSet set2ATest = new InstrumentedIntSet2A();

    /**
     * Tests get add count method with only one value by add method
     * Test passed
     */
    @Test
    public void testGetAddCountOneValueByAdd() {
        set2ATest.add(1);
        assertEquals(1, set2ATest.getAddCount());
    }

    /**
     * Tests get add count method with multiple value once a time
     * Test passed
     */
    @Test
    public void testGetAddCountMultipleValueByAdd() {
        set2ATest.add(1);
        set2ATest.add(2);
        set2ATest.add(3);
        assertEquals(3, set2ATest.getAddCount());
    }

    /**
     * Tests get add count method with addall method but only one value
     */
    @Test
    public void testGetAddCountMultipleValueByAddAllWithOnlyOneValue() {
        set2ATest.addAll(1);
        assertEquals(1, set2ATest.getAddCount());
    }

    /**
     * Tests get add count method with addall method with multiple elements
     */
    @Test
    public void testGetAddCountByAddALL() {
        set2ATest.addAll(1,2);
        assertEquals(2, set2ATest.getAddCount());
    }
    /**
     * Tests add method by adding one value only
     * To makesure the add method works good
     * Use member method to test, should return true
     * Test pass
     */
    @Test
    public void testAdd() {
        set2ATest.add(1);
        assertTrue(set2ATest.member(1));
    }

    /**
     * Tests add all method
     * To test addall method can add the values required
     * but fail on dealing with count
     *
     */
    @Test
    public void testAddAll() {
        set2ATest.addAll(1,2,3);
        assertTrue(set2ATest.member(1));
        assertTrue(set2ATest.member(2));
        assertTrue(set2ATest.member(3));
    }
}