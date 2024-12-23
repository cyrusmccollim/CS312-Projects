/**
 * Implementation of Insertion Sort.
 * CS 312 - Assignment 7
 * @author Cyrus McCollim
 * @version 1.0 11/28
 */

public class InsertionSort extends Sort {
    /**
     * Sorts an array of integers using the insertion sort algorithm.
     *
     * @param  numbers  array of integers to sort
     */
    public void sort(int[] numbers){
        for (int i = 1; i < numbers.length; i++){
            int j = i - 1;
            while ((j >= 0) && numbers[j] > numbers[j + 1]){
                int temp = numbers[j];
                numbers[j] = numbers[j + 1];
                numbers[j + 1] = temp;
                j--;
            }
        }
    }

    public static void main(String[] args){
        Sort sorter = new InsertionSort();
        sorter.readSortPrint();
    }
}
