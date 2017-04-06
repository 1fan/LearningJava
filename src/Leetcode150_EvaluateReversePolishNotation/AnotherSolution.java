package Leetcode150_EvaluateReversePolishNotation;

import java.util.Stack;

/**
 * Created by hasee on 2017/4/7.
 */
public class AnotherSolution {

    public static int evalRPN(String[] tokens){
        Stack<String> s = new Stack<>();
        String operator = "+-*/";
        int result = 0;
        for(String t : tokens){
            if(!operator.contains(t)){
                s.push(t);
            }else {
                int a = Integer.valueOf(s.pop());
                int b = Integer.valueOf(s.pop());
                switch (t){
                    case "+":
                        result = a+b;
                        break;
                    case "-":
                        result = b-a;
                        break;
                    case "*":
                        result = a*b;
                        break;
                    case "/":
                        try {
                            result = b/a;
                        }catch (Exception e){
                            System.out.println("DEVIDE 0");
                        }
                        break;
                }
                s.push(String.valueOf(result));
            }
        }
        return Integer.valueOf(s.pop());
    }

    public static void main(String [] args){
        String [] s = {"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(s));

    }

}
