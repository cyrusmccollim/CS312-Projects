/**
 * Implementation of Selection Sort.
 * CS 312 - Assignment 7
 * @author Cyrus McCollim
 * @version 1.0 11/28
 */

public class SelectionSort extends Sort {
    /**
     * Sorts an array of integers using the selection sort algorithm.
     *
     * @param  numbers  array of integers to sort
     */
    public void sort(int[] numbers){
        for (int i = 0; i < numbers.length; i++){
            int minIndex = i;
            for (int j = i; j < numbers.length; j++){
                if (numbers[j] < numbers[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = numbers[i];
            numbers[i] = numbers[minIndex];
            numbers[minIndex] = temp;
        }
    }

    public static void main(String[] args){
        Sort sorter = new SelectionSort();
        sorter.readSortPrint();
    }
}
