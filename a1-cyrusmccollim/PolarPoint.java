/**
 * PolarPoint allows data for a point that maintains an angle and radius to be stored.
 * CS312 - Assignment 1
 * @author Cyrus M.
 * @version 1.0 9/12
 */
public class PolarPoint extends Point {
    private double angle; /* In Degrees */
    private double radius;

    public PolarPoint(double angle, double radius){
        this.angle = angle;
        this.radius = radius;
    }

    /**
     * Updates the angle and radius of the PolarPoint after a translation of the x and y positions.
     *
     * @param dx - change in x direction
     * @param dy - change in y direction
     */
    public void translate(double dx, double dy){
        double newX = radius * Math.cos(Math.toRadians(angle)) + dx;
        double newY = radius * Math.sin(Math.toRadians(angle)) + dy;
        angle = Math.toDegrees(Math.atan2(newY, newX));
        radius = Math.sqrt(Math.pow(newX, 2) + Math.pow(newY, 2));
    }

    /**
     * Updates the angle of the PolarPoint after a rotation by degrees.
     *
     * @param degrees - the change in degrees
     */
    public void rotate(double degrees){
        angle += degrees;
    }

    /**
     * @return - the angle and radius as a string.
     */
    @Override
    public String toString(){
        return "θ: " + Math.round(angle) + " | R: " + Math.round(radius);
    }
}
