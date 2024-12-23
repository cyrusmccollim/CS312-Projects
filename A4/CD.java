/**
 * A CD represents a specific type of disk sold in the store.
 * CS 312 - Assignment 4
 * @author Cyrus McCollim
 * @version 1.0 10/24/24
 */
public class CD extends Disk {
    protected String band;
    protected Condition condition;

    public CD(String title, double price, int releaseYear, String band, Condition condition){
        this.title = title;
        this.cost = price;
        this.releaseYear = releaseYear;
        this.band = band;
        this.condition = condition;
    }

    /**
     * Returns the attributes of this class in the data file format.
     *
     * @return attributes of this class separated by semicolons as a String.
     */
    @Override
    public String toString() {
        return title + ";" + "CD" + ";" + cost + ";" + band + ";" + condition.toString();
    }

    /**
     * Returns the attributes of this class in a human-readable format.
     *
     * @return attributes of this class as a String.
     */
    public String toReadableString(){
        return "Title: " + title +
                "\nType: " + "CD" +
                "\nCost: " + cost +
                "\nReleased: " + releaseYear +
                "\nBand: " + band +
                "\nCondition: " + condition.toString();
    }
}
