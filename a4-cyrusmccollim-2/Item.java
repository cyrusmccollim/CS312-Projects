/**
 * An abstract item represents something sold in the store.
 * CS 312 - Assignment 4
 * @author Cyrus McCollim
 * @version 1.0 10/24/24
 */
public abstract class Item {
    protected String title;
    protected double cost;
    public enum Condition{USED, NEW}

    /**
     * Returns true if the string key matches the title of this item.
     *
     * @return whether the key matches the title.
     */
    public boolean hasTitle(String key) {
        return title.equalsIgnoreCase(key);
    }

    /**
     * Returns true if the string key matches the author of this item.
     *
     * @return whether the key matches the author.
     */
    public abstract boolean hasAuthor(String key);

    /**
     * Returns the attributes of this class in the data file format.
     *
     * @return attributes of this class separated by semicolons as a String.
     */
    @Override
    public abstract String toString();

    /**
     * Returns the attributes of this class in a human-readable format.
     *
     * @return attributes of this class as a String.
     */
    public abstract String toReadableString();
}
