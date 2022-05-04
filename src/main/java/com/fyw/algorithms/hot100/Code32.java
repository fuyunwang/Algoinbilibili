package com.fyw.algorithms.hot100;

import java.util.Stack;

/**
 * @Title Code32
 * @Author fyw
 * @Date 2022/5/3 11:55
 * @Description:
 */
public class Code32 {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack=new Stack<>();
        int res=0;

        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if (stack.isEmpty()||c=='('){
                stack.push(i);
            }else{
                if (s.charAt(stack.peek())=='('){
                    stack.pop();
                    if (!stack.isEmpty()){
                        res=Math.max(res,i-stack.peek());
                    }else{
                        res=Math.max(res,i+1);
                    }
                }else{
                    stack.push(i);
                }
            }
        }

        return res;
    }
}
