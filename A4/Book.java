/**
 * An abstract book represents a more specific item sold in the store.
 * CS 312 - Assignment 4
 * @author Cyrus McCollim
 * @version 1.0 10/24/24
 */
public abstract class Book extends Item {
    protected String author;

    /**
     * Returns true if the key matches the author of this book.
     *
     * @return whether the key matches the author.
     */
    public boolean hasAuthor(String key) {
        return author.equalsIgnoreCase(key);
    }
}
