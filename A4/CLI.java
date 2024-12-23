import java.util.ArrayList;
import java.util.Arrays;

/**
 * The command-line interface handles the user's management of the store's inventory.
 * CS 312 - Assignment 4
 * @author Cyrus McCollim
 * @version 1.0 10/24/24
 */
public class CLI {
    Inventory inventory;

    public CLI(Inventory inventory) {
        this.inventory = inventory;
    }

    /**
     * Processes the user's commands to manage the store's inventory.
     *
     * @param args the arguments from the user as an array of strings.
     */
    public void handleCommand(String[] args) {
        if (!hasProperUsage(args)){
            System.out.println("Usage: java Driver [-d|-a|-s] <options>" +
                                "\n(display) -d [(everything by default) | -t \"title\" | -a \"author\" ]" +
                                "\n(add) -a DVD \"title\" cost year \"studio\" [ NEW|USED ]" +
                                "\n(add) -a CD \"title\" cost year \"band\" [ NEW|USED ]" +
                                "\n(add) -a BOOK \"title\" cost author genre [ NEW|USED ]" +
                                "\n(add) -a AUDIOBOOK \"title\" cost author \"reader\" [ NEW|USED ]" +
                                "\n(sell all) -s [-t title | -a author]");
            return;
        }

        switch (args[0]) {
            case "-d":
                if (args.length == 1) {
                    System.out.println(inventory.lookupItems(Inventory.SearchType.ALL, "", false));
                    break;
                }
                if (args[1].equals("-t"))  System.out.println(inventory.lookupItems(Inventory.SearchType.TITLE, args[2], false));
                if (args[1].equals("-a"))  System.out.println(inventory.lookupItems(Inventory.SearchType.AUTHOR, args[2], false));

                break;
            case "-a":
                if (args[1].equals("CD"))         inventory.addItem(new CD(args[2], Double.parseDouble(args[3]), Integer.parseInt(args[4]), args[5], (args[6]).equals("NEW")? Item.Condition.NEW : Item.Condition.USED));
                if (args[1].equals("DVD"))        inventory.addItem(new DVD(args[2], Double.parseDouble(args[3]), Integer.parseInt(args[4]), args[5], (args[6]).equals("NEW")? Item.Condition.NEW : Item.Condition.USED));
                if (args[1].equals("BOOK"))       inventory.addItem(new PrintBook(args[2], Double.parseDouble(args[3]), args[4], args[5], (args[6]).equals("NEW")? Item.Condition.NEW : Item.Condition.USED));
                if (args[1].equals("AUDIOBOOK"))  inventory.addItem(new AudioBook(args[2], Double.parseDouble(args[3]), args[4], args[5], (args[6]).equals("NEW")? Item.Condition.NEW : Item.Condition.USED));

                System.out.println(inventory.lookupItems(Inventory.SearchType.ALL, "", true));

                break;
            case "-s":
                if (args.length == 1) {
                    inventory.sellItems(Inventory.SearchType.ALL, "");
                    break;
                }
                if (args[1].equals("-t"))  inventory.sellItems(Inventory.SearchType.TITLE, args[2]);
                if (args[1].equals("-a"))  inventory.sellItems(Inventory.SearchType.AUTHOR, args[2]);

                System.out.println(inventory.lookupItems(Inventory.SearchType.ALL, "", true));

                break;
        }
    }

    /**
     * Returns true if the arguments have proper usage.
     *
     * @param args the arguments from the user as an array of strings.
     * @return true when there are no problems with the arguments.
     */
    private boolean hasProperUsage(String[] args){
        if (args.length == 0) {
            return false;
        }

        boolean usageIsValid;
        switch (args[0]) {
            case "-d", "-s":
                ArrayList<String> validOptions = new ArrayList<>(Arrays.asList("-t", "-a"));
                usageIsValid = args.length == 1 || (args.length == 3 && validOptions.contains(args[1]));
                break;
            case "-a":
                ArrayList<String> validItems = new ArrayList<>(Arrays.asList("DVD", "CD", "BOOK", "AUDIOBOOK"));
                ArrayList<String> validConditions = new ArrayList<>(Arrays.asList("NEW", "USED"));
                usageIsValid = args.length == 7 && validItems.contains(args[1]) && validConditions.contains(args[6]) && isDouble(args[3]);
                break;
            default:
                usageIsValid = false;
                break;
        }

        return usageIsValid;
    }

    /**
     * Returns true if a string can be converted to a double.
     *
     * @param s the string to check.
     * @return true when the string is convertible to a double.
     */
    private static boolean isDouble(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
