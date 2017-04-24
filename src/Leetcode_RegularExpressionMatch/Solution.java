package Leetcode_RegularExpressionMatch;

/**
 * Created by hasee on 2017/4/20.
 * '.' Matches any single character.
 '*' Matches zero or more of the preceding element.

 The matching should cover the entire input string (not partial).

 The function prototype should be:
 bool isMatch(const char *s, const char *p)

 Some examples:
 isMatch("aa","a") → false
 isMatch("aa","aa") → true
 isMatch("aaa","aa") → false
 isMatch("aa", "a*") → true
 isMatch("aa", ".*") → true
 isMatch("ab", ".*") → true
 isMatch("aab", "c*a*b") → true
 */
public class Solution {
    public static boolean isMatch(String s, String p) {
        if(p.length() == 0){
            return s.length()==0;
        }
        if(p.charAt(0) != '*' && p.charAt(0) != '.'){
            if(s.charAt(0) != p.charAt(0)){
                return false;
            }
        }
    }
    public static void main(String [] args){
        String A = "aa";
        String B = "a";
        Boolean result = isMatch(A,B);
        System.out.println(result);
    }
}
