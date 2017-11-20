package fileVisitors.driver;

import element.TreeBuilder;
import fileVisitors.myTree.MyTree;
import fileVisitors.store.Results;
import fileVisitors.util.FileProcessor;
import fileVisitors.util.InputProcessor;
import fileVisitors.util.Logger;
import fileVisitors.visitor.PalindromeHighlight;
import fileVisitors.visitor.PopulateVisitor;
import fileVisitors.visitor.PrimeLength;
import fileVisitors.visitor.PrintTree;
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
                        Logger.setDebugValue(debugLevel);
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
        
        PopulateVisitor pVisitor = new PopulateVisitor();
        pVisitor.setFileProcessor(fileProc);
        pVisitor.setInputProcessor(inputProc);
        tree.accept(pVisitor);
        
        PalindromeHighlight phVisitor = new PalindromeHighlight();
        tree.accept(phVisitor);
        
        PrimeLength plVisitor = new PrimeLength();
        tree.accept(plVisitor);
        
        Results results = new Results(outputFile);
        
        PrintTree ptVisitor = new PrintTree(results);
        tree.accept(ptVisitor);

        /**
         * Create instance of Results
         */
        
        results.writeToScreen();
        results.writeSchedulesToFile(tree);
    }
}
