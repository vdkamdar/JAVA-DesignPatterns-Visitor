package fileVisitors.visitor;

import element.ElementI;
import element.TreeBuilder;
import fileVisitors.myTree.MyTree;
import fileVisitors.util.FileProcessor;
import fileVisitors.util.InputProcessor;

/**
 *
 * @author anirtek
 */
public class PopulateVisitor implements VisitorI {

    FileProcessor fp = null;
    InputProcessor ip = null;
    TreeBuilder builder = null;
    MyTree tree = null;

    @Override
    public void visit(ElementI element) {
       
        String line = "";
       
        while((line = fp.readLine()) != null){
            String[] inputParse = ip.processInput(line);
            for (int i = 0; i < inputParse.length; i++) {
                builder.insert(inputParse[i]);
            }
        }
    }

    //Setters
    public void setFileProcessor(FileProcessor fp) {
        this.fp = fp;
    }
    
    public void setInputProcessor(InputProcessor ip){
        this.ip = ip;
    }
    
    public void setTreeBuilder(TreeBuilder builder){
        this.builder = builder;
    }
    
    public void setTree(){
        this.tree = builder.getTree();
    }
    
    //Getters
    public FileProcessor getFileProcessor(){
        return fp;
    }
    
    public InputProcessor getInputProcessor(){
        return ip;
    }
    
    public TreeBuilder getTreeBuilder(){
        return builder;
    }
    
    public MyTree getTree(){
        return tree;
    }
}
