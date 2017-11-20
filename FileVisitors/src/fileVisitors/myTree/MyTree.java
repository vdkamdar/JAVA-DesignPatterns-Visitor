package fileVisitors.myTree;

import element.ElementI;
import fileVisitors.visitor.VisitorI;
import java.util.ArrayList;

/**
 * @version 4.0
 * @author Aniruddha Tekade & Vidhi Kamdar Submitted on November 8th, 2017.
 */
public class MyTree implements ElementI {

    private Node root;

    /**
     * public constructor of the class
     */
    public MyTree() {
        //MyLogger.writeMessage("Constructor called - " + this.toString(), MyLogger.DebugLevel.CONSTRUCTOR);
        root = null;
    }

    /**
     * getter method of root node
     *
     * @return
     */
    public Node getRoot() {
        return root;
    }

    /**
     * Thread-safe method for inserting the nodes.
     *
     * @param wordIn
     */
    public void insert(String wordIn) {
        //MyLogger.writeMessage("Thread is running - " + this.toString(), MyLogger.DebugLevel.WORD_INSERTION);
        if (root == null) {
            this.root = new Node(wordIn);
        } else {
            Node node = searchNode(root, wordIn);
            if (node == null) {
                insertNode(root, wordIn);
            }
        }
    }

    /**
     * Thread safe method for performing insertion operations.
     *
     * @param node
     * @param wordIn
     */
    public void insertNode(Node node, String wordIn) {
        if (node.getWord().compareTo(wordIn) > 0) {
            if (node.getLeft() == null) {
                node.setLeft(new Node(wordIn));
            } else {
                insertNode(node.getLeft(), wordIn);
            }
        } else if (node.getWord().compareTo(wordIn) < 0) {
            if (node.getRight() == null) {
                node.setRight(new Node(wordIn));
            } else {
                insertNode(node.getRight(), wordIn);
            }
        }
    }

    /**
     * Searches the particular node with the input word in the tree.
     *
     * @return Node - null if node not present, else returns the node
     */
    public Node searchNode(Node node, String wordIn) {
        if (node == null) {
            return node;
        } else if (node.getWord().compareTo(wordIn) == 0) {
            return node;
        } else if (node.getWord().compareTo(wordIn) > 0) {
            return searchNode(node.getLeft(), wordIn);
        } else {
            return searchNode(node.getRight(), wordIn);
        }
    }

    /**
     * Prints the tree words in the sorted fashion using in-order traversal.
     *
     * @param current_node
     * @param results
     */
    /**
     * Prints the final counts of the tree status.
     *
     * @param results
     */
    public void printCounts(ArrayList<String> results) {
        //results.add("The total number of words: " + String.valueOf(finalWordCount));
        //results.add("The total number of characters: " + String.valueOf(finalCharCount));
        //results.add("The total number of distinct words: " + String.valueOf(distinctWordCount));
    }

    @Override
    public String toString() {
        return "Class : wordTree.myTree.MyTree"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void accept(VisitorI visitor) {
        visitor.visit(this);
    }
}
