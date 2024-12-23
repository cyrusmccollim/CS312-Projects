/**
 * Stores and manages text files used by the SearchEngine.
 * CS 312 - Assignment 9
 * @author Cyrus McCollim
 * @version 1.0 12/15/24
 */

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Scanner;

public class Document {
    private String fileName;
    private String contents;

    public Document(String fileName){
        this.fileName = fileName;
        this.contents = "";
        try {
            contents = new String(Files.readAllBytes(Paths.get(fileName)));
        } catch (Exception ignored){ }
    }

    /**
     * Returns an Iterator allowing traversal of this document's words.
     *
     */
    public Iterator<String> iterator() {
        return new Scanner(contents).useDelimiter("\\W+");
    }

    /**
     * Returns the name/contents of this document.
     *
     * @param verbose include content of document if true
     */
    public String display(boolean verbose){
        return fileName + ((verbose)? ("\n" + contents + "\n") : "");
    }
}
