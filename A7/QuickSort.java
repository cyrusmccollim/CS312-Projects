/**
 * Implementation of Quick Sort.
 * CS 312 - Assignment 7
 * @author Cyrus McCollim
 * @version 1.0 11/28
 */

public class QuickSort extends Sort {
    /**
     * Sorts an array of integers using the quick sort algorithm.
     *
     * @param  numbers  array of integers to sort
     */
    public void sort(int[] numbers){
        quickSort(numbers, 0, numbers.length - 1);
    }

    /**
     * Recursively sorts elements before and after the pivot point.
     *
     * @param  numbers  array of integers to sort
     * @param  low  starting position of smaller array
     * @param  high  ending position of smaller array
     */
    private static void quickSort(int[] numbers, int low, int high){
        if (low < high){
            int pivotIndex = partition(numbers, low, high);
            quickSort(numbers, low, pivotIndex - 1);
            quickSort(numbers, pivotIndex + 1, high);
        }
    }

    /**
     * Rearranges array to move smaller elements to the left of the pivot point and larger ones to the right.
     *
     * @param  numbers  array of integers to sort
     * @param  low  starting position of smaller array
     * @param  high  ending position of smaller array
     */
    private static int partition(int[] numbers, int low, int high){
        int pivotIndex = numbers[high];
        int i = low - 1;

        for (int j = low; j < high; j++){
            if (numbers[j] <= pivotIndex){
                i++;
                int temp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = temp;
            }
        }

        int temp = numbers[i + 1];
        numbers[i + 1] = numbers[high];
        numbers[high] = temp;

        return i + 1;
    }

    public static void main(String[] args){
        Sort sorter = new QuickSort();
        sorter.readSortPrint();
    }
}
