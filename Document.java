import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This is my code! Its goal is to keep track of a document and index it
 * CS 312 - Assignment 9
 * @author Victoria Shelton
 */


public class Document{

    protected String name;
    protected String contents;

    public Document(String filename)
    {
        try {
            File file = new File(filename);
            name = file.getName();
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String temp = scanner.nextLine();
                if(contents==null)
                    contents = temp;
                else
                    contents = contents + "\n" + temp;
            }
        }
        catch (FileNotFoundException f){
            System.out.println("File not found.");
            f.printStackTrace();
        }
    }

    public String toString() {
        return name;
    }

    public String printContents() {
        return "[" + name + "]" + " \n" + contents;
    }
}
