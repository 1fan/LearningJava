package Leetcode_LongestPalindromicSubstring;

/**
 * Created by hasee on 2017/4/7.
 */

//?Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

//Dynamic Programing [i...j] -> [i+1...j-1]
public class Solution {
    public static String longestPalindrome(String s) {
        if(s.length() == 0){
            return "";
        }else if(s.length() == 1){
            return s;
        }
        boolean [][] dp = new boolean[s.length()][s.length()];
        int i=0,j=0;
        int index1 = 0, index2 = 0;
        for(i=0; i<s.length(); i++){
            for(j=0; j<s.length(); j++){
                if(i>=j){
                    dp[i][j] = true;
                }else {
                    dp[i][j] = false;
                }
            }
        }
        for(int k=1; k<s.length() ; k++){
            for (i=0;i<s.length()-k;i++){
                j = i + k;
                if(s.charAt(i) != s.charAt(j)){
                    dp[i][j] = false;
                }else {
                    dp[i][j] = dp[i+1][j-1];
                    if(dp[i][j]){
                        index1 = i;
                        index2 = j;
                    }
                }
            }
        }
        return s.substring(index1,index2+1);
    }

    public static void main(String [] args){
        String s = "";
        System.out.println(longestPalindrome(s));
    }

}
