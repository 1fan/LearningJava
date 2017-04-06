package Leetcode150_EvaluateReversePolishNotation;

import java.io.IOException;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Created by hasee on 2017/4/5.
 */
public class Solution {
    public static int evalRPN(String[] tokens) throws Exception{
        Stack<String> s = new Stack();
        for(int i=0;i<tokens.length;i++){
            if(s.empty() && !checkDigit(tokens[i])){
//                throw new Exception("Invalid Input");
                new EmptyStackException();
            }
            else if(checkDigit(tokens[i])){
                s.push(tokens[i]);
            }
            else if(!checkDigit(tokens[i])){
                if(checkOperator(tokens[i])==0){
                    throw new Exception("Invalid Operator");
                }else {
                    int a = Integer.valueOf(s.pop());
//                    if(s.empty()){
//                        throw new EmptyStackException();
////                        throw new Exception("No element to pop");
//
//                    }else {
                    try {
                        int b = Integer.valueOf(s.pop().toString());
                        String result = "";
                        switch (checkOperator(tokens[i])){
                            case 1:
                                result = a+b+"";
                                break;
                            case 2:
                                result = b-a+"";
                                break;
                            case 3:
                                result = b*a+"";
                                break;
                            case 4:
                                result = b/a+"";
                                break;
                        }
                        s.push(result);
                    }catch (Exception e){
                        e.printStackTrace();

                    }finally {

                    }
                }
            }

        }
//        if(!s.empty()){
            return Integer.valueOf(s.peek().toString());
//        }
    }

    public static int checkOperator(String s){
        switch (s){
            case "+":
                return 1;
            case "-":
                return 2;
            case "*":
                return 3;
            case "/":
                return 4;
            default:
                return 0;
        }
    }

    public static boolean checkDigit(String s){
        if(s.charAt(0) == '-'){
            if(s.substring(1,s.length()).compareTo("0") >= 0 && (s.substring(1,s.length()).compareTo("9")<=0)){
                return true;
            }
        }
        else if(s.compareTo("0") >= 0 && (s.compareTo("9")<=0)){
            return true;
        }
        else{
            return false;
        }
        return false;
    }

    public static void main(String [] args)throws Exception {
        String [] s = {"+"};
        System.out.println(evalRPN(s));
    }


}
