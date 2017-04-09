package Leetcode_WordBreak;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hasee on 2017/4/8.
 */

//Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not contain duplicate words.
//
//        For example, given
//        s = "leetcode",
//        dict = ["leet", "code"].
//
//        Return true because "leetcode" can be segmented as "leet code".

public class Solution {
    public static boolean wordBreak(String s, List<String> wordDict) {
//        Define an array t[] such that t[i]==true => 0-(i-1) can be segmented using dictionary
        boolean dp[] = new boolean[s.length()+1];
        dp[0] = true;
        for(int i=0;i<s.length();i++){
            if(dp[i] == true){
                continue;
            }
            for (String a:wordDict){
                int len = a.length();
                if(i+len>s.length()){
                    continue;
                }
                if(dp[i+len] == true){
                    continue;
                }
                if(s.substring(i,i+len).equals(a)){
                    dp[i+len] = true;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String [] args){
        String s = "Leetcode";
        List<String> dict = new ArrayList<String>();
        dict.add("Leet");
//        dict.add("et");
        dict.add("code");
        if(wordBreak(s,dict)){
            System.out.println("TRUE");
        }else {
            System.out.println("FALSE");
        }
    }
}
