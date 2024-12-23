/**
 * Entry into the program.
 * CS 312 - Assignment 9
 * @author Cyrus McCollim
 * @version 1.0 12/15/24
 */

public class Driver {
    public static void main(String[] args){
        CLI userInterface = new CLI(args);
        userInterface.start();
    }
}
