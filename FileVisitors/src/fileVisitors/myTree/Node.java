package fileVisitors.myTree;

import fileVisitors.util.Logger;

/**
 * @version 4.0
 * @author Aniruddha Tekade & Vidhi Kamdar Submitted on November 8th, 2017.
 */
public class Node {

    String word;
    int wordCount;
    int wordLength;
    Node left;
    Node right;

    /**
     * Public constructor of the class
     *
     * @param wordIn
     */
    public Node(String wordIn) {
        Logger.writeMessage("Constructor called - " + this.toString(), Logger.DebugLevel.CONSTRUCTOR);
        this.word = wordIn;
        this.wordCount = 1;
        this.left = null;
        this.right = null;
    }

    /**
     * Getter method for word in the node
     *
     * @return
     */
    public String getWord() {
        return word;
    }

    public void setWord(String newWord){
        this.word = null;
        this.word = newWord;
    }
    /**
     * Setter for storing wordCount in the tree nodes.
     *
     * @param countIn
     */
    public void setWordCount(int countIn) {
        this.wordCount = countIn;
    }

    /**
     * Getter for word count
     *
     * @return
     */
    public int getWordCount() {
        return wordCount;
    }

    /**
     * Getter for left node of the root / present working node.
     *
     * @return
     */
    public Node getLeft() {
        return left;
    }

    /**
     * Setter for left node of the root / present working node.
     *
     * @param left
     */
    public void setLeft(Node left) {
        this.left = left;
    }

    /**
     * Getter for right node of the root / present working node.
     *
     * @return
     */
    public Node getRight() {
        return right;
    }

    /**
     * Setter for right node of the root / present working node.
     *
     * @param right
     */
    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Class : wordTree.myTree.Node"; //To change body of generated methods, choose Tools | Templates.
    }

}