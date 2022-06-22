/**
 * Programmer: Xinyi Feng
 * LAB 07 -- Triangle
 * Date : 22, June, 2022
 */
import static java.lang.Math.sqrt;

public class Triangle extends AbstractShape {

  private final Point2D point2;
  private final Point2D point3;

  /**
   * Constructs a triangle object with the given location of its reference point and other two
   * points
   *
   * @param p1 The first point as reference
   * @param p2 The second point
   * @param p3 The third point
   * @throw IllegalArgumentException
   */
  public Triangle(Point2D p1, Point2D p2, Point2D p3) throws IllegalArgumentException {
    super(p1);
    // if three points are unique, triangle can be constructed
    if (!checkThreePoints(p1, p2, p3)) {
      this.point2 = p2;
      this.point3 = p3;
    } else {
      throw new IllegalArgumentException("The points are not unique");
    }
  }

  /**
   * second constructor call the first constructor
   *
   * @param x1,x2,y1,y2,x3,y3, 6 double, each two will construct a point
   */
  public Triangle(double x1, double y1, double x2, double y2, double x3, double y3)
      throws IllegalArgumentException {
    this(new Point2D(x1, y1), new Point2D(x2, y2), new Point2D(x3, y3));
  }


  /**
   * Computes and returns the area of this shape. Area of triangle =  (Ax(By -Cy) + Bx(Cy -Ay) +
   * Cx(Ay - By))/2 Read more:
   * https://www.java67.com/2016/10/how-to-calculate-area-of-triangle-in.html#ixzz7Wv6Dy1Gl
   *
   * @return the area of the shape
   */
  @Override
  public double area() {
    return (this.reference.getX() * (this.point2.getY() - this.point3.getY()) + this.point2.getX() *
        (this.point3.getY() - this.reference.getY()) + this.point3.getX() *
        (this.reference.getY() - this.point2.getY())) / 2;
  }

  /**
   * Computes and returns the perimeter of this shape. invoke private helper method by adding three
   * sides
   *
   * @return the perimeter of the shape
   */
  @Override
  public double perimeter() {
    return calculateDistance(this.reference, point2) + calculateDistance(this.reference, point3)
        + calculateDistance(point2, point3);
  }

  /**
   * Create and return a shape of the same kind as this one, resized in area by the provided factor
   *
   * @param factor factor of resizing
   * @return the resized Shape
   */
  @Override
  public Shape resize(double factor) {
    double lambda = sqrt(factor);
    double x1 = this.reference.getX();
    double y1 = this.reference.getY();
    double x2 = this.point2.getX();
    double y2 = this.point2.getY();
    double x3 = this.point3.getX();
    double y3 = this.point3.getY();
    Point2D newPoint2 = new Point2D(x1 + lambda * (x2 - x1), y1 + lambda * (y2 - y1));
    Point2D newPoint3 = new Point2D(x1 + lambda * (x3 - x1), y1 + lambda * (y3 - y1));
    return new Triangle(this.reference, newPoint2, newPoint3);
  }

  /**
   * check if two points are unique
   *
   * @param a point2d
   * @param b point2d
   * @return true if two points are not unique
   */
  private boolean checkPoints(Point2D a, Point2D b) {
    return a.getX() == b.getX() && a.getY() == b.getY();
  }

  /**
   * checks if three points are unique based on check points method
   *
   * @param a point2d
   * @param b point2d
   * @param c point2d
   * @return boolean, if three points are not unique, return True
   */
  private boolean checkThreePoints(Point2D a, Point2D b, Point2D c) {
    return checkPoints(a, b) && checkPoints(a, c) && checkPoints(b, c);
  }

  /**
   * calculates the side of triangle
   *
   * @param x point2d
   * @param y point2d
   * @return double, the side of triangle
   */
  private double calculateDistance(Point2D x, Point2D y) {
    return sqrt(
        (x.getY() - y.getY()) * (x.getY() - y.getY()) + (x.getX() - y.getX()) * (x.getX()
            - y.getX()));
  }

  /**
   * to string method to display three points of the triangle
   *
   * @return string
   */
  public String toString() {
    return String.format(
        "Triangle: Reference point:(%.3f,%.3f) Second point:(%.3f,%.3f) Third point:(%.3f,%.3f)",
        this.reference.getX(), this.reference.getY(), this.point2.getX(), this
            .point2.getY(), this.point3.getX(), this.point3.getY());
  }

}

