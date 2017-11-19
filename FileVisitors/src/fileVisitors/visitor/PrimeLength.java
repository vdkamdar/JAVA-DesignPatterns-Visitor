package fileVisitors.visitor;

import element.ElementI;
import fileVisitors.myTree.MyTree;
import fileVisitors.myTree.Node;

/**
 *
 * @author anirtek
 */
public class PrimeLength implements VisitorI {

    MyTree tree = null;

    @Override
    public void visit(ElementI element) {
        traverseTree(tree.root);//??
    }

    void traverseTree(Node current_node) {
        if (current_node == null) {
            return;
        }      
        traverseTree(current_node.getLeft());
        if (isWordLengthPrime(current_node.getWord())) {
            String newWord = current_node.getWord() + "-PRIME";
            current_node.setWord(newWord);
        }
        traverseTree(current_node.getRight());
    }
    
    public boolean isWordLengthPrime(String nodeWord) {
        int length = nodeWord.length();

        if (length == 0 || length == 1) {
            return false;
        }
        for (int i = 2; i <= (length / 2); ++i) {
            if (length % i == 0) {
                return false;
            }
        }
        return true;
    }

    public MyTree getTree() {
        return tree;
    }

    public void setTree(MyTree tree) {
        this.tree = tree;
    }
}
