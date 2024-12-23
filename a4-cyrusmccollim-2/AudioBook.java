/**
 * An audiobook represents a non-physical book sold in the store.
 * CS 312 - Assignment 4
 * @author Cyrus McCollim
 * @version 1.0 10/24/24
 */
public class AudioBook extends Book {
    protected String reader;
    protected Condition condition;

    public AudioBook(String title, double price, String author, String reader, Condition condition){
        this.title = title;
        this.cost = price;
        this.author = author;
        this.reader = reader;
        this.condition = condition;
    }

    /**
     * Returns the attributes of this class in the data file format.
     *
     * @return attributes of this class separated by semicolons as a String.
     */
    @Override
    public String toString() {
        return title + ";" + "AUDIOBOOK" + ";" + cost + ";" + author + ";" + reader + ";" + condition.toString();
    }

    /**
     * Returns the attributes of this class in a human-readable format.
     *
     * @return attributes of this class as a String.
     */
    public String toReadableString(){
        return "Title: " + title +
                "\nType: " + "AUDIOBOOK" +
                "\nCost: " + cost +
                "\nAuthor: " + author +
                "\nReader: " + reader +
                "\nCondition: " + condition.toString();
    }
}
