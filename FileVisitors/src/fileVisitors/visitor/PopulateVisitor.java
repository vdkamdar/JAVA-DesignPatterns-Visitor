package fileVisitors.visitor;

import element.ElementI;
import element.TreeBuilder;
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

    public void setFileProcessor(FileProcessor fp) {
        this.fp = fp;
    }
    
    public void setInputProcessor(InputProcessor ip){
        this.ip = ip;
    }
    
    public void setTreeBuilder(TreeBuilder builder){
        this.builder = builder;
    }
    
    public TreeBuilder getTreeBuilder(){
        return builder;
    }
}
