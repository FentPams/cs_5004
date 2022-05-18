import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runners.model.TestTimedOutException;
//import org.junit.jupiter.api.Test;

public class PetRockTest {

  private PetRock rocky;
  private PetRock woofy;
  // Timeout rule:
  @Rule
  public Timeout globalTimeout = Timeout.seconds(2); // 2 seconds ms

  @Before
  public void myTestSetUp() throws Exception {
    rocky = new PetRock("Rocky", 5000.56);
    woofy = new PetRock("Woofy", 9000.32);

  }

  @Test
  public void getName() throws Exception {
    assertEquals("Rocky", rocky.getName());
    assertEquals("Woofy", woofy.getName());
  }

  @Test
  public void testUnhappyToStart() throws Exception {
    assertFalse(rocky.isHappy());
    assertFalse(woofy.isHappy());
  }

  @Test
  public void testHappyAfterPlay() throws Exception {
    rocky.playWithRock();
    woofy.playWithRock();
    assertTrue(rocky.isHappy());
    assertTrue(woofy.isHappy());
  }

  @Test
  public void testFavNum() throws Exception {
    assertEquals(42, rocky.getFavNumber());
    assertEquals(52, woofy.getFavNumber());
  }

  //@Ignore("Exception throwing now yet defined")
  @Test(expected = IllegalStateException.class)
  public void emptynameFail() throws Exception {
    rocky.getHappyMessage();
    woofy.getHappyMessage();
  }

  @Test
  public void happyMessage() throws Exception {
    rocky.playWithRock();
    woofy.playWithRock();
    String msg = rocky.getHappyMessage();
    String msg2 = woofy.getHappyMessage();
    assertEquals("I'm happy!", msg);
    assertEquals("I'm happy!", msg2);
  }

  @Test
  public void looseWeight() throws Exception {
    assertEquals(20.0, rocky.needLooseWeight(), 0.1);
    assertEquals(45.2, woofy.needLooseWeight(), 0.1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void emptyNameFail() throws Exception {
    PetRock lury = new PetRock("", 7000.8);
  }


  @Test
  public void waitForHappyTimeout() throws TestTimedOutException {
    assertEquals("1,2,3 I am good now", rocky.waitTillHappy());
    assertEquals("1,2,3,4,5 I am good now", woofy.waitTillHappy());
  }


  @Test
  public void massIsEqual() throws Exception {
    assertEquals(5000.56, rocky.getWeight(), 0.1);
    assertEquals(9000.32, woofy.getWeight(), 0.1);
  }

  @Test
  public void weightIsSame() throws Exception {
    assertNotSame("Should be 5000.56", rocky.getWeight(), 5000.56);
  }

  @Test
  public void weightIsSameTrue() throws Exception {
    assertTrue("Should be 5000.56", Double.compare(5000.56, rocky.getWeight()) == 0);
  }

  @Test
  public void messageTest() {
    assertEquals("The Pet named Rocky weighted 5000.56 is healthy", rocky.toString());
    assertEquals("The Pet named Woofy weighted 9000.32 is healthy", woofy.toString());
  }
}