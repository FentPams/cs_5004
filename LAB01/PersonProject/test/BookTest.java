import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * A JUnit test class for the Book class
 */

public class BookTest {

    private Book Head_First_Git;

    private Book C_Programming;

    private Person Raju;

    private Person Brian;


    @Before
    public void setUp() {
        this.Raju = new Person("Raju", "Gandhi", 1975 );
        this.Brian = new Person("Brian", "Kernichan", 1942);
        this.Head_First_Git = new Book("Head First Git", Raju, 39.50f);
        this.C_Programming = new Book("C Programming", Brian, 42.33f);

    }
    @Test
    public void testTitle() {
        assertEquals("Head First Git", this.Head_First_Git.getTitle());
        assertEquals("C Programming", this.C_Programming.getTitle());
    }

    @Test
    public void testPrice() {
        assertEquals(39.5, this.Head_First_Git.getPrice(),0.1);
        assertEquals(42.3, this.C_Programming.getPrice(),0.1);
    }

    @Test
    public void testAuthor() {
        assertEquals(Raju, this.Head_First_Git.getAuthor());
        assertEquals(Brian, this.C_Programming.getAuthor());
    }

}
