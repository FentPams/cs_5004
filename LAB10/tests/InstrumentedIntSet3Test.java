/**
 * This test class tests InstrumentedIntSet3 extend IntSet2,
 * which is the second version based on the InstrumentedIntSet2,
 * and retest if it works finely for IntSet2
 * All passed!
 *
 * Can't test InstrumentedIntSet3 extend IntSet4, will have compile err
 */
import org.junit.Test;

import static org.junit.Assert.*;

public class InstrumentedIntSet3Test {

    InstrumentedIntSet set3Test = new InstrumentedIntSet3();

    /**
     * Tests get add count method with only one value by add method
     * Test passed
     */
    @Test
    public void testGetAddCountOneValueByAdd() {
        set3Test.add(1);
        assertEquals(1, set3Test.getAddCount());
    }

    /**
     * Tests get add count method with multiple value once a time
     * Test passed
     */
    @Test
    public void testGetAddCountMultipleValueByAdd() {
        set3Test.add(1);
        set3Test.add(2);
        set3Test.add(3);
        assertEquals(3, set3Test.getAddCount());
    }

    /**
     * Tests get add count method with addall method but only one value
     */
    @Test
    public void testGetAddCountMultipleValueByAddAllWithOnlyOneValue() {
        set3Test.addAll(1);
        assertEquals(1, set3Test.getAddCount());
    }

    /**
     * Tests get add count method with addall method with multiple elements
     */
    @Test
    public void testGetAddCountByAddALL() {
        set3Test.addAll(1,2);
        assertEquals(2, set3Test.getAddCount());
    }
    /**
     * Tests add method by adding one value only
     * To makesure the add method works good
     * Use member method to test, should return true
     * Test pass
     */
    @Test
    public void testAdd() {
        set3Test.add(1);
        assertTrue(set3Test.member(1));
    }

    /**
     * Tests add all method
     * To test addall method can add the values required
     * but fail on dealing with count
     *
     */
    @Test
    public void testAddAll() {
        set3Test.addAll(1,2,3);
        assertTrue(set3Test.member(1));
        assertTrue(set3Test.member(2));
        assertTrue(set3Test.member(3));
    }
}