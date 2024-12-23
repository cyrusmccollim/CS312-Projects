/**
 * This CLI processes the user's commands to create a Tree from a list of numbers and sort them.
 * CS 312 - Assignment 6
 * @author Cyrus McCollim
 * @version 1.0 11/19
 */

import java.util.ArrayList;
import java.util.List;

public class CLI {
    private String[] args;

    public CLI (String[] args){
        this.args = args;
    }

    /**
     * Ensures that the command-line arguments are proper, creates a Tree from the input data, sorts the values Tree.
     */
    public void processCommand() {
        if (args.length < 2) {
            printUsage();
            return;
        }

        boolean timerEnabled = false;
        List<Integer> inputNumbers;

        switch (args[0]) {
            case "-t":
                timerEnabled = true;
                if (args[1].equals("-n")) {
                    inputNumbers = grabNumbers(args, 2);
                } else if (args[1].equals("-r") && isInteger(args[2])) {
                    inputNumbers = generateNumbers(Integer.parseInt(args[2]));
                } else {
                    printUsage();
                    return;
                }
                break;
            case "-n":
                inputNumbers = grabNumbers(args, 1);
                break;
            case "-r":
                if (!isInteger(args[1])) {
                    printUsage();
                    return;
                }
                inputNumbers = generateNumbers(Integer.parseInt(args[1]));
                break;
            default:
                printUsage();
                return;
        }

        Tree<Integer> usersTree = new Tree<>(inputNumbers);
        long startTime = System.currentTimeMillis();
        usersTree.sort();
        long endTime = System.currentTimeMillis();
        if (timerEnabled) System.out.println("Sorting took " + (endTime - startTime) + "ms!");
    }

    /**
     * Creates a List of the input data.
     *
     * @param args the command-line arguments from the user
     * @param startIndex the index where the list of numbers start within the list of arguments
     * @return a List of the input data
     */
    private List<Integer> grabNumbers(String[] args, int startIndex) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = startIndex; i < args.length; i++) {
            if (!isInteger(args[i])) {
                printUsage();
                System.exit(1);
            }
            numbers.add(Integer.parseInt(args[i]));
        }
        return numbers;
    }

    /**
     * Generates a List of random integers between 0 and 999.
     *
     * @param size the length of the List
     * @return the List of random integers
     */
    private List<Integer> generateNumbers(int size) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            numbers.add((int) (Math.random() * 1000));
        }
        return numbers;
    }

    /**
     * Returns true if the String can be cast as an integer.
     *
     * @param s the String to check
     * @return if the String can be cast as an integer
     */
    private boolean isInteger(String s){
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    /**
     * Prints the proper usage for the CLI.
     */
    private void printUsage(){
        System.out.println("\njava Driver [-t] [-n <number_list> | -r <count>]" +
                           "\n-t is an optional flag that causes the time taken while sorting to be printed" +
                           "\n-n <number_list> sorts the numbers of number_list (example: -n 9 1 20 11 8)" +
                           "\n-r <count> sorts count random numbers");
    }
}
