/**
 * Implementation of Merge Sort.
 * CS 312 - Assignment 7
 * @author Cyrus McCollim
 * @version 1.0 11/28
 */

import java.util.Arrays;

public class MergeSort extends Sort {
    /**
     * Sorts an array of integers using the merge sort algorithm.
     *
     * @param  numbers  array of integers to sort
     */
    public void sort(int[] numbers){
        mergeSort(numbers, 0, numbers.length - 1);
    }

    /**
     * Recursively sorts two halves of the array then merges the two halves.
     *
     * @param  numbers  array of integers to sort
     * @param  left  index of the left side
     * @param  right  index of the right side
     */
    private void mergeSort(int[] numbers, int left, int right){
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(numbers, left, middle);
            mergeSort(numbers, middle + 1, right);
            merge(numbers, left, middle, right);
        }
    }

    /**
     * Combined sorted smaller arrays into one sorted array.
     *
     * @param  numbers  array of integers to sort
     * @param  left  index of the left side
     * @param  middle  index of the midpoint
     * @param  right  index of the right side
     */
    private void merge(int[] numbers, int left, int middle, int right){
        int[] leftArray = Arrays.copyOfRange(numbers, left, middle + 1);
        int[] rightArray = Arrays.copyOfRange(numbers, middle + 1, right + 1);

        int i = 0;
        int j = 0;
        int k = left;

        while ((i < middle - left + 1) && (j < right - middle)){
            if (leftArray[i] <= rightArray[j]){
                numbers[k] = leftArray[i];
                i++;
            } else {
                numbers[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < middle - left + 1){
            numbers[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < right - middle){
            numbers[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args){
        Sort sorter = new MergeSort();
        sorter.readSortPrint();
    }
}
