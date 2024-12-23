/**
 * An abstract superclass for sorts.
 * CS 312 - Assignment 7
 * @author Cyrus McCollim
 * @version 3.2 11/27
 */

import java.util.Scanner;

abstract class Sort {
    /**
     * Sorts an array of integers.
     *
     * @param  numbers  array of integers to sort
     */
    public abstract void sort(int[] numbers);

    /**
     * Reads in an integer array through standard in.
     *
     * @return the array of integers
     */
    public int[] readArray(){
        Scanner input = new Scanner(System.in);

        int[] numbers = null;
        try {
            numbers = new int[Integer.parseInt(input.nextLine())];

            int index = 0;
            while(input.hasNextLine()){
                numbers[index] = Integer.parseInt(input.nextLine());
                index++;
            }
        } catch (Exception ignored) {
            System.out.println("Invalid usage, use redirection with an integer list.");
            System.exit(1);
        }

        return numbers;
    }

    /**
     * Sorts an array of integers.
     *
     * @param  numbers  array of integers to sort
     */
    public void printArray(int[] numbers) {
        for (int number : numbers)
            System.out.println(number);
    }

    /**
     * Reads in an integer array, sorts it, then prints.
     */
    public void readSortPrint() {
        int[] numbers = readArray();
        sort(numbers);
        printArray(numbers);
    }
}
