import java.util.ArrayList;
import java.util.Scanner;

/**
 * The inventory represents the store's collection of items.
 * CS 312 - Assignment 4
 * @author Cyrus McCollim
 * @version 1.0 10/24/24
 */
public class Inventory {
    protected ArrayList<Item> items;
    public enum SearchType{ALL, TITLE, AUTHOR}

    public Inventory() {
        items = new ArrayList<>();
    }

    /**
     * Adds an item to the collection of items in this inventory.
     *
     * @param item the item to add.
     */
    public void addItem(Item item) {
        items.add(item);
    }

    /**
     * Adds an item to the collection of items in this inventory.
     *
     * @param searchType the attribute the key is compared against while searching the inventory. Can be TITLE, AUTHOR, or ALL.
     * @param key String to compare against an attribute while searching the inventory.
     * @param useDataFileFormat true if the returned list of matching items is written in the data file format, and false if human-readable.
     */
    public String lookupItems(SearchType searchType, String key, boolean useDataFileFormat) {
        StringBuilder matchingItems = new StringBuilder();
        for (Item item : items) {
            boolean addThisItem = false;

            if (searchType.equals(SearchType.TITLE) && item.hasTitle(key))      addThisItem = true;
            if (searchType.equals(SearchType.AUTHOR) && item.hasAuthor(key))    addThisItem = true;
            if (searchType.equals(SearchType.ALL))                              addThisItem = true;

            if (addThisItem){
                matchingItems.append("\n").append((useDataFileFormat)? item : "\n" + item.toReadableString());
            }
        }
        return matchingItems.toString();
    }

    /**
     * Sells items from the collection of items.
     *
     * @param searchType the attribute the key is compared against while searching the inventory. Can be TITLE, AUTHOR, or ALL.
     * @param key String to compare against an attribute while searching the inventory.
     */
    public void sellItems(SearchType searchType, String key) {
        for (int i = 0; i < items.size(); i++) {
            boolean removeThisItem = false;

            if (searchType.equals(SearchType.TITLE) && items.get(i).hasTitle(key))      removeThisItem = true;
            if (searchType.equals(SearchType.AUTHOR) && items.get(i).hasAuthor(key))    removeThisItem = true;
            if (searchType.equals(SearchType.ALL))                                      removeThisItem = true;

            if (removeThisItem){
                items.remove(i);
                i--;
            }
        }
    }

    /**
     * Reads in items from a data file through IO redirection in the terminal. Populates this inventory with those items.
     */
    public void populateItemsFromScanner() {
        Scanner input = new Scanner(System.in);

        while(input.hasNextLine()){
            String line = input.nextLine();

            String[] lineAsArray = line.split(";");
            if (lineAsArray.length < 6) continue;

            try {
                switch (lineAsArray[1]) {
                    case "CD":
                        // Title, Type, Price, ReleaseYear, Band, Condition
                        items.add(new CD(lineAsArray[0], Double.parseDouble(lineAsArray[2]), Integer.parseInt(lineAsArray[3]), lineAsArray[4], (lineAsArray[5].equals("NEW")) ? Item.Condition.NEW : Item.Condition.USED));
                        break;
                    case "DVD":
                        // Title, Type, Price, ReleaseYear, Studio, Condition
                        items.add(new DVD(lineAsArray[0], Double.parseDouble(lineAsArray[2]), Integer.parseInt(lineAsArray[3]), lineAsArray[4], (lineAsArray[5].equals("NEW")) ? Item.Condition.NEW : Item.Condition.USED));
                        break;
                    case "BOOK":
                        // Title, Type, Price, Author, Genre, Condition
                        items.add(new PrintBook(lineAsArray[0], Double.parseDouble(lineAsArray[2]), lineAsArray[3], lineAsArray[4], (lineAsArray[5].equals("NEW")) ? Item.Condition.NEW : Item.Condition.USED));
                        break;
                    case "AUDIOBOOK":
                        // Title, Type, Price, Author, Reader, Condition
                        items.add(new AudioBook(lineAsArray[0], Double.parseDouble(lineAsArray[2]), lineAsArray[3], lineAsArray[4], (lineAsArray[5].equals("NEW")) ? Item.Condition.NEW : Item.Condition.USED));
                        break;
                }
            } catch (Exception ignored){ }
        }
    }
}
