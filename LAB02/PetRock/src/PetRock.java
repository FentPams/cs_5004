public class PetRock {

  private String name;
  private boolean happy;
  private double weight;

  public PetRock(String name, double weight) {
    if (name.isEmpty()) {
      throw new IllegalArgumentException();
    }
    this.name = name;
    this.weight = weight;
    this.happy = false;
  }

  public String getName() {
    return name;

  }

  public boolean isHappy() {
    return happy;
  }

  public void playWithRock() {
    happy = true;
  }

  public String getHappyMessage() {
    if (!happy) {
      throw new IllegalStateException();
    }
    return "I'm happy!";
  }

  public int getFavNumber() {
    return name.equals("Rocky") ? 42 : 52;
  }

  public double needLooseWeight() {
    return this.weight < 6000 ? 20.0 : 45.2;
  }

  /* *
   This will throw TimeoutException
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
  public double getWeight() {
    return this.weight;
  }

  @Override
  public String toString() {
    return ("The Pet named " + name + " weighted " + weight + " is healthy");
  }
}