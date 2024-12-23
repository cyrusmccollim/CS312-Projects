/**
 * Stores and manages the inverted index.
 * CS 312 - Assignment 9
 * @author Cyrus McCollim
 * @version 1.0 12/15/24
 */

import java.util.*;

public class SearchEngine {
    private StopList stopList;
    private HashMap<String, HashSet<Document>> index;

    /**
     * Constructs the inverted index.
     *
     * @param stopList StopList containing stop words
     * @param documents list of documents to create index from
     */
    public SearchEngine(StopList stopList, List<Document> documents) {
        this.index = new HashMap<>();
        this.stopList = stopList;

        for (Document document : documents){
            Iterator<String> wordIterator = document.iterator();
            while (wordIterator.hasNext()){
                String word = wordIterator.next().toLowerCase();

                if (stopList.isStopWord(word)) continue;

                if (index.containsKey(word)) {
                    index.get(word).add(document);
                } else {
                    HashSet<Document> documentSet = new HashSet<>();
                    documentSet.add(document);
                    index.put(word, documentSet);
                }
            }
        }
    }

    /**
     * Prints the list of documents found containing all words in the query.
     *
     * @param query user query used to search documents
     * @param verbose include content of documents if true
     */
    public void search(String query, boolean verbose){
        query = query.toLowerCase();
        HashSet<String> queryWords = new HashSet<>(List.of(query.split("\\W+")));

        HashSet<Document> finalDocuments = new HashSet<>();
        for (String word : queryWords) {
            if (stopList.isStopWord(word)) continue;

            HashSet<Document> documents = index.get(word);

            if (documents == null) {
                finalDocuments.clear();
                break;
            } else if (finalDocuments.isEmpty()) {
                finalDocuments.addAll(documents);
            } else {
                finalDocuments.retainAll(documents);
            }
        }

        if (finalDocuments.isEmpty()){
            System.out.println("No results.");
            return;
        }

        for (Document document : finalDocuments) {
            System.out.println(document.display(verbose));
        }
    }

    /**
     * Prints the inverted index in a human-readable format.
     */
    public void display(){
        for (String key : index.keySet()){
            String entry = key + " -> ";
            for (Document document : index.get(key)) {
                entry += document.display(false) + " ";
            }
            System.out.println(entry);
        }
    }
}
