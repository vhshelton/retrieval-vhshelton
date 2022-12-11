import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

/**
 * This is my code! Its goal is to keep track of the stop list and clean queries
 * CS 312 - Assignment 9
 * @author Victoria Shelton
 */

public class StopList {

    protected HashSet<String> stopList;

    public StopList(String filename)
    {
        stopList = new HashSet<>();
        readStopList(filename);
    }

    // Reads the stoplist file
    private void readStopList(String filename)
    {
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                stopList.add(scanner.nextLine());
            }
        }
        catch (FileNotFoundException f){
            System.out.println("File not found.");
            f.printStackTrace();
        }
    }

    // Remove stop words from a query
    public String removeStopWords(String query)
    {
        String [] dirty = query.split(" ");
        String clean = "";
        for (int i = 0; i < dirty.length; i++) {
            if (!stopList.contains(dirty[i]))
                clean = clean + " " + dirty[i];
        }
        clean = clean.strip();
        return clean;
    }
}
