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
        if(p.length()==0){
            return s.length()==0;
        }

        if(p.length() == 1){
            if(s.length()<1){
                return false;
            }else if(s.charAt(0) != p.charAt(0) && p.charAt(0)!='.'){
                return false;
            }else {
                return isMatch(s.substring(1),p.substring(1));
            }
        }
//        When the second char of p is not *
         if(p.charAt(1) != '*'){
            if(s.length()<1){
                return false;
            }
            if(s.charAt(0)!=p.charAt(0) && p.charAt(0)!='.'){
                return false;
            }else {
                return isMatch(s.substring(1),p.substring(1));
            }
        }
//        When the second char of p is *
        else{
            if(isMatch(s,p.substring(2))){
                return true;
            }
            int i=0;
            while (i<s.length()&&(s.charAt(i)==p.charAt(0)||p.charAt(0)=='.')){
                if(isMatch(s.substring(i+1),p.substring(2))){
                    return true;
                }
                i++;
            }
            return false;
        }
    }
    public static void main(String [] args){
        String A = "ab";
        String B = ".*";
        Boolean result = isMatch(A,B);
        System.out.println(result);
    }
}
