/**
 * A generic tree where all Node values are less than their children's.
 * CS 312 - Assignment 6
 * @author Cyrus McCollim
 * @version 1.0 11/19
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Tree <T extends Comparable<T>> {
    private Node tree;

    private class Node {
        private T value;
        private Node left;
        private Node right;

        public Node(T value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        public Node(T value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        /**
         * Updates this Node's value by recursively replacing it with the value from the smaller child.
         *
         * @param parent the parent of the current subtree
         * @param isLeft whether the current node is a left subtree (as opposed to the right subtree)
         *
         * @return true if the tree still has data, false if not
         */
        private boolean update(Node parent, boolean isLeft) {
            // Root has no children.
            if (left == null && right == null) {
                if (parent == null) {
                    return false;
                } else {
                    if (isLeft) parent.left = null;
                    if (!isLeft) parent.right = null;
                    return true;
                }
            }

            // Root has only right child.
            if (left == null) {
                value = right.value;
                right.update(this, false);
                return true;
            }

            // Root has only left child.
            if (right == null) {
                value = left.value;
                left.update(this, true);
                return true;
            }

            // Root has two children.
            if (left.value.compareTo(right.value) < 0) {
                value = left.value;
                left.update(this, true);
            } else {
                value = right.value;
                right.update(this, false);
            }
            return true;
        }

        /**
         * Returns the difference between two Nodes.
         *
         * @param other the Node to compare against
         * @return difference between two node values
         */
        private int compareTo(Node other){
            return this.value.compareTo(other.value);
        }


        /**
         * Creates a true copy of the subtree below this Node.
         *
         * @return the Node pointing to the rest of the copied tree
         */
        private Node copy() {
            Node left = null;
            Node right = null;
            if (this.left != null) {
                left = this.left.copy();
            }
            if (this.right != null) {
                right = this.right.copy();
            }
            return new Node(value, left, right);
        }
    }

    /**
     * Construct a tree from a List of values.
     *
     * @param values the list to make the tree of
     */
    public Tree(List<T> values) {
        Queue<Node> queue = new LinkedList<>();

        for (T item : values) {
            queue.add(new Node(item));
        }

        while(queue.size() > 1){
            Node T1 = queue.remove();
            Node T2 = queue.remove();

            Node T3;
            if (T1.compareTo(T2) < 0) {
                T3 = new Node(T1.value);
                boolean hasRemainingData = T1.update(null, false);
                T3.left = (hasRemainingData)? T1 : null;
                T3.right = T2;
            } else {
                T3 = new Node(T2.value);
                boolean hasRemainingData = T2.update(null, false);
                T3.left = (hasRemainingData)? T2 : null;
                T3.right = T1;
            }

            queue.add(T3);
        }

        tree = queue.remove();
    }

    /**
     * Perform a tree sort.
     *
     * @return the sorted list
     */
    public List<T> sort(){
        Node treeCopy = this.tree.copy();

        List<T> finalList = new ArrayList<>();

        while (treeCopy != null) {
            finalList.add(treeCopy.value);
            if (!treeCopy.update(null, false)) {
                treeCopy = null;
            }
        }

        return finalList;
    }
}
