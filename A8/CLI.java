/**
 * Ensures proper usage and handles querying logic.
 * CS 312 - Assignment 9
 * @author Cyrus McCollim
 * @version 1.0 12/15/24
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CLI {
    private String[] args;

    public CLI (String[] args){
        this.args = args;
    }

    /**
     * Checks for usage, prompts user for queries, and performs the search.
     */
    public void start(){
        if (!hasValidUsage()){
            System.out.println("Usage: java Driver [-v] stoplistfile document1 ... documentN");
            System.exit(1);
        }

        boolean verbose = false;
        int stopListIndex = 0;
        int documentsStartIndex = 1;
        if (args[0].equals("-v")) {
            verbose = true;
            stopListIndex++;
            documentsStartIndex++;
        }

        StopList stopList = new StopList(args[stopListIndex]);
        List<Document> documentList = new ArrayList<>();

        for (int i = documentsStartIndex; i < args.length; i++) {
            documentList.add(new Document(args[i]));
        }

        SearchEngine searchEngine = new SearchEngine(stopList, documentList);

        long elapsedTime = 0;
        while (true){
            Scanner input = new Scanner(System.in);

            System.out.print("\n-- Enter query: ");
            String query = input.nextLine();

            if (query.equals("@@debug")) {
                searchEngine.display();
                continue;
            }

            long startTime = System.currentTimeMillis();
            searchEngine.search(query, verbose);
            long stopTime = System.currentTimeMillis();
            elapsedTime += (stopTime - startTime);
            System.out.print("(" + elapsedTime + "ms spent on look-ups thus far)");
        }
    }

    /**
     * Returns whether the arguments have proper usage.
     *
     * @return true if arguments are valid
     */
    private boolean hasValidUsage(){
        return args.length >= 2 && !(args[0].equals("-v") && args.length < 3);
    }
}
