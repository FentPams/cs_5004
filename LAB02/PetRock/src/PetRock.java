public class PetRock {

  private String name;
  private boolean happy;
  private double weight;

  /**
   * This class is for constructing info about pet
   *
   * @param name
   * @param weight happy is set as false
   */
  public PetRock(String name, double weight) {
    if (name.isEmpty()) {
      throw new IllegalArgumentException();
    }
    this.name = name;
    this.weight = weight;
    this.happy = false;
  }

  /**
   * for getting name
   *
   * @return name
   */
  public String getName() {
    return name;

  }

  /**
   * checks if the pet is happy
   *
   * @return boolean is it happy or not
   */
  public boolean isHappy() {
    return happy;
  }

  /**
   * sets happy to true if the method is called
   */
  public void playWithRock() {
    happy = true;
  }

  /**
   * print happy message
   *
   * @return string "I'm happy!"
   */
  public String getHappyMessage() {
    if (!happy) {
      throw new IllegalStateException();
    }
    return "I'm happy!";
  }

  /**
   * gets favorite number
   *
   * @return the favorite number in int
   */
  public int getFavNumber() {
    return name.equals("Rocky") ? 42 : 52;
  }

  /**
   * checks the weight needed to loose
   *
   * @return double for weight needed to loose
   */
  public double needLooseWeight() {
    return this.weight < 6000 ? 20.0 : 45.2;
  }

  /**
   * gives waiting message
   *
   * @return string for happy message
   */
  public String waitTillHappy() {
    StringBuilder sb = new StringBuilder();
    int t = name.equals("Rocky") ? 3 : 5;
    for (int i = 0; i < t; i++) {
      sb.append(",").append(i + 1);
    }
    sb.append(" I am good now");
    return sb.substring(1).toString();
  }

  /**
   * gets weight
   *
   * @return double, the weight it is
   */
  public double getWeight() {
    return this.weight;
  }

  /**
   * prints the string about pet info
   *
   * @return pet name and weight
   */
  @Override
  public String toString() {
    return ("The Pet named " + name + " weighted " + weight + " is healthy");
  }
}