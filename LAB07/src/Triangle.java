import static java.lang.Math.sqrt;

public class Triangle extends AbstractShape {

  private Point2D point1;
  private Point2D point2;

  /**
   * Constructs a triangle object with the given location of its reference point and other two
   * points
   *
   * @param x  x coordinate of the reference point of this triangle
   * @param y  y coordinate of the reference point of this triangle
   * @param p1 The second point
   * @param p2 The third point
   */
  public Triangle(double x, double y, Point2D p1, Point2D p2) throws IllegalArgumentException {
    super(new Point2D(x, y));
    if (!checkPoints(p1, p2)) {
      this.point1 = p1;
      this.point2 = p2;
    } else {
      throw new IllegalArgumentException("The two points are not unique");
    }
  }

  public Triangle(double x, double y, double x1, double y1, double x2, double y2) {
    super(new Point2D(x, y));
    if (!checkThreePoints(x, y, x1, y1, x2, y2)) {
      this.point1 = new Point2D(x1, y1);
      this.point2 = new Point2D(x2, y2);
    } else {
      throw new IllegalArgumentException("The two points are not unique");
    }
  }


  /**
   * Computes and returns the area of this shape.
   *
   * @return the area of the shape
   */
  @Override
  public double area() {
    return (this.reference.getX() * (this.point1.getY() - this.point2.getY()) + this.point1.getX() *
        (this.point2.getY() - this.reference.getY()) + this.point2.getX() *
        (this.reference.getY() - this.point1.getY())) / 2;
  }

  /**
   * Computes and returns the perimeter of this shape.
   *
   * @return the perimeter of the shape
   */
  @Override
  public double perimeter() {
    return calculateDistance(this.reference, point1) + calculateDistance(this.reference, point2)
        + calculateDistance(point2, point1);
  }

  /**
   * Create and return a shape of the same kind as this one, resized in area by the provided factor
   *
   * @param factor factor of resizing
   * @return the resized Shape
   */
  @Override
  public Shape resize(double factor) {
    return null;
  }

  private boolean checkPoints(Point2D a, Point2D b) {
    return a.getX() == b.getX() && a.getY() == b.getY() && a.distToOrigin() == b.distToOrigin();
  }

  private boolean checkThreePoints(double x, double y, double x1, double y1, double x2, double y2) {
    return (Double.compare(x, x1) == 0 && Double.compare(x, x2) == 0 && Double.compare(x1, x2) == 0
        && Double.compare(y, y1) == 0 && Double.compare(y, y2) == 0 && Double.compare(y1, y2) == 0);
  }

  private double calculateDistance(Point2D x, Point2D y) {
    return sqrt(
        (x.getY() - y.getY()) * x.getY() - y.getY() + x.getX() - y.getX() * x.getX() - y.getX());
  }

  public String toString() {
    return String.format(
        "Triangle: Reference point:(%.3f,%.3f) Second point:(%.3f,%.3f) Third point:(%.3f,%.3f)",
        this.reference.getX(), this.reference.getY(), this.point1.getX(), this
            .point1.getY(), this.point2.getX(), this.point2.getY());
  }

}

