/**
 * Implementation of Heap Sort.
 * CS 312 - Assignment 7
 * @author Cyrus McCollim
 * @version 1.0 11/28
 */

import java.util.ArrayList;

public class HeapSort extends Sort {
    private class Heap {
        private ArrayList<Integer> heapList;

        public Heap(int[] numbers){
            heapList = new ArrayList<>();
            for (int number : numbers){
                add(number);
            }
        }

        /**
         * Helper methods that determine whether a children/parent exists and retrieves their indices.
         *
         * @param  index  the index of the current node
         */
        private int leftIndex(int index) { return 2 * index + 1; }
        private boolean hasLeft(int index) { return leftIndex(index) < heapList.size(); }
        private int rightIndex(int index) { return 2 * index + 2; }
        private boolean hasRight(int index) { return rightIndex(index) < heapList.size(); }
        private int parentIndex(int index) { return (index - 1) / 2; }
        private boolean hasParent(int index) { return parentIndex(index) >= 0; }

        /**
         * Adds a new number to this heap.
         *
         * @param  number  the value to add
         */
        private void add(int number) {
            heapList.add(number);
            heapifyUp();
        }

        /**
         * Retrieves the root node of this heap
         *
         * @return the root node
         */
        private Integer pull(){
            int pulled;
            swap(heapList.size()-1, 0);
            pulled = heapList.remove(heapList.size()-1);
            heapifyDown();
            return pulled;
        }

        /**
         * Corrects the heap by moving the last node to the appropriate position.
         */
        private void heapifyUp() {
            int index = heapList.size() - 1;
            while (hasParent(index) && heapList.get(index) < heapList.get(parentIndex(index))){
                swap(index, parentIndex(index));
                index = parentIndex(index);
            }
        }

        /**
         * Corrects the heap by moving the first node to the appropriate position.
         */
        private void heapifyDown() {
            int index = 0;
            while ((hasLeft(index) && heapList.get(leftIndex(index)) < heapList.get(index)) || (hasRight(index) && heapList.get(rightIndex(index)) < heapList.get(index))){
                int smallerIndex;
                if (hasLeft(index) && hasRight(index)) {
                    smallerIndex = (heapList.get(leftIndex(index)) < heapList.get(rightIndex(index)))? leftIndex(index) : rightIndex(index);
                } else if (hasLeft(index)) {
                    smallerIndex = leftIndex(index);
                } else {
                    smallerIndex = rightIndex(index);
                }

                swap(smallerIndex, index);
                index = smallerIndex;
            }
        }

        /**
         * Swaps the values of two nodes.
         *
         * @param indexOne the index of the first node
         * @param indexTwo the index of the second node
         */
        private void swap(int indexOne, int indexTwo) {
            if (indexOne < heapList.size() && indexTwo < heapList.size()) {
                int temp = heapList.get(indexOne);
                heapList.set(indexOne, heapList.get(indexTwo));
                heapList.set(indexTwo, temp);
            }
        }

        /**
         * Returns whether the heap is empty.
         *
         * @return true is the heap is empty, false otherwise
         */
        public boolean isEmpty(){
            return heapList.isEmpty();
        }
    }

    /**
     * Sorts an array of integers using a heap.
     *
     * @param  numbers  array of integers to sort
     */
    public void sort(int[] numbers) {
        Heap heap = new Heap(numbers);
        int index = 0;
        while (!heap.isEmpty()) {
            numbers[index] = heap.pull();
            index++;
        }
    }

    public static void main(String[] args){
        Sort sorter = new HeapSort();
        sorter.readSortPrint();
    }
}
