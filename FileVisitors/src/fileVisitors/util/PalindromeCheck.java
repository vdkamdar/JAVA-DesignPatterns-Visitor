package fileVisitors.util;

/**
 * @version 1.0
 * @author Vidhi Kamdar & Aniruddha Tekade Submitted on November 22nd, 2017.
 */
public class PalindromeCheck {

    public PalindromeCheck() {
        Logger.writeMessage("Constructor called - " + this.toString(), Logger.DebugLevel.CONSTRUCTOR);
    }
    

    public boolean isPalindrome(String nodeWord) {
        Logger.writeMessage("checking palindrome :" + this.toString(), Logger.DebugLevel.PALINDROME_CHECK);
        int i1 = 0;
        int i2 = nodeWord.length() - 1;
        //Ignores case
        String[] nodeWordArr = (nodeWord.toLowerCase()).split("");
        while (i2 > i1) {
            if (nodeWordArr[i1] != nodeWordArr[i2]) {
                return false;
            }
            ++i1;
            --i2;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Class : fileVisitors.util.PalindromeCheck";
    }
    
}
