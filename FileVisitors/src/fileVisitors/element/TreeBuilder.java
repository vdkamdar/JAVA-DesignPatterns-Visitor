/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package element;

import fileVisitors.myTree.MyTree;
import fileVisitors.visitor.VisitorI;

/**
 *
 * @author vidhi
 */
public class TreeBuilder {

    MyTree tree = null;
    
    public void setTree(MyTree treeIn){
        this.tree = treeIn;
    }
    
    public MyTree getTree(){
        return tree;
    }

    public void insert(String wordIn) {
        this.tree.insert(wordIn);
    }
    
    public void getRoot(){
        
    }
}
