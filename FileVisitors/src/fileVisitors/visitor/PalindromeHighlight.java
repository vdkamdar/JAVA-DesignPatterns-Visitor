package fileVisitors.visitor;

import element.ElementI;
import element.TreeBuilder;
import fileVisitors.myTree.MyTree;
import fileVisitors.util.FileProcessor;
import fileVisitors.util.InputProcessor;
import fileVisitors.util.PalindromeCheck;

/**
 *
 * @author vidhi
 */
public class PalindromeHighlight implements VisitorI {

    FileProcessor fp = null;
    InputProcessor ip = null;
    TreeBuilder builder = null;
    MyTree tree = null;
    PalindromeCheck check = null;

    @Override
    public void visit(ElementI element) {
        String line = "";
        check = new PalindromeCheck();
        
        while ((line = fp.readLine()) != null) {
            String[] inputParse = ip.processInput(line);
            for (int i = 0; i < inputParse.length; i++) {
                if(check.isPalindrome(inputParse[i])) {
                    if(isLengthGreaterThanThree(inputParse[i])){
                        capitalizeWord(inputParse[i]);
                    }
                }
            }
        }
    }
    
    boolean isLengthGreaterThanThree(String nodeWord){
	if(nodeWord.length() > 3){
		return true;
        }
        return false;
    }
    
    void capitalizeWord(String nodeWord){   
	nodeWord.toUpperCase();
    }

}
