/**
 * Implementation of Bubble Sort.
 * CS 312 - Assignment 7
 * @author Cyrus McCollim
 * @version 1.0 11/28
 */
public class BubbleSort extends Sort {
    /**
     * Sorts an array of integers using the bubble sort algorithm.
     *
     * @param  numbers  array of integers to sort
     */
    public void sort(int[] numbers){
        boolean swapped = true;
        while (swapped){
            swapped = false;
            for (int i = 1; i < numbers.length; i++){
                if (numbers[i] < numbers[i -1]){
                    int temp = numbers[i - 1];
                    numbers[i - 1] = numbers[i];
                    numbers[i] = temp;
                    swapped = true;
                }
            }
        }
    }

    public static void main(String[] args){
        Sort sorter = new BubbleSort();
        sorter.readSortPrint();
    }
}
