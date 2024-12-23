/**
 * Main entry point into the program.
 * CS 312 - Assignment 6
 * @author Cyrus McCollim
 * @version 1.0 11/19
 */

public class Driver {
    public static void main(String[] args) {
        CLI userInterface = new CLI(args);
        userInterface.processCommand();
    }
}
