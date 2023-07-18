package com.fyw.algorithms.hot100;

import java.util.Stack;

/**
 * @Title Code20
 * @Author fyw
 * @Date 2022/5/3 11:54
 * @Description:
 */
public class Code20 {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if (c=='('||c=='['||c=='{'){
                stack.push(c);
            }else{
                if (stack.isEmpty()){
                    return false;
                }
                if (stack.peek()=='('&&c==')'){
                    stack.pop();
                }else if (stack.peek()=='['&&c==']'){
                    stack.pop();
                }else if (stack.peek()=='{'&&c=='}'){
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
