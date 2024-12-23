/**
 * A print book represents a physical book sold in the store.
 * CS 312 - Assignment 4
 * @author Cyrus McCollim
 * @version 1.0 10/24/24
 */
public class PrintBook extends Book {
    protected String genre;
    protected Condition condition;

    public PrintBook(String title, double price, String author, String genre, Condition condition){
        this.title = title;
        this.cost = price;
        this.author = author;
        this.genre = genre;
        this.condition = condition;
    }

    /**
     * Returns the attributes of this class in the data file format.
     *
     * @return attributes of this class separated by semicolons as a String.
     */
    @Override
    public String toString() {
        return title + ";" + "BOOK" + ";" + cost + ";" + author + ";" + genre + ";" + condition.toString();
    }

    /**
     * Returns the attributes of this class in a human-readable format.
     *
     * @return attributes of this class as a String.
     */
    public String toReadableString(){
        return "Title: " + title +
                "\nType: " + "BOOK" +
                "\nCost: " + cost +
                "\nAuthor: " + author +
                "\nGenre: " + genre +
                "\nCondition: " + condition.toString();
    }
}
