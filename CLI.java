import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Objects;

/**
 * This is my code! Its goal is to run the search engine
 * CS 312 - Assignment 9
 * @author Victoria Shelton
 */

public class CLI {

    protected String[] args;

    public CLI(String[] a) {
            args = a;
        }
        protected boolean documentFlag;

        private void usage() {
            System.out.println("Usage: <stop list filename> <documents filenames> <-d> (optional)");
        }

        public void parse() {
            // If there is no argument, do it again
            if (args.length == 0) {
                usage();
                return;
            }

            // Search
            else {
                SearchEngine engine = new SearchEngine();
                long startTime = 0;

                // Take in stoplist file
                StopList stopList = new StopList(args[0]);

                // Take in document files and check for flag
                for (int i = 1; i < args.length; i++) {
                    if(Objects.equals(args[i], "-d"))
                        documentFlag = true;
                    else
                        engine.addDoc(args[i]);
                }

                // Take in queries
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                while(true) {
                    System.out.println("Enter query: ");

                    try {
                        String query = br.readLine();

                        //Start time
                        startTime = System.currentTimeMillis();

                        // debug
                        if(Objects.equals(query, "@@debug")){
                            System.out.println("Index: ");
                            System.out.println(engine.debug());
                        }
                        // terminate
                        else if (Objects.equals(query, "TERMINATE")){
                            break;
                        }
                        // search
                        else {
                            // Strip stopwords
                            query = stopList.removeStopWords(query);
                            HashSet<Document> result = engine.search(query);
                            System.out.println(query + " found in " + (result == null ? 0 : result.size() + " documents"));
                            System.out.println(result);
                            // if documentflag is true, then print the contents of each document
                            if (documentFlag) {
                                for (Document d : result) {
                                    System.out.println(d.printContents());
                                }
                            }
                        }

                    }
                    // If invalid
                    catch (IOException e) {
                        e.printStackTrace();
                        System.out.println("Invalid query, try again");
                    }

                    // Stop time
                    long stopTime = System.currentTimeMillis();
                    long elapsedTime = stopTime - startTime;
                    System.out.println("@@ search took " + elapsedTime +
                            "ms");
                }
            }
        }

    public static void main(String [] args)
    {
        CLI  c = new CLI(args);
        c.parse();
    }

}
