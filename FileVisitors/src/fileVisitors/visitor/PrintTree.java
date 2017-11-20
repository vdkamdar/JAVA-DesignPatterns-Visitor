package fileVisitors.visitor;

import element.ElementI;
import fileVisitors.myTree.MyTree;
import fileVisitors.myTree.Node;
import fileVisitors.store.Results;
import java.util.ArrayList;

/**
 *
 * @author anirtek
 */
public class PrintTree implements VisitorI {
   Results results = null;
   
    public PrintTree(Results results){
        this.results = results;
    }

    @Override
    public void visit(MyTree tree) {
        printNodes(tree.getRoot());
    }

    public void printNodes(Node current_node) {
        if (current_node == null) {
            return;
        }
        printNodes(current_node.getLeft());
        results.storeLine(current_node.getWord());
        printNodes(current_node.getRight());
    }
}
