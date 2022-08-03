/**
 * # 3, Same as InstrumentedIntSet2A, BUT extends IntSet2
 * Has bugs
 */

/**
 * An integer set that is instrumented to count the number of times an
 * element is added. It works by extending {@link IntSet2}, which
 * provides the basic set operations. It then overrides both {@link #add(int)}
 * and {@link IntSet#addAll(int...)} in order update the count in both cases.
 */
public class InstrumentedIntSet2
  extends IntSet2
  implements InstrumentedIntSet
{
  private int addCount = 0;

  @Override
  public int getAddCount() {
    return addCount;
  }

  @Override
  public void add(int value) {
    super.add(value);

    // Update the count for the one element we added:
    ++addCount;
  }

  // GOTCHA! HERE IS THE BUG, it only calss super.addall, while the super class add the elements directly to set
  // fails to call the add method in this class, and ++ add count never runs
  @Override
  public void addAll(int... values) {
    super.addAll(values);
    // Don't need to update the count because apparently super.addAll() calls
    // super.add();
    // addCount += values.length;
  }
}
