package Leetcode_RegularExpressionMatch;

/**
 * Created by hasee on 2017/4/25.
 *  isMatch("aa","a") → false
 isMatch("aa","aa") → true
 isMatch("aaa","aa") → false
 isMatch("aa", "a*") → true
 isMatch("aa", ".*") → true
 isMatch("ab", ".*") → true
 isMatch("aab", "c*a*b") → true
 * The DP solution.
 */
public class Solution3 {
    public static boolean isMatch(String s, String p) {
        boolean DP[][] = new boolean[s.length()+1][p.length()+1];
        DP[0][0] = true;
        for(int i=1;i<=s.length();i++){
            DP[i][0] = false;
        }
        for(int j=1;j<=p.length();j++){
            DP[0][j] = p.charAt(j-1)=='*' && DP[0][j-2] && j>1;
        }
        for(int i=1; i<s.length()+1; i++){
            for(int j=1; j<p.length()+1; j++){
                if(p.charAt(j-1) != '*'){
                    DP[i][j] = (s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='.') && DP[i-1][j-1];
                }else {
//                    if(p.charAt(j-2)==s.charAt(i-1) || p.charAt(j-2)=='.'){
//                        DP[i][j] = DP[i-1][j];
//                    }else if (p.charAt(j-2)!=s.charAt(i-1) && p.charAt(j-2)!='.'){
//                        DP[i][j] = DP[i][j-2];
//                    }
                    DP[i][j] = DP[i][j - 2] || (s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.') && DP[i - 1][j];

                }
            }
        }
        return DP[s.length()][p.length()];
    }


    public static void main(String [] args){
        String s = "aaa";
        String p = "ab*a*c*a";
        System.out.println(isMatch(s,p));
    }
}
