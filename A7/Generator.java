/**
 * Generates random numbers between 0 and 200000.
 * CS 312 - Assignment 7
 * @author Cyrus McCollim
 * @version 1.0 11/28
 */

import java.util.Random;

public class Generator {
    /**
     * Generates random numbers from a seed and count.
     *
     * @param  args  command-line arguments
     */
    public static void main(String[] args){
        try {
            Random random = new Random(Long.parseLong(args[0]));
            int count = Integer.parseInt(args[1]);
            System.out.println(count);
            for (int i = 0; i < count; i++) {
                System.out.println(random.nextInt(200000));
            }
        } catch (Exception e){
            System.out.println("Usage: java Driver <seed> <count>");
        }
    }
}
