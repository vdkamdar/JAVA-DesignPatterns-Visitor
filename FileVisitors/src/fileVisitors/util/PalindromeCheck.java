/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileVisitors.util;

/**
 *
 * @author vidhi
 */
public class PalindromeCheck {

    public boolean isPalindrome(String nodeWord) {
        int i1 = 0;
        int i2 = nodeWord.length() - 1;
        String[] nodeWordArr = nodeWord.split("");
        while (i2 > i1) {
            if (nodeWordArr[i1] != nodeWordArr[i2]) {
                return false;
            }
            ++i1;
            --i2;
        }
        return true;
    }
}
