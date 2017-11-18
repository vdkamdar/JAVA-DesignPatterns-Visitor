package fileVisitors.visitor;

import element.ElementI;
import fileVisitors.myTree.MyTree;
import fileVisitors.myTree.Node;
import fileVisitors.util.PalindromeCheck;

/**
 *
 * @author vidhi
 */
public class PalindromeHighlight implements VisitorI {

    MyTree tree = null;
    PalindromeCheck check = null;

    //getTree from PopulateVisitor here or driver?
    
    @Override
    public void visit(ElementI element) {
        String line = "";
        check = new PalindromeCheck();
        traverse(tree.root);//??
    }

    void traverse(Node current_node) {
        if (current_node == null) {
            return;
        }
        
        traverse(current_node.getLeft());
        if (check.isPalindrome(current_node.getWord()) && isLengthGreaterThanThree(current_node.getWord())) {
            capitalizeWord(current_node);
        }
        traverse(current_node.getRight());
    }

    boolean isLengthGreaterThanThree(String nodeWord) {
        if (nodeWord.length() > 3) {
            return true;
        }
        return false;
    }

    void capitalizeWord(Node current_node) {
        current_node.setWord(current_node.getWord().toUpperCase());
    }

    public void setTree(MyTree tree){
        this.tree = tree;
    }
}