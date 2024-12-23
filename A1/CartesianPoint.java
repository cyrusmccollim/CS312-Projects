/**
 * CartesianPoint allows data for a point that maintains an x and y coordinate to be stored.
 * CS312 - Assignment 1
 * @author Cyrus M.
 * @version 1.0 9/12
 */
public class CartesianPoint extends Point {
    private double x;
    private double y;

    public CartesianPoint (double x, double y){
        this.x = x;
        this.y = y;
    }

    /**
     * Updates the angle and radius of the CartesianPoint after a translation of the x and y positions.
     *
     * @param dx - change in x direction
     * @param dy - change in y direction
     */
    public void translate(double dx, double dy){
        x += dx;
        y += dy;
    }

    /**
     * Updates the angle of the CartesianPoint after a rotation by degrees.
     *
     * @param degrees - the change in degrees
     */
    public void rotate(double degrees){
        double newRadius = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        double newAngle = Math.toDegrees(Math.atan(y / x)) + degrees;
        x = newRadius * Math.cos(Math.toRadians(newAngle));
        y = newRadius * Math.sin(Math.toRadians(newAngle));
    }

    /**
     * @return - the angle and radius as a string.
     */
    @Override
    public String toString(){
        return "X: " + Math.round(x) + " | Y: " + Math.round(y);
    }
}