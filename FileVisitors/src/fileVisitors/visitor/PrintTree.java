package fileVisitors.visitor;

import element.ElementI;
import fileVisitors.myTree.MyTree;
import fileVisitors.myTree.Node;
import java.util.ArrayList;

/**
 *
 * @author anirtek
 */
public class PrintTree implements VisitorI {

    MyTree tree = null;

    @Override
    public void visit(ElementI element) {
        printNodes(tree.root);//??
    }

    public void printNodes(Node current_node) {
        if (current_node == null) {
            return;
        }
        printNodes(current_node.getLeft());
        System.out.println(current_node.getWord());
        printNodes(current_node.getRight());
    }

    public MyTree getTree() {
        return tree;
    }

    public void setTree(MyTree tree) {
        this.tree = tree;
    }
}
