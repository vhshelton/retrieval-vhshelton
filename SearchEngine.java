import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * This is my code! Its goal is to search documents by their contents
 * CS 312 - Assignment 9
 * @author Victoria Shelton
 */

public class SearchEngine {

    HashMap<String,HashSet<Document>> index = new HashMap<>();
    HashSet<Document> documents = new HashSet<>();


    // Add a document to the set of documents, and indexes its words
    public void addDoc(String filename) {
        // Format and add the doc
        Document doc = new Document(filename);
        documents.add(doc);

        // Add its words to the index
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter("[ˆa-zA-Z]+");
            // Hashset to put in the Hashmap
            HashSet<Document> tempHash = new HashSet<>();
            // read each line
            while (scanner.hasNextLine()) {
                String temp = scanner.nextLine();
                temp = temp.trim().toLowerCase();
                // If the word already exists, add on to the doc list
                if(index.containsKey(temp))
                    tempHash = index.get(temp);
                tempHash.add(doc);

                index.put(temp, tempHash);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found");
        }
    }

        // search for the documents containing query
    public HashSet<Document> search(String query)
    {
        HashSet<Document> docList = new HashSet<>();
        if(index.containsKey(query))
            docList.addAll(index.get(query));
        return docList;
    }

    public HashMap<String, HashSet<Document>> debug() {
        return index;
    }
}
