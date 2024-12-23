public class Driver {
    public static void main(String[] args) {
        Inventory storeInventory = new Inventory();
        storeInventory.populateItemsFromScanner();

        CLI userInterface = new CLI(storeInventory);
        userInterface.handleCommand(args);
    }
}
