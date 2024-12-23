/**
 * An abstract disk represents a more specific item sold in the store.
 * CS 312 - Assignment 4
 * @author Cyrus McCollim
 * @version 1.0 10/24/24
 */
public abstract class Disk extends Item {
    protected int releaseYear;

    /**
     * Returns false, disks do not have the author attribute.
     *
     * @return false.
     */
    public boolean hasAuthor(String key) {
        return false;
    }
}
