package fileVisitors.visitor;

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
    MyTree tree = null;

    @Override
    public void visit(MyTree tree) {
       
        String line = "";
       
        while((line = fp.readLine()) != null){
            String[] inputParse = ip.processInput(line);
            for (int i = 0; i < inputParse.length; i++) {
                tree.insert(inputParse[i]);
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
        
    public MyTree getTree(){
        return tree;
    }
}
