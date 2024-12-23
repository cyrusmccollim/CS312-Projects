/**
 * Stores the words the SearchEngine ignores during indexing and querying.
 * CS 312 - Assignment 9
 * @author Cyrus McCollim
 * @version 1.0 12/15/24
 */

import java.util.HashSet;
import java.util.Iterator;

public class StopList {
    private HashSet<String> stopWords;

    public StopList(String fileName){
        stopWords = new HashSet<>();
        Document stopWordsDocument = new Document(fileName);
        Iterator<String> wordIterator = stopWordsDocument.iterator();
        while (wordIterator.hasNext()){
            stopWords.add(wordIterator.next().toLowerCase());
        }
    }

    /**
     * Returns true if the String is a stop word.
     *
     * @param word the String to check
     * @return true if word is a stop word
     */
    public boolean isStopWord(String word){
        return stopWords.contains(word.toLowerCase());
    }
}
