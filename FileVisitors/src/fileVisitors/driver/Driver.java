package fileVisitors.driver;

import java.util.ArrayList;

/**
 * @version 4.0
 * @author Aniruddha Tekade & Vidhi Kamdar Submitted on November 8th, 2017.
 */
public class Driver {

    /**
     * Driver code accepts minimum 6 number of inputs. It also validates every
     * single input including filename and debug level.
     *
     * @param args
     * @throws Exception
     */
    public static void main(String args[]) throws Exception {
        String inputFile = null;
        String outputFile = null;
        int debugLevel = 0;
        try {
            if (args.length == 3) {
                inputFile = args[0];
                outputFile = args[1];
                try {
                    if (args[args.length - 1].matches(".*[0-4].*")) {
                        debugLevel = Integer.parseInt(args[args.length - 1]);
                        MyLogger.setDebugValue(debugLevel);
                    } else {
                        throw new IllegalArgumentException("The argument " + args[args.length - 1] + " is invalid. Please enter debug level between 0 and 4.");
                    }
                } catch (NumberFormatException ex) {
                    System.err.println(ex);
                }
            } else {
                throw new Exception("Three arguments expected!");
            }
        } catch (Exception ex) {
            System.err.println("Exception occurred");
            ex.printStackTrace();
            System.exit(1);
        }

        /**
         * Creating instance of the FileProcessor
         */
        FileProcessor fileProc = new FileProcessor(inputFile, outputFile);

        /**
         * Creating instance of the InputProcessor
         */
        InputProcessor inputProc = new InputProcessor();

        /**
         * Create an instance of MyTree
         */
        MyTree tree = new MyTree();

        /**
         * Create instance of Results
         */
        Results results = new Results(outputFile);

        results.writeToScreen();
        results.writeSchedulesToFile(tree);
    }
}
