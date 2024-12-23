/**
 * Tester is the entry into this program. The functionality of the Polar and Cartesian classes are tested.
 * CS312 - Assignment 1
 * @author Cyrus M.
 * @version 1.0 9/12
 */
public class Tester {
    /**
     * Tests the PolarPoint and CartesianPoint classes by making objects and translating/rotating them by random values.
     */
    public static void main (String[] args){
        Point p1 = new PolarPoint(50, 10);
        System.out.println("Initial -> " + p1);
        p1.translate(9, 13);
        System.out.println("After Translation -> " + p1 + " (X + 9, Y + 13)");
        p1.rotate(77);
        System.out.println("After Rotation -> " + p1 + " (θ + 77)");

        Point p2 = new PolarPoint(-268, 8.5);
        System.out.println("Initial -> " + p2);
        p2.translate(80, -35);
        System.out.println("After Translation -> " + p2 + " (X + 80, Y - 35)");
        p2.rotate(90);
        System.out.println("After Rotation -> " + p2 + " (θ + 90)");

        Point c1 = new CartesianPoint(0, 0);
        System.out.println("Initial -> " + c1);
        c1.translate(-0.5, 440);
        System.out.println("After Translation -> " + c1 + " (X - 0.5, Y + 440)");
        c1.rotate(100);
        System.out.println("After Rotation -> " + c1 + " (θ + 100)");

        Point c2 = new CartesianPoint(476, 62);
        System.out.println("Initial -> " + c2);
        c2.translate(-744, 9);
        System.out.println("After Translation -> " + c2 + " (X - 744, Y + 9)");
        c2.rotate(360);
        System.out.println("After Rotation -> " + c2 + " (θ + 360)");
    }
}
