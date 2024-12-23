/**
 * Point (abstract) provides the methods used by all points.
 * CS312 - Assignment 1
 * @author Cyrus M.
 * @version 1.0 9/12
 */
public abstract class Point implements Translation, Rotation {
    public abstract void translate(double dx, double dy);
    public abstract void rotate(double degrees);
    public abstract String toString();
}
