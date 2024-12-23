/**
 * A DVD represents a specific type of disk sold in the store.
 * CS 312 - Assignment 4
 * @author Cyrus McCollim
 * @version 1.0 10/24/24
 */
public class DVD extends Disk {
    protected String studio;
    protected Condition condition;

    public DVD(String title, double price, int releaseYear, String studio, Condition condition){
        this.title = title;
        this.cost = price;
        this.releaseYear = releaseYear;
        this.studio = studio;
        this.condition = condition;
    }

    /**
     * Returns the attributes of this class in the data file format.
     *
     * @return attributes of this class separated by semicolons as a String.
     */
    @Override
    public String toString() {
        return title + ";" + "DVD" + ";" + cost + ";" + studio + ";" + condition.toString();
    }

    /**
     * Returns the attributes of this class in a human-readable format.
     *
     * @return attributes of this class as a String.
     */
    public String toReadableString(){
        return "Title: " + title +
                "\nType: " + "DVD" +
                "\nCost: " + cost +
                "\nReleased: " + releaseYear +
                "\nStudio: " + studio +
                "\nCondition: " + condition.toString();
    }
}
